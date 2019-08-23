package com.textadventure.entity;

import lombok.Data;

@Data
public class Exit {
	private String direction;
	private Room destination;
}
