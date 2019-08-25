package com.textadventure.entity.models;

import lombok.Data;

@Data
public class Stats {
    private float health;
    private float mana;
    private float armor;
    private float aura;
    private float luck;
    private float strength;
    private float agility;
    private float intelligence;

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        if(health>0) stringBuilder.append("\nHealth: ").append(health);
        if(mana>0) stringBuilder.append("\nMana: ").append(mana);
        if(armor>0) stringBuilder.append("\nArmor: ").append(armor);
        if(aura>0) stringBuilder.append("\nAura: ").append(aura);
        if(luck>0) stringBuilder.append("\nLuck: ").append(luck);
        if(strength>0) stringBuilder.append("\nStrength: ").append(strength);
        if(agility>0) stringBuilder.append("\nAgility: ").append(agility);
        if(intelligence>0) stringBuilder.append("\nIntelligence: ").append(intelligence);
        return stringBuilder.toString();
    }
}
