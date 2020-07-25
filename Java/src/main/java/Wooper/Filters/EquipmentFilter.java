package Wooper.Filters;

import Wooper.Items.Equipment;
import Wooper.Items.Tiers;

public class EquipmentFilter extends Filter{
    private int hpBooks;
    public EquipmentFilter(int hpBooks, String itemName, Tiers tier, int priceMin, int priceMax,
                  int timeRemaining, boolean bin)  {
        super(itemName,  tier,  priceMin,  priceMax,
                timeRemaining, bin);
        if (hpBooks < 0 || hpBooks >10){
            this.hpBooks = 0;
        }
        this.hpBooks = hpBooks;
    }

    public int getHpBooks() {
        return hpBooks;
    }

    public void setHpBooks(int hpBooks) {
        this.hpBooks = hpBooks;
    }

    public boolean apply(Equipment equipment){
        if (super.apply(equipment)){
            if (equipment.getHpBooks() >= this.getHpBooks()){
                return true;
            }
        }
        return false;
    }
}
