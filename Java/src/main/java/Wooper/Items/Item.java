package Wooper.Items;

import Wooper.Util.StringtoUUID;
import com.google.gson.*;

import java.util.UUID;

import static Wooper.Items.Tiers.*;

public class Item {
    private UUID auctionID;
    private UUID seller;
    private long endTime;
    private String itemName;
    private String tier;
    private int currentBid;
    int secondsRemaining;

    public Item(JsonObject item) {
        auctionID = StringtoUUID.convert(item.get("uuid").getAsString());
        seller = StringtoUUID.convert(item.get("auctioneer").getAsString());
        endTime = item.get("end").getAsLong();
        itemName = item.get("item_name").getAsString();
        tier = item.get("tier").getAsString();
        currentBid = item.get("highest_bid_amount").getAsInt();
        if (currentBid == 0) {
            currentBid = item.get("starting_bid").getAsInt();
        }
        secondsRemaining = this.secondsRemaining();
    }

    public UUID getAuctionID() {
        return auctionID;
    }

    public UUID getSeller() {
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
    public int secondsRemaining() {
        return Math.round((endTime - System.currentTimeMillis())/1000f);
    }

    public void updateItem(JsonObject item) {
        this.currentBid = item.get("highest_bid_amount").getAsInt();
        if (this.currentBid == 0) {
            this.currentBid = item.get("starting_bid").getAsInt();
        }
        this.secondsRemaining = Math.round((item.get("end").getAsLong() - System.currentTimeMillis())/1000f);
    }
}
