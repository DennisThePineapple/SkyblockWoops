package Wooper.User;

import Wooper.Filters.FilterGroup;

import java.util.*;

public class User {
    private UUID key;
    private Map<String, FilterGroup> filterGroups;
    public User(UUID key){
        this.key = key;
        this.filterGroups = new HashMap<>();
    }

    public Map<String, FilterGroup> getFilters() {
        return this.filterGroups;
    }

    public void addFilters(FilterGroup filter) {
        filterGroups.put(filter.getName(), filter);
    }

    public UUID getKey() {
        return key;
    }
}
