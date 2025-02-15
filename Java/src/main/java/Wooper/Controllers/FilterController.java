package Wooper.Controllers;

import Wooper.Filters.EquipmentFilter;
import Wooper.Filters.Filter;
import Wooper.Filters.PetFilter;
import Wooper.Items.ItemsManager;
import Wooper.Util.TierAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilterController {


    @GetMapping("/addfilter")
    public void filter(
            @RequestParam(name = "filterGroup") String filterGroup,
            @RequestParam(name = "filterType") String filterType,
            @RequestParam(name = "itemName", required = false) String itemName,
            @RequestParam(name = "tier", required = false) String tier,
            @RequestParam(name = "priceMin", required = false) String priceMin,
            @RequestParam(name = "priceMax", required = false) String priceMax,
            @RequestParam(name = "timeRemaining", required = false) String timeRemaining,
            @RequestParam(name = "bin", required = false) String bin,
            @RequestParam(name = "petLevel", required = false) String petLevel,
            @RequestParam(name = "hpBooks", required = false) String hpBooks,
            Model model) {
        System.out.println("Recieved Filter Request");
        model.addAttribute("name", filterType);
        try {
            if (filterType.equals("pet")) {
                PetFilter filter = new PetFilter();
                if (itemName != null) {
                    filter.setItemName(itemName);
                }
                if (tier != null) {
                    filter.setTier(TierAdapter.findTier(tier));
                }
                if (priceMin != null) {
                    filter.setPriceMin(Integer.parseInt(priceMin));
                }
                if (priceMax != null) {
                    filter.setPriceMax(Integer.parseInt(priceMax));
                }
                if (timeRemaining != null) {
                    filter.setPriceMax(Integer.parseInt(timeRemaining));
                }
                if (bin != null) {
                    if (bin.equals("t")) {
                        filter.setBin(true);
                    } else filter.setBin(false);
                }
                System.out.println("Filter added Succesfully");

            } else if (filterType.equals("equipment")) {
                EquipmentFilter filter = new EquipmentFilter();
                if (itemName != null) {
                    filter.setItemName(itemName);
                }
                if (tier != null) {
                    filter.setTier(TierAdapter.findTier(tier));
                }
                if (priceMin != null) {
                    filter.setPriceMin(Integer.parseInt(priceMin));
                }
                if (priceMax != null) {
                    filter.setPriceMax(Integer.parseInt(priceMax));
                }
                if (timeRemaining != null) {
                    filter.setPriceMax(Integer.parseInt(timeRemaining));
                }
                if (bin != null) {
                    if (bin.equals("t")) {
                        filter.setBin(true);
                    } else filter.setBin(false);
                }

            } else {
                Filter filter = new Filter();
                if (itemName != null) {
                    filter.setItemName(itemName);
                }
                if (tier != null) {
                    filter.setTier(TierAdapter.findTier(tier));
                }
                if (priceMin != null) {
                    filter.setPriceMin(Integer.parseInt(priceMin));
                }
                if (priceMax != null) {
                    filter.setPriceMax(Integer.parseInt(priceMax));
                }
                if (timeRemaining != null) {
                    filter.setPriceMax(Integer.parseInt(timeRemaining));
                }
                if (bin != null) {
                    if (bin.equals("t")) {
                        filter.setBin(true);
                    } else filter.setBin(false);
                }

            }
        }
        catch (Exception e){
            System.out.println(e);
        }



    }

    @GetMapping("/getauctions")
    public void getAuctions(Model model){
        System.out.println("Request to see auctions");
        try {
            /**
            String xd = "";
            ItemsManager itemsManager = ItemsManager.get();
            StringBuilder stringBuilder = new StringBuilder();
            for (Item i: itemsManager.getItems()){
                stringBuilder.append(i.toString());
                stringBuilder.append("\n\n");
            }
            **/
            ItemsManager itemsManager = ItemsManager.get();
            model.addAttribute("items", itemsManager.getItems());
        }
        catch (Exception e){
            System.out.println(e);
        }


    }



}
