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
    private boolean bin;


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
        bin = !(item.get("bin") == null || item.get("bin").getAsString().equals("false"));
    }

    public UUID getAuctionID() {
        return auctionID;
    }

    public UUID getSeller() {
        return seller;
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
            case "MYTHIC":
                return MYTHIC;
            default:
                return SPECIAL;
        }
    }

    public int getCurrentBid() {
        return currentBid;
    }

    /**
     * Gets the time remaining in the auction
     *
     * @return How long until the auction is complete
     */
    public int secondsRemaining() {
        return Math.round((endTime - System.currentTimeMillis())/1000f);
    }

    @Override
    public String toString() {
        String itemString;
        itemString = "Item Name:" + itemName +
                ", Price: " + currentBid +
                ", Tier:" + tier +
                ", Time Remaining:" + secondsRemaining();
        return itemString;
    }
}
