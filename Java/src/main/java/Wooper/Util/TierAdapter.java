package Wooper.Util;

import Wooper.Items.Tiers;

import static Wooper.Items.Tiers.*;

public class TierAdapter {
    public static Tiers findTier(String tier){
        switch (tier) {
            case "COMMON":
                return COMMON;
            case "UNCOMMON":
                return UNCOMMON;
            case "RARE":
                return RARE;
            case "EPIC":
                return EPIC;
            case "LEGENDARY":
                return LEGENDARY;
            case "MYTHIC":
                return MYTHIC;
            default:
                return SPECIAL;
        }
    }
}
