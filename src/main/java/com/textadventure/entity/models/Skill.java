package com.textadventure.entity.models;

import com.textadventure.loader.GameLoader;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Skill extends BaseEntity{
    private List<String> attributes = new ArrayList<>();
    private float value;
    private float multiplier;
    private float manaCost;
    private List<StatusEffect> buffs = new ArrayList<>();
    private List<StatusEffect> debuffs = new ArrayList<>();

    public void setBuffs(List<String> buffList) {
        for (String statusEffectId: buffList)
        {
            buffs.add(GameLoader.getStatusEffect(statusEffectId));
        }
    }

    public void setDebuffs(List<String> debuffList) {
        for (String statusEffectId: debuffList)
        {
            debuffs.add(GameLoader.getStatusEffect(statusEffectId));
        }
    }

}
