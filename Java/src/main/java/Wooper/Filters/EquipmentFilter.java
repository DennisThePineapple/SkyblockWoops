package Wooper.Filters;

import Wooper.Items.Equipment;

public class EquipmentFilter extends Filter{
    private int hpBooks;
    public EquipmentFilter()  {
        setActive(true);
    }

    public int getHpBooks() {
        return hpBooks;
    }

    public void setHpBooks(int hpBooks) {
        if (hpBooks < 0 || hpBooks >15){
            this.hpBooks = 0;
        }
        else {
            this.hpBooks = hpBooks;
        }
    }

    public boolean apply(Equipment equipment){
        if (super.apply(equipment)){
            return equipment.getHpBooks() >= this.getHpBooks();
        }
        return false;
    }
}
