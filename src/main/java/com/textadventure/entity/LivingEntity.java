package com.textadventure.entity;

import com.textadventure.IGameObject;
import lombok.Data;

@Data
public class LivingEntity extends BaseEntity implements IGameObject {

	private float health;
	private float strength;
	private float defence;
	private Room location;
	
	public void input() {
		
	}

	public void render() {
		
	}

	public void update() {
		
	}

}
