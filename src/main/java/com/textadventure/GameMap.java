package com.textadventure;

import lombok.Data;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public @Data class GameMap {
	
	private int commanderCounter;
	private boolean gameOver;
	private final String INTROTEXT = "Welcome to the game!";
	private final String OUTROTEXT = "Thanks For playing!";
	private Player player;
	public Territory[] Territorys;
	
	public GameMap(int numberOfTerritorys) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> map = mapper.readValue(new File("path to Dungeon.json"), new TypeReference<Map<String, Object>>(){});
			/*	Territorys <= map.get("map")
			 * 	player <= map.get("player")
			*/
		}catch (Exception error) {
			System.out.println(error);
		}
	}
	public void copyTerritory(Territory[] src, Territory[] dest){
		
	}
}
