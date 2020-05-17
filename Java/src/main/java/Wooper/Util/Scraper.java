package Wooper.Util;

import Wooper.Items.ItemsManager;
import com.google.gson.JsonArray;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.skyblock.SkyBlockAuctionsReply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class Scraper {

    public static void scrape(UUID key){
        HypixelAPI api = new HypixelAPI(key);
        JsonArray auctions = new JsonArray();
        CompletableFuture<SkyBlockAuctionsReply> initial = api.getSkyBlockAuctions(0);
        ItemsManager itemsManager = ItemsManager.get();
        // Wait till we get the first page
        while (!initial.isDone()) {
        }

        // Get total pages in the auction
        int totalPages = 0;
        try {
            itemsManager.addItems(initial.get().getAuctions());
            totalPages = initial.get().getTotalPages();
            auctions.addAll(initial.get().getAuctions());
        } catch (Exception e) {
            System.out.println("a catastrophe has occurred");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        // Make a request for all pages + 1 just in case more auctions are added
        // Throttle api calls
        totalPages = 4;
        ArrayList<CompletableFuture<SkyBlockAuctionsReply>> auctionRequests = new ArrayList<>();
        for (int page = 1; page < totalPages + 1; page++) {
            CompletableFuture<SkyBlockAuctionsReply> auctionPage = api.getSkyBlockAuctions(page);
            auctionRequests.add(auctionPage);
        }
        // While we are waiting on requests, remove completed requests and parse old ones
        while (!auctionRequests.isEmpty()) {
            Iterator<CompletableFuture<SkyBlockAuctionsReply>> iterator = auctionRequests.iterator();
            while (iterator.hasNext()) {
                CompletableFuture<SkyBlockAuctionsReply> auctionRequest = iterator.next();
                if (auctionRequest.isDone()) {
                    try {
                        itemsManager.addItems(auctionRequest.get().getAuctions());
                        iterator.remove();
                        System.out.println("Requests remaining = " + auctionRequests.size());
                    }
                    // TODO add proper error handling here

                    // This shouldn't happen egg dee
                    catch (Exception bad) {
                        iterator.remove();
                        if (bad.getMessage().equals("net.hypixel.api.exceptions.HypixelAPIException: Page not found")){
                            break;
                        }
                        else {
                            System.out.println(bad.getMessage());
                            System.exit(1);
                        }
                    }
                }
            }
        }
        System.out.println("Requests complete");
    }
}
