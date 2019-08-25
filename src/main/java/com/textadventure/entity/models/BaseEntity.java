package com.textadventure.entity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity{
    @NonNull protected String id;
    protected String displayName;
    protected String description;
}
