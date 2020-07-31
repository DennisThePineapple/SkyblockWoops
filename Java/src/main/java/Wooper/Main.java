package Wooper;

import Wooper.Items.ItemsManager;
import Wooper.Util.Scraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {

        System.out.println("Starting Service");
        try {
            SpringApplication.run(Main.class, args);
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(340);
        }
        UUID key = UUID.fromString("74827e82-e00d-4771-9f3d-b0b8995fbf92");
        Scraper.scrape(key);
        ItemsManager itemsManager = ItemsManager.get();



    }

}

