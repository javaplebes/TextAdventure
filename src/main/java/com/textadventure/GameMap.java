package com.textadventure;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Slf4j
public @Data class GameMap {

	private int commanderCounter;
	private boolean gameOver;
	private final String INTROTEXT = "Welcome to the game!";
	private final String OUTROTEXT = "Thanks For playing!";
	private final String FILENAME = "path to Dungeon.json";
	private Player player;
	public Territory[] Territorys;

	public GameMap(int numberOfTerritorys) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// TODO: config for this filename?
			Map<String, Object> map = mapper.readValue(new File(FILENAME), new TypeReference<Map<String, Object>>(){});
			/*	Territorys <= map.get("map")
			 * 	player <= map.get("player")
			*/
		}catch (IOException error) {
			log.error("Problem reading file {}: ",FILENAME, error);
		}
	}
	public void copyTerritory(Territory[] src, Territory[] dest){
		
	}
}
