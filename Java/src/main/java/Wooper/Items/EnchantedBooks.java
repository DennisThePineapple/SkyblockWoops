package Wooper.Items;

import Wooper.Enchants.Enchants;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class EnchantedBooks extends Item{
    HashMap<Enchants, Integer> enchants;
    public EnchantedBooks(JsonObject item){
        super(item);
        getEnchants(item);
    }

    private void getEnchants(JsonObject item){
        // Sort the item lore to find the enchants
        enchants = new HashMap<>();
    }
}
