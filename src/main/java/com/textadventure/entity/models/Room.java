package com.textadventure.entity.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Room extends BaseEntity {

	public enum RoomAttribute {
		COMMON("common"),
		TRAP("trap"),
		PUZZLE("puzzle"),
		START("start"),
		EXIT("exit"),
		RESPAWN("respawn");

		private String attribute;
		RoomAttribute(String attribute){
			this.attribute = attribute;
		}
	}

	private boolean isVisited;
	private List<RoomAttribute> attributes;
	private List<Item> items;
	private List<Interactable> interactables;
	private List<Enemy> enemies;
	private List<Hero> heroes;
	private List<Exit> exits;
}
