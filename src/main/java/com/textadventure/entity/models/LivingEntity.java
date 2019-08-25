package com.textadventure.entity.models;

import com.textadventure.IGameObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class LivingEntity extends BaseEntity implements IGameObject {

	protected Stats stats;
	protected Room location;

	abstract public void input();

	abstract public void render();

	abstract public void update();

}
