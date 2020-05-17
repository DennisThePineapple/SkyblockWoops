package Wooper.Items;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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


    private ItemsManager() {
        items = new ArrayList<>();
        armours = new ArrayList<>();
        enchantedBooks = new ArrayList<>();
        pets = new ArrayList<>();
        weapons = new ArrayList<>();
    }

    public static ItemsManager get() {
        if (itemsManager == null) {
            itemsManager = new ItemsManager();
        }
        return itemsManager;
    }

    public void addItems(JsonArray jsonArray) {
        long startTime = System.currentTimeMillis();

        StreamSupport
                .stream(jsonArray.spliterator(), false)
                .forEach(jsonElement -> {
                    JsonObject item = jsonElement.getAsJsonObject();
                    if (checkPet(item)) {
                        pets.add(new Pet(item));
                        return;
                    } else if (checkBook(item)) {
                        enchantedBooks.add(new EnchantedBooks(item));
                        return;
                    } else if (checkArmour(item)) {
                        armours.add(new Armour(item));
                        return;
                    } else if (checkWeapon(item)) {
                        weapons.add(new Weapon(item));
                        return;
                    } else {
                        items.add(new Item(item));
                    }
                });
        // For loop implementation
        /**
         for (JsonElement jsonElement : jsonArray) {
         JsonObject item = jsonElement.getAsJsonObject();
         if (checkPet(item)) {
         pets.add(new Pet(item));
         } else if (checkBook(item)) {
         enchantedBooks.add(new EnchantedBooks(item));
         } else if (checkArmour(item)) {
         armours.add(new Armour(item));
         } else if (checkWeapon(item)) {
         weapons.add(new Weapon(item));
         } else {
         items.add(new Item(item));
         }
         }
         **/
        System.out.println("Adding array took " + (System.currentTimeMillis() - startTime) + "ms");
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

    public List<Item> getAllItems() {
        List<Item> allItems = new ArrayList<>(items);
        allItems.addAll(weapons);
        allItems.addAll(armours);
        allItems.addAll(enchantedBooks);
        allItems.addAll(pets);
        return allItems;
    }

    private boolean checkPet(JsonObject jsonObject) {
        return Pattern.compile("\\[Lvl \\d{1,3}]").matcher(jsonObject.get("item_name").getAsString()).find();
    }

    private boolean checkBook(JsonObject jsonObject) {
        return (jsonObject.get("item_name").getAsString().equals("Enchanted Book"));
    }

    private boolean checkArmour(JsonObject jsonObject) {

        return Pattern.compile("(?<=EPIC |UNCOMMON |RARE |LEGENDARY |COMMON )(CHESTPLATE|BOOTS|LEGGINGS|HELMET)")
                .matcher(jsonObject.get("item_lore").getAsString()).find();
    }

    private boolean checkWeapon(JsonObject jsonObject) {
        return Pattern.compile("(?<=EPIC |UNCOMMON |RARE |LEGENDARY |COMMON )(SWORD|BOW|MAGIC WEAPON)")
                .matcher(jsonObject.get("item_lore").getAsString()).find();
    }
}
