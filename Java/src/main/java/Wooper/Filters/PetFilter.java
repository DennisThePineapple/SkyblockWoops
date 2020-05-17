package Wooper.Filters;

import Wooper.Items.Tiers;

public class PetFilter extends Filter{
    Tiers petTier;
    int level;
    public PetFilter(String itemName, Tiers tier, int priceMin, int priceMax,
                     int timeRemaining, Tiers petTier, int level) {
        super(itemName, tier, priceMin, priceMax,
                timeRemaining);
        this.level = level;
        this.petTier = petTier;
    }

    public Tiers getPetTier() {
        return petTier;
    }

    public void setPetTier(Tiers petTier) {
        this.petTier = petTier;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
