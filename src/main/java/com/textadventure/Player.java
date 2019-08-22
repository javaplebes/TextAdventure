package com.textadventure;
import lombok.Data;


public @Data class Player extends LivingEntity{
	private Item inventory[];
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
