package Wooper.Items;

import com.google.gson.JsonObject;

public abstract class Equipment extends Item{
    public Equipment(JsonObject item){
        super(item);
    }
    public abstract int getHpBooks();
}
