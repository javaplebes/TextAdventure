package com.textadventure;

import lombok.Data;

public @Data class GameMap {
	
	private int commanderCounter;
	private boolean gameOver;
	private final String INTROTEXT = "Welcome to the game!";
	private final String OUTROTEXT = "Thanks For playing!";
	private Player player;
	public Territory[] Territorys;
	
	public GameMap(int numberOfTerritorys) {
		player = new Player();
		Territorys = new Territory[numberOfTerritorys];
		commanderCounter = 0;
		gameOver = false;
	}
	
}
