package com.textadventure.entity.models;

import com.textadventure.loader.GameLoader;
import com.textadventure.loader.StatsCalculator;
import com.textadventure.misc.ConsoleColors;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Hero extends LivingEntity {
	public enum ClassType {
		Fighter,
		WarMage,
		Hunter;
	}

	private ClassType classType;
	private List<Item> inventory = new ArrayList<>();
	private List<StatusEffect> buffs = new ArrayList<>();
	private List<StatusEffect> debuffs = new ArrayList<>();
	private List<Skill> skills = new ArrayList<>();

	@Override
	public void input() {

	}

	@Override
	public void render() {

	}

	@Override
	public void update() {

	}

	public void setInventory(List<String> items){
		for (String itemId: items)
		{
			inventory.add(GameLoader.getItem(itemId));
		}
	}

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

	public void setSkills(List<String> skillList) {
		for (String skillId: skillList)
		{
			skills.add(GameLoader.getSkill(skillId));
		}
	}

	public void setStats(Stats stats)
	{
		this.stats = StatsCalculator.populateStats(stats);
	}

	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\nHero: ").append(displayName);
		if(StringUtils.isNotBlank(description)) stringBuilder.append("\nLore: ").append(description);
		stringBuilder.append("\nClass: ").append(classType.name());
        stringBuilder.append("\n---------------------------------------------------------------------");
        if(stats!=null) stringBuilder.append("\nStats: ").append(ConsoleColors.YELLOW).append(stats.toString()).append(ConsoleColors.RESET);
        stringBuilder.append("\n---------------------------------------------------------------------");
		if(CollectionUtils.isNotEmpty(inventory)){
		    stringBuilder.append("\nInventory: ").append(ConsoleColors.CYAN);
		    for (Item item: inventory)
            {
                stringBuilder.append("\n").append(item.getDisplayName());
            }
		    stringBuilder.append(ConsoleColors.RESET);
        }
        stringBuilder.append("\n---------------------------------------------------------------------");
        if(CollectionUtils.isNotEmpty(skills)){
            stringBuilder.append("\nSkills: ").append(ConsoleColors.RED_BRIGHT);
            for (Skill skill: skills)
            {
                stringBuilder.append("\n").append(skill.getDisplayName());
            }
            stringBuilder.append(ConsoleColors.RESET);
        }
        stringBuilder.append("\n---------------------------------------------------------------------");
        return stringBuilder.toString();
	}
}
