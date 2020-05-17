package Wooper;
import Wooper.Items.Item;
import Wooper.Items.ItemsManager;
import Wooper.Util.Scraper;
import java.util.UUID;


public class Main {
    public static void main(String args[]) {
        // Chuck in your api key here
        UUID key = UUID.fromString("c2ceb54c-3f7d-4522-8f82-1d0a5efaeb78");
        Scraper.scrape(key);
        ItemsManager itemsManager = ItemsManager.get();



    }
}

