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

    public Filter() {
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

    public void setTier(Tiers tier){
        this.tier = tier;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        if (priceMin > priceMax || priceMin == -1) {
            this.priceMin = 0;
        }
        else {
            this.priceMin = priceMin;
        }
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        if (priceMax == -1 || priceMax < priceMin) {
            this.priceMax = Integer.MAX_VALUE;
        }
        else {
            this.priceMax = priceMax;
        }
    }
    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        if (timeRemaining < 1) {
            timeRemaining = Integer.MAX_VALUE;
        }
        else {
            this.timeRemaining = timeRemaining;
        }
    }

    public boolean apply(Item item) {
        if (itemName != null) {
            return item.getItemName().contains(this.itemName);
        }
        else if (item.secondsRemaining() > this.timeRemaining) {
            return false;
        }
        else if (this.tier != IGNORE){
            return this.tierCheck(item.getTier());
        }
        else return item.getCurrentBid() < priceMax && item.getCurrentBid() > priceMin;
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
