package Wooper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {


    public static void main(String args[]){
        /**
         *
         *
         * RANDOM TESTING
         *
         *
        UUID id = UUID.fromString("c2ceb54c-3f7d-4522-8f82-1d0a5efaeb78");
        HypixelAPI api = new HypixelAPI(id);
        System.out.println(api.getApiKey());
        CompletableFuture<BazaarReply> baz = api.getBazaar();
        CompletableFuture<SkyBlockAuctionsReply> a= api.getSkyBlockAuctions(1);
        try {
            System.out.println(a.get().getTotalPages());
            JsonArray aucs = a.get().getAuctions();
            BufferedWriter xd = new BufferedWriter(new FileWriter("log.txt"));

            for (JsonElement jsonElement: aucs){
                xd.write(jsonElement.toString());
                xd.newLine();
                jsonElement.getAsJsonObject();


            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("error??");
        }
**/
        String testItem = "{\"uuid\":\"e9eb47aa6c164120a09470659bd33f8a\",\"auctioneer\":\"e34f913a48b84b08bdbce0362d37e307\",\"profile_id\":\"31b5991439954facae37f99838299ed7\",\"coop\":[\"e34f913a48b84b08bdbce0362d37e307\"],\"start\":1589030594573,\"end\":1589052194573,\"item_name\":\"Rapid Runaan's Bow\",\"item_lore\":\"§7Damage: §c+180 §e(+20)\\n§7Strength: §c+80 §e(+20) §8(Rapid +10)\\n§7Crit Damage: §c+50% §8(Rapid +50%)\\n\\n§9Aiming IV, §9Cubism V\\n§9Dragon Hunter III, §9Flame I\\n§9Impaling III, §9Infinite Quiver V\\n§9Piercing I, §9Power V\\n§9Snipe III, §9Telekinesis I\\n\\n§9◆ Wake Rune III\\n§8Requires level 18\\n\\n§6Item Ability: Triple Shot\\n§7Shoots 3 arrows at a time! The 2\\n§7extra arrows deal §a40%\\n§a§7percent of the damage.\\n\\n§6§lLEGENDARY BOW\",\"extra\":\"Rapid Runaan's Bow Bow Impaling Dragon Hunter Piercing Infinite Quiver Telekinesis Power Snipe Flame Aiming Cubism\",\"category\":\"weapon\",\"tier\":\"LEGENDARY\",\"starting_bid\":87095,\",\"claimed\":false,\"claimed_bidders\":[],\"highest_bid_amount\":0,\"bids\":[]}";



        String regex = "\\(\\+\\d{1,2}\\)";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("This is our pattern" + pattern.toString());
        Matcher m = pattern.matcher(testItem);

        while(m.find()){
            System.out.println(m.group());
        }

    }
}
