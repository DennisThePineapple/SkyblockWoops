package Wooper.Items;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    void setup() {
        JsonObject item;
        Gson gson = new Gson();
        String testBow = "{\"uuid\":\"e9eb47aa6c164120a09470659bd33f8a\",\"auctioneer\":\"e34f913a48b84b08bdbce0362d37e307\",\"profile_id\":\"31b5991439954facae37f99838299ed7\",\"coop\":[\"e34f913a48b84b08bdbce0362d37e307\"],\"start\":1589030594573,\"end\":1589052194573,\"item_name\":\"Rapid Runaan's Bow\",\"item_lore\":\"§7Damage: §c+180 §e(+20)\\n§7Strength: §c+80 §e(+20) §8(Rapid +10)\\n§7Crit Damage: §c+50% §8(Rapid +50%)\\n\\n§9Aiming IV, §9Cubism V\\n§9Dragon Hunter III, §9Flame I\\n§9Impaling III, §9Infinite Quiver V\\n§9Piercing I, §9Power V\\n§9Snipe III, §9Telekinesis I\\n\\n§9◆ Wake Rune III\\n§8Requires level 18\\n\\n§6Item Ability: Triple Shot\\n§7Shoots 3 arrows at a time! The 2\\n§7extra arrows deal §a40%\\n§a§7percent of the damage.\\n\\n§6§lLEGENDARY BOW\",\"extra\":\"Rapid Runaan's Bow Bow Impaling Dragon Hunter Piercing Infinite Quiver Telekinesis Power Snipe Flame Aiming Cubism\",\"category\":\"weapon\",\"tier\":\"LEGENDARY\",\"starting_bid\":87095,\"item_bytes\":\"H4sIAAAAAAAAAE1T7U4TQRS9pS1uFxUSxcRozBglQBDpF7DF+GNpS9kIBdsC8VczbW/bCbuzy+4syAv4Cj5C36OP4oMY72yrsn925p5zv8+YADlICRMAUguwIAapbAqyVT+WKmVCWvFRDjIo+2PQXwqWLmQvRH7Ney6m0pA7FgM8cvkoIvS3CY8GIgpcfk9OJ36IBlmfwavpZL/GPT7CAzad9LcKVp7+uLFVzG/CFoFtFaIcqfEMfoDSwdpo8UAM2FaByOtEroZCsYfhdvNrD3l03aS0L6eTii08IUfMufxAhEo17onIY5egL7WQj3zJjqlPDJnjOAmFOvGQObBGZ8cLuJu4z0FHDoUUCtnXWNyS02WS41xg2E9oCencv0ugN3RuSxHgP/cOungtJEYiogwAz8n26+cPdsWvkbVimTC11WrhTSxCjJiLt+iygkXs19PJnqPQY3ZPuELdH7BOKAIXWXvsK3inhzj2fRWxEuNh6N9FjCvGmRIevmWdMbJisgb8rkL+lzFA7lJlvJxf0/E54QE1g1Ixf8gUOQ2SMX/UW6T804l7Um/UmzW79Y0dnl0ZkGnSvGCVsNnwqQ3O5XrEDv07MGG5rtPZSoWiFyuM0rBC1XYDX3Hld/taZBTaNCEbUv8EZ67sL3UypcGAp0Q9T5iHvowjeNHutOrNRuf4czH/qWaf2o26PhlgeP5ADGkNFEZXYUDOD8VIyA4fwWq1ZR91nGaj22g5tW717OSkXu0YWumw1Lpo2naz3aVeTHisVc6l8qh/KsUQ8/3rctLwZJAIpjtOBDOzGcF89/plpGFZzAXSvUkEQtZsGpbU/73PeNlAa2SGZiOtkVm47FCrb8ZZ5Il06ZKhSz9RrvaguWTimGp/v7eft6xyYX+7Uq7sbpdxWNru9bC0XeFYtIp5q1LCYRpMLm+F240j1MmXaTRaEZHiXgAr1k6hvFOosELxoFRg9inAAizOXpZ+7H8AhfEdQRsEAAA=\",\"claimed\":false,\"claimed_bidders\":[],\"highest_bid_amount\":0,\"bids\":[]}";
        item = gson.fromJson(testBow, JsonObject.class);


    }
    @Test
    void test(){
        setup();
    }
}