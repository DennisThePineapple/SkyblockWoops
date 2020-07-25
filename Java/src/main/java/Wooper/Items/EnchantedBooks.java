package Wooper.Items;

import Wooper.Enchants.Enchants;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class EnchantedBooks extends Item{
    private HashMap<Enchants, Integer> enchants;



    private String itemLore;
    public EnchantedBooks(JsonObject item){
        super(item);
        getEnchants(item);
        itemLore = item.get("item_lore").getAsString();
    }

    private void getEnchants(JsonObject item){
        // Sort the item lore to find the enchants
        enchants = new HashMap<>();
    }


    public HashMap<Enchants, Integer> getEnchants() {
        return enchants;
    }

    public String getItemLore() {
        return itemLore;
    }

}
