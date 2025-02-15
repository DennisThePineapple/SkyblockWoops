package net.hypixel.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.hypixel.api.adapters.BoostersTypeAdapterFactory;
import net.hypixel.api.adapters.DateTimeTypeAdapter;
import net.hypixel.api.adapters.GameTypeTypeAdapter;
import net.hypixel.api.adapters.UUIDTypeAdapter;
import net.hypixel.api.exceptions.APIThrottleException;
import net.hypixel.api.exceptions.HypixelAPIException;
import net.hypixel.api.reply.*;
import net.hypixel.api.reply.skyblock.*;
import net.hypixel.api.util.GameType;
import net.hypixel.api.util.ResourceType;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HypixelAPI {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(UUID.class, new UUIDTypeAdapter())
            .registerTypeAdapter(GameType.class, new GameTypeTypeAdapter())
            .registerTypeAdapter(ZonedDateTime.class, new DateTimeTypeAdapter())

            .registerTypeAdapterFactory(new BoostersTypeAdapterFactory<>(BoostersReply.Booster.class))

            .create();
    private static final String BASE_URL = "https://api.hypixel.net/";

    private final UUID apiKey;

    private final ExecutorService executorService;
    private final HttpClient httpClient;

    public HypixelAPI(UUID apiKey) {
        this.apiKey = apiKey;

        this.executorService = Executors.newCachedThreadPool();
        this.httpClient = HttpClientBuilder.create().build();
    }

    public CompletableFuture<SkyBlockAuctionsReply> getSkyBlockAuctions(int page) {
        return get(SkyBlockAuctionsReply.class, "skyblock/auctions", "page", page);
    }



    /**
     * Retrieve resources which don't change often.
     *
     * @param resource to be requested
     * @return CompletableFuture with resource reply
     */
    public CompletableFuture<ResourceReply> getResource(ResourceType resource) {
        return getResource(resource.getPath());
    }

    /**
     * Requests information about products in bazaar.
     *
     * @return CompletableFuture with BazaarReply
     */
    public CompletableFuture<BazaarReply> getBazaar() {
        return get(BazaarReply.class, "skyblock/bazaar");
    }

    public CompletableFuture<ResourceReply> getResource(String resource) {
        return requestResource(resource);
    }

    /**
     * Execute Request asynchronously, executes Callback when finished
     *
     * @param request Request to get
     */
    // TODO use a map of string to object?
    private <R extends AbstractReply> CompletableFuture<R> get(Class<R> clazz, String request, Object... params) {
        CompletableFuture<R> future = new CompletableFuture<>();
        try {
            if (params.length % 2 != 0)
                throw new IllegalArgumentException("Need both key and value for parameters");

            StringBuilder url = new StringBuilder(BASE_URL);

            url.append(request);
            url.append("?key=").append(apiKey);

            for (int i = 0; i < params.length - 1; i += 2) {
                url.append("&").append(params[i]).append("=").append(params[i + 1]);

            }
            System.out.println(url);

            executorService.submit(() -> {
                try {
                    R response = httpClient.execute(new HttpGet(url.toString()), obj -> {
                        String content = EntityUtils.toString(obj.getEntity(), "UTF-8");
                        if (clazz == ResourceReply.class) {
                            return (R) new ResourceReply(GSON.fromJson(content, JsonObject.class));
                        } else {
                            return GSON.fromJson(content, clazz);
                        }
                    });

                    checkReply(response);

                    future.complete(response);

                } catch (Throwable t) {
                    future.completeExceptionally(t);
                    System.out.println(url);
                }
            });
        } catch (Throwable throwable) {
            future.completeExceptionally(throwable);
        }
        return future;
    }

    private CompletableFuture<ResourceReply> requestResource(String resource) {
        CompletableFuture<ResourceReply> future = new CompletableFuture<>();
        try {
            StringBuilder url = new StringBuilder(BASE_URL);
            url.append("resources/").append(resource);

            executorService.submit(() -> {
                try {
                    ResourceReply response = httpClient.execute(new HttpGet(url.toString()), obj -> {
                        String content = EntityUtils.toString(obj.getEntity(), "UTF-8");
                        return new ResourceReply(GSON.fromJson(content, JsonObject.class));
                    });

                    checkReply(response);

                    future.complete(response);
                } catch (Throwable t) {
                    future.completeExceptionally(t);
                }
            });
        } catch (Throwable throwable) {
            future.completeExceptionally(throwable);
        }
        return future;
    }

    /**
     * Checks reply and throws appropriate exceptions based on it's content
     *
     * @param reply The reply to check
     * @param <T>   The class of the reply
     */
    private <T extends AbstractReply> void checkReply(T reply) {
        if (reply != null) {
            if (reply.isThrottle()) {
                throw new APIThrottleException();
            } else if (!reply.isSuccess()) {
                throw new HypixelAPIException(reply.getCause());
            }
        }
    }
}
