package net.hypixel.api.Wooper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.skyblock.BazaarReply;
import net.hypixel.api.reply.skyblock.SkyBlockAuctionsReply;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

public class Main {


    public static void main(String args[]){
        /**
        UUID id = UUID.fromString("c2ceb54c-3f7d-4522-8f82-1d0a5efaeb78");
        HypixelAPI api = new HypixelAPI(id);
        System.out.println(api.getApiKey());
        CompletableFuture<BazaarReply> baz = api.getBazaar();
        CompletableFuture<SkyBlockAuctionsReply> a= api.getSkyBlockAuctions(1);
        while (!a.isDone()){

        }
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
        long xd = 1589036277977L;
        Date date = new Date(xd*1000);
        System.out.println(date.toString());

    }
}
