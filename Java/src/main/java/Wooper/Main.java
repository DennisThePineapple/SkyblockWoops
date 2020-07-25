package Wooper;
import Wooper.Items.Item;
import Wooper.Items.ItemsManager;
import Wooper.Util.Scraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String args[]) {

        // Chuck in your api key here
        UUID key = UUID.fromString("c2ceb54c-3f7d-4522-8f82-1d0a5efaeb78");
        Scraper.scrape(key);
        ItemsManager itemsManager = ItemsManager.get();

        SpringApplication.run(Main.class, args);

    }
    @GetMapping("/getAuctions")
    public String getAuctions(){
        String xd = "";
        ItemsManager itemsManager = ItemsManager.get();
        for (Item i: itemsManager.getItems()){
            xd += i.toString();
            xd += "\n";
        }
        System.out.println("Request to see auctions");
        return xd;
    }
}

