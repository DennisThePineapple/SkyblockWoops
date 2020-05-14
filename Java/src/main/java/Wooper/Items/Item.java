package Wooper.Items;

import com.google.gson.*;

import static Wooper.Items.Tiers.*;

public class Item {
    String auctionID;
    String seller;
    long endTime;
    String itemName;
    String tier;
    int currentBid;
    long secondsRemaining;

    public Item(JsonObject item) {
        auctionID = item.get("uuid").getAsString();
        seller = item.get("auctioneer").getAsString();
        endTime = item.get("end").getAsLong();
        itemName = item.get("item_name").getAsString();
        tier = item.get("tier").getAsString();
        currentBid = item.get("highest_bid_amount").getAsInt();
        if (currentBid == 0) {
            currentBid = item.get("starting_bid").getAsInt();
        }
        secondsRemaining = this.secondsRemaining();
    }

    public String getAuctionID() {
        return auctionID;
    }

    public String getSeller() {
        return seller;
    }

    public long getEndTime() {
        return endTime;
    }

    public String getItemName() {
        return itemName;
    }

    public Tiers getTier() {
        switch (tier) {
            case "COMMON":
                return COMMON;
            case "UNCOMMON":
                return UNCOMMON;
            case "RARE":
                return RARE;
            case "EPIC":
                return EPIC;
            case "LEGENDARY":
                return LEGENDARY;
            default:
                return SPECIAL;
        }
    }


    /**
     * Gets the time remaining in the auction
     *
     * @return
     */
    public long secondsRemaining() {
        return endTime - System.currentTimeMillis();
    }

    public void updateItem(JsonObject item) {
        this.currentBid = item.get("highest_bid_amount").getAsInt();
        if (this.currentBid == 0) {
            this.currentBid = item.get("starting_bid").getAsInt();
        }
        this.secondsRemaining = item.get("end").getAsLong() - System.currentTimeMillis();
    }
}
