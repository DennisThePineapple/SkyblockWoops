package Wooper.Filters;
import Wooper.Items.Tiers;

public class Filter{

    String itemName;
    Tiers tier;
    int priceMin;
    int priceMax;
    int timeRemaining;



    boolean active;

    public Filter(String itemName, Tiers tier, int priceMin, int priceMax,
                  int timeRemaining)  {

        this.itemName = itemName;
        this.tier = tier;
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.timeRemaining = timeRemaining;

        if (priceMin > priceMax || priceMin == -1){
            this.priceMin = 0;
        }
        if (priceMax == -1 || priceMax < priceMin){
            this.priceMax = Integer.MAX_VALUE;
        }
        if (timeRemaining <1){
            timeRemaining = Integer.MAX_VALUE;
        }
        active = true;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Tiers getTier() {
        return tier;
    }

    public void setTier(Tiers tier) {
        this.tier = tier;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }
}
