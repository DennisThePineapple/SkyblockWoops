package Wooper.Items;

import com.google.gson.JsonObject;


import java.util.ArrayList;
import java.util.List;

public class ItemsManager {

    List<Item> items;
    List<Armour> armours;
    List<EnchantedBooks> enchantedBooks;
    List<Pet> pets;
    List<Weapon> weapons;

    private ItemsManager(){
        items = new ArrayList<>();
        armours = new ArrayList<>();
        enchantedBooks = new ArrayList<>();
        pets = new ArrayList<>();
        weapons = new ArrayList<>();
    }

    public ItemsManager get(){
        return this;
    }

    public void addItem(JsonObject jsonObject){

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
