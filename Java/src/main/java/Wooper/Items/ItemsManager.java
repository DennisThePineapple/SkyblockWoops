package Wooper.Items;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

public class ItemsManager {

    private HashMap<UUID, Item> items;
    private HashMap<UUID, Armour> armours;
    private HashMap<UUID, EnchantedBooks> enchantedBooks;
    private HashMap<UUID, Pet> pets;
    private HashMap<UUID, Weapon> weapons;
    private HashMap<UUID, Item> itemDict;
    private static ItemsManager itemsManager = null;


    private ItemsManager() {
        items = new HashMap<>();
        armours = new HashMap<>();
        enchantedBooks = new HashMap<>();
        pets = new HashMap<>();
        weapons = new HashMap<>();

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
                        Pet pet = new Pet(item);
                        pets.put(pet.getAuctionID(), pet);
                    } else if (checkBook(item)) {
                        EnchantedBooks enchantedBook = new EnchantedBooks(item);
                        enchantedBooks.put(enchantedBook.getAuctionID(), enchantedBook);
                    } else if (checkArmour(item)) {
                        Armour armour = new Armour(item);
                        armours.put(armour.getAuctionID(), armour);
                    } else if (checkWeapon(item)) {
                        Weapon weapon = new Weapon(item);
                        weapons.put(weapon.getAuctionID(), weapon);
                    } else {
                        Item item1 = new Item(item);
                        items.put(item1.getAuctionID(), item1);
                    }
                });
        // For loop implementation
        /**
         for (JsonElement jsonElement : jsonArray) {
         JsonObject item = jsonElement.getAsJsonObject();
         if (checkPet(item)) {
         pets.add(new et(item));
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
        return new ArrayList<>(this.items.values());
    }

    public List<Armour> getArmours() {
        return new ArrayList<>(armours.values());
    }

    public List<EnchantedBooks> getEnchantedBooks() {
        return new ArrayList<>(enchantedBooks.values());
    }

    public List<Pet> getPets() {
        return new ArrayList<>(pets.values());
    }

    public List<Weapon> getWeapons() {
        return new ArrayList<>(weapons.values());
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
