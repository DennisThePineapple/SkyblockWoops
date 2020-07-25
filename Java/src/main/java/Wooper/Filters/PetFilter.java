package Wooper.Filters;

import Wooper.Items.Pet;
import Wooper.Items.Tiers;

public class PetFilter extends Filter{

    int level;
    public PetFilter(String itemName, Tiers tier, int priceMin, int priceMax,
                     int timeRemaining, int level, boolean bin) {
        super(itemName, tier, priceMin, priceMax,
                timeRemaining, bin);
        this.level = level;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean apply(Pet pet){
        if (super.apply(pet)){
            if (pet.getLevel() >= level){
                return true;
            }
        }
        return false;
    }
}
