package Wooper.Items;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ItemsManager {

    private List<Item> items;
    private List<Armour> armours;
    private List<EnchantedBooks> enchantedBooks;
    private List<Pet> pets;
    private List<Weapon> weapons;
    private static ItemsManager itemsManager = null;
    private Pattern pattern;
    private Matcher m;
    private ItemsManager(){
        items = new ArrayList<>();
        armours = new ArrayList<>();
        enchantedBooks = new ArrayList<>();
        pets = new ArrayList<>();
        weapons = new ArrayList<>();
    }

    public static ItemsManager get(){
        if (itemsManager == null){
            itemsManager = new ItemsManager();
        }
        return itemsManager;
    }

    public void addItems(JsonArray jsonArray){
        StreamSupport
                .stream(jsonArray.spliterator(), false)
                .forEach(jsonElement ->{
                    JsonObject item = jsonElement.getAsJsonObject();
                    String regex = "\\[\\d{1,3}]";
                    pattern = Pattern.compile(regex);
                    if (pattern.matcher(item.get("item_name").getAsString()).find()){
                        pets.add(new Pet(item));
                        return;
                    }
                    items.add(new Item(item));
                });
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Armour> getArmours() {
        return armours;
    }

    public List<EnchantedBooks> getEnchantedBooks() {
        return enchantedBooks;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }
}
