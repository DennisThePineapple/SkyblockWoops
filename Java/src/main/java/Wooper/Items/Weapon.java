package Wooper.Items;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weapon extends Equipment {
    int hpBooks;
    public Weapon (JsonObject item){
        super(item);
        hpBooks = this.parsehpBooks(item.get("item_lore").getAsString());
    }

    private int parsehpBooks(String itemLore){
        String regex = "\\(\\+\\d{1,2}\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(itemLore);
        List<Integer> values = new ArrayList<>();
        int index = 0;
        while(m.find()){
            values.add(Integer.parseInt(m.group().replaceAll("\\D", "")));
            index++;
        }
        if (index == 0){
            return 0;
        }
        return Collections.max(values)/2;
    }

    @Override
    public int getHpBooks(){
        return hpBooks;
    }

}
