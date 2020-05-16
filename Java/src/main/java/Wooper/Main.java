package Wooper;

import Wooper.Items.ItemsManager;
import com.google.gson.JsonArray;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.exceptions.HypixelAPIException;
import net.hypixel.api.reply.skyblock.SkyBlockAuctionsReply;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class Main {


    public static void main(String args[]) {
        // Chuck in your api key here
        UUID key = UUID.fromString("c2ceb54c-3f7d-4522-8f82-1d0a5efaeb78");
        HypixelAPI api = new HypixelAPI(key);
        JsonArray auctions = new JsonArray();
        CompletableFuture<SkyBlockAuctionsReply> initial = api.getSkyBlockAuctions(70);
        ItemsManager itemsManager = ItemsManager.get();
        // Wait till we get the first page
        while (!initial.isDone()) {
        }
        // Get total pages in the auction
        int totalPages = 0;
        try {
            initial.get().getAuctions();
            totalPages = initial.get().getTotalPages();
            auctions.addAll(initial.get().getAuctions());
        } catch (Exception e) {
            System.out.println("a catastrophe has occurred");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        // Make a request for all pages + 1 just in case more auctions are added
        ArrayList<CompletableFuture<SkyBlockAuctionsReply>> auctionRequests = new ArrayList<>();
        for (int page = 1; page < totalPages + 1; page++) {
            auctionRequests.add(api.getSkyBlockAuctions(page));
        }
        // While we are waiting on requests, remove completed requests and parse old ones
        while (!auctionRequests.isEmpty()) {
            for (CompletableFuture<SkyBlockAuctionsReply> auctionRequest : auctionRequests) {
                if (auctionRequest.isDone()) {
                    try {
                        itemsManager.addItems(auctionRequest.get().getAuctions());
                    }
                    // TODO add proper error handling here
                    catch (HypixelAPIException e) {
                        continue;
                    }
                    // This shouldn't happen egg dee
                    catch (Exception bad){
                        System.out.println(bad.getMessage());
                        System.exit(1);
                    }
                    auctionRequests.remove(auctionRequest);
                }
            }
        }
    }
}
