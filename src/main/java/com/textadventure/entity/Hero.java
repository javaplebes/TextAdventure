package com.textadventure.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Hero extends LivingEntity {
	private List<Item> inventory;
	private List<StatusEffect> buffs;
	private List<StatusEffect> debuffs;
}
