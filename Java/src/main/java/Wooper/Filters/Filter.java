package Wooper.Filters;

import Wooper.Items.Item;
import Wooper.Items.Tiers;

import static Wooper.Items.Tiers.*;

public class Filter {

    private String itemName;
    private Tiers tier;
    private int priceMin;
    private int priceMax;
    private int timeRemaining;
    private boolean active;
    private boolean bin;

    public Filter(String itemName, Tiers tier, int priceMin, int priceMax,
                  int timeRemaining, boolean bin) {
        this.itemName = itemName;
        this.tier = tier;
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.timeRemaining = timeRemaining;
        this.bin = bin;

        if (priceMin > priceMax || priceMin == -1) {
            this.priceMin = 0;
        }
        if (priceMax == -1 || priceMax < priceMin) {
            this.priceMax = Integer.MAX_VALUE;
        }
        if (timeRemaining < 1) {
            timeRemaining = Integer.MAX_VALUE;
        }
        active = true;
    }

    public void setActive(boolean active) {
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

    public boolean apply(Item item) {
        if (itemName != null) {
            if (!item.getItemName().contains(this.itemName)) {
                return false;
            }
        }
        else if (item.secondsRemaining() > this.timeRemaining) {
            return false;
        }
        else if (this.tier != IGNORE){
            if (!this.tierCheck(item.getTier())){
                return false;
            }
        }
        else if (item.getCurrentBid() >= priceMax || item.getCurrentBid() <= priceMin){
            return false;
        }
        return true;
    }

    private boolean tierCheck(Tiers itemTier){
        switch (tier){
            case COMMON:
                if (itemTier == COMMON){
                    return true;
                }
            case UNCOMMON:
                if (itemTier == COMMON || itemTier == UNCOMMON){
                    return true;
                }
            case RARE:
                if (itemTier == COMMON || itemTier == UNCOMMON || itemTier == RARE){
                    return true;
                }
            case EPIC:
                if (itemTier == COMMON || itemTier == UNCOMMON || itemTier == RARE || itemTier == EPIC){
                    return true;
                }
            case LEGENDARY:
                if (itemTier == COMMON || itemTier == UNCOMMON || itemTier == RARE || itemTier == EPIC || itemTier == LEGENDARY){
                    return true;
                }
            case SPECIAL:
                if (itemTier == SPECIAL){
                    return true;
                }
                default:
                    return false;
        }
    }

    public boolean isBin() {
        return bin;
    }

    public void setBin(boolean bin) {
        this.bin = bin;
    }
}
