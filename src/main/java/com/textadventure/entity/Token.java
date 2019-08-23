package com.textadventure.entity;

import com.textadventure.Lexer.TokenType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Token {
	
	private TokenType type;
    private String data;

    @Override
    public String toString() {
      return String.format("(%s %s)", type.name(), data);
    }
}