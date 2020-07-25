package Wooper.Items;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    /**
     * Rewrite this pile of gargage later xo
     */
    @Test
    void levelTest(){
        String valid = "[Lvl 1] Blue Whale";
        String regex = "\\[Lvl \\d{1,3}]";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(valid);
        m.find();
        assertEquals(Integer.parseInt(m.group().replaceAll("\\D", "")), 1);
        String xd = "Item Name:Titanic Heavy Chestplate ✪✪✪✪✪, Price: 1500000Tier:EPICTime Remaining:171380";
    }
}