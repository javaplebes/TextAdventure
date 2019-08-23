package com.textadventure.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Player extends LivingEntity {
	private Item[] inventory;
	private int inventoryCount;
	private int inventoryLength;
	
	public boolean addItem(Item item) {
		if(inventoryCount < inventoryLength) {
			inventory[inventoryCount++] = item;
			return true;
		}
		return false;
	}
	public void deleteItem(int index) {
		inventory[index] = null;
	}
}
