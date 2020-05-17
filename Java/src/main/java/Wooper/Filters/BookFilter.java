package Wooper.Filters;

import Wooper.Items.Tiers;

public class BookFilter extends Filter{
    public BookFilter(String itemName, Tiers tier, int priceMin, int priceMax,
                      int timeRemaining){
        super(itemName,  tier,  priceMin,  priceMax,
         timeRemaining);
    }
}
