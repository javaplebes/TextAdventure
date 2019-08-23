package com.textadventure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity{
    @NonNull private String id;
    private String displayName;
    private String description;
}
