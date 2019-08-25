package com.textadventure.loader;

import com.textadventure.entity.models.Stats;

public class StatsCalculator {
    public static Stats populateStats(Stats stats){
        stats.setHealth(stats.getStrength()*100);
        stats.setMana(stats.getIntelligence()*12);
        stats.setArmor((float) (stats.getArmor()+(stats.getAgility()*0.16)));
        stats.setAura(stats.getAura()+(stats.getStrength()*2));
        return stats;
    }
}
