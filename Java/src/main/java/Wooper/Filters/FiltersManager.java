package Wooper.Filters;

import Wooper.Items.Equipment;
import Wooper.Items.Item;
import Wooper.Items.ItemsManager;
import Wooper.Items.Pet;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FiltersManager {
    private Set<Filter> filters;
    private Set<Filter> itemFilters;
    private Set<PetFilter> petFilters;
    private Set<EquipmentFilter> equipmentFilters;
    private Set<BookFilter> bookFilters;
    private Set<Item> filteredItems;
    private String name;
    private ItemsManager itemsManager;

    public FiltersManager(String name){
        this.name = name;
        filteredItems = new HashSet<>();
        filters = new HashSet<>();
        petFilters = new HashSet<>();
        equipmentFilters = new HashSet<>();
        bookFilters = new HashSet<>();
        itemFilters = new HashSet<>();
        this.name = name;
        itemsManager = ItemsManager.get();
    }

    public Set<Item> getFilteredItems() {
        return filteredItems;
    }

    public void addFilter(Filter filter){
        filters.add(filter);

    }


    public void addPetFilter(PetFilter petFilter){
        petFilters.add(petFilter);
    }

    public void addEquipmentFilter(EquipmentFilter equipmentFilter){
        equipmentFilters.add(equipmentFilter);
    }

    public void applyFilters(){
        filters.forEach(filter ->{
            itemsManager.getAllItems().forEach(item -> {
                if (filter.apply(item)){
                    filteredItems.add(item);
                }
            });
        });

        itemFilters.forEach(filter ->{
            itemsManager.getItems().forEach(item -> {
                if (filter.apply(item)){
                    filteredItems.add(item);
                }
            });
        });

        petFilters.forEach(filter ->{
            itemsManager.getPets().forEach(item -> {
                if (filter.apply(item)){
                    filteredItems.add(item);
                }
            });
        });

        equipmentFilters.forEach(filter ->{
            itemsManager.getArmours().forEach(item -> {
                if (filter.apply(item)){
                    filteredItems.add(item);
                }
            });
            itemsManager.getWeapons().forEach(item -> {
                if (filter.apply(item)){
                    filteredItems.add(item);
                }
            });
        });

        bookFilters.forEach(filter ->{
            itemsManager.getEnchantedBooks().forEach(item -> {
                if (filter.apply(item)){
                    filteredItems.add(item);
                }
            });
        });

    }

}
