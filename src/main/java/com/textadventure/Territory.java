package com.textadventure;
import lombok.Data;

public @Data class Territory {
	private String displayName;
	private boolean firstVisit;
	private String description;
	private Item Item[];
	private Exit Exits[];
	
		
}
