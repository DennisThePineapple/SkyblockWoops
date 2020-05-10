package net.hypixel.api.Wooper.Items;

import com.google.gson.*;

public class Item {
    String auctionID;
    String seller;
    long startTime;
    long endTime;
    String itemName;
    String tier;
    public Item(JsonObject item){
        auctionID = item.get("uuid").getAsString();
        seller = item.get("auctioneer").getAsString();
        startTime = item.get("start").getAsLong();
        endTime = item.get("end").getAsLong();
        itemName = item.get("item_name").getAsString();
        tier = item.get("tier").getAsString();
    }
}
