package com.textadventure.entity.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Enemy extends LivingEntity {

    private List<Skill> skills;

    @Override
    public void input() {

    }

    @Override
    public void render() {

    }

    @Override
    public void update() {

    }
}
