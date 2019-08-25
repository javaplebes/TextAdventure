package com.textadventure.entity.models;

import com.textadventure.loader.GameLoader;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Item extends BaseEntity{
    private float attackDamage;
    private Stats stats;
    private List<StatusEffect> buffs;

    public void setBuffs(List<String> buffList) {
        for (String statusEffectId: buffList)
        {
            buffs.add(GameLoader.getStatusEffect(statusEffectId));
        }
    }

    /*public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        if(stats!=null) stringBuilder.append("\nStats: ").append(stats.toString());
        if(attackDamage>0) stringBuilder.append("\nAttack Damage: ").append(attackDamage);
        if(CollectionUtils.isNotEmpty(buffs)) stringBuilder.append("\nBuffs: ").append(buffs.toString());
        return stringBuilder.toString();
    }*/

}
