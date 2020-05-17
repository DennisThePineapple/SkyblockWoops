package Wooper.Filters;

import Wooper.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class FiltersManager {
    private List<Filter> filters;
    private List<Item> filteredItems;
    private String name;
    public FiltersManager(String name){
        this.name = name;
        filteredItems = new ArrayList<>();
        filters = new ArrayList<>();
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public List<Item> getFilteredItems() {
        return filteredItems;
    }

    public void addFilter(Filter filter){
        if (!filters.contains(filter)){
            filters.add(filter);
        }
    }

    public void applyFilters(){
        filters.forEach(x ->{
            //if
        });
    }
}
