package Wooper.Items;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class ItemsManagerTest {



    @Test
    void regexTest() {
        String regex = "(?<=EPIC |UNCOMMON |RARE |LEGENDARY |COMMON )(CHESTPLATE|BOOTS|LEGGINGS|HELMET)";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher("EPIC BO");
        assertTrue(!m.find());
        m = pattern.matcher("EC HELMET");
        assertTrue(!m.find());
        m = pattern.matcher("EPIC BOOTS");
        assertTrue(m.find());
        m = pattern.matcher("LEGENDARY CHESTPLATE");
        assertTrue(m.find());
        m = pattern.matcher("COMMON B");
        assertTrue(!m.find());
    }
}