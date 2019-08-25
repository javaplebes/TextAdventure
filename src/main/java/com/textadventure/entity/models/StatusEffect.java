package com.textadventure.entity.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class StatusEffect extends BaseEntity{
    public Stats stats;
}
