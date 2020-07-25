package Wooper.Items;

import com.google.gson.JsonObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Wooper.Items.Tiers.*;

public class Pet extends Item {
    //Tiers petTier;
    private int level;
    public Pet (JsonObject item){
        super(item);
        //petTier = this.findTier(item);
        level = this.findLevel(item);
    }

/**
 * Hypixel API changed pet tiers to work correctly
 */
@Deprecated
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

    private int findLevel(JsonObject item){
        String regex = "\\[Lvl \\d{1,3}]";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(getItemName());
        if (m.find()){
            return Integer.parseInt(m.group().replaceAll("\\D", ""));
        }
        else {
            return 1;
        }
    }

    public int getLevel(){
        return level;
    }
}
