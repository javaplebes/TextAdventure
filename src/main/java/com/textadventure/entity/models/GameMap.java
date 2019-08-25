package com.textadventure.entity.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GameMap extends BaseEntity {
	private String introText;
	private String outroText;
	public List<Room> rooms;
}
