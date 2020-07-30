package Wooper.Filters;

import Wooper.Items.Pet;

public class PetFilter extends Filter{

    private int level;
    public PetFilter() {
        setActive(true);

    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean apply(Pet pet){
        if (super.apply(pet)){
            return pet.getLevel() >= level;
        }
        return false;
    }
}
