package com.textadventure.entity.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Exit extends BaseEntity{
	private String direction;
	private Room destination;
}
