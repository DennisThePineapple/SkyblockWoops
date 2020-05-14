package Wooper.Items;

import com.google.gson.JsonObject;

import static Wooper.Items.Tiers.*;

public class Pet extends Item {
    Tiers petTier;
    public Pet (JsonObject item){
        super(item);
    }

    private Tiers findTier(JsonObject item){
        String itemLore = item.get("item_lore").getAsString();
        if (itemLore.contains("COMMON")){
            return COMMON;
        }
        else if (itemLore.contains("UNCOMMON")){
            return UNCOMMON;
        }
        else if (itemLore.contains("RARE")){
            return RARE;
        }
        else if (itemLore.contains("EPIC")){
            return EPIC;
        }
        else if (itemLore.contains("LEGENDARY")){
            return LEGENDARY;
        }
        else {
            return SPECIAL;
        }
    }
}
