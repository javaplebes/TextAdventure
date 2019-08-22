package com.textadventure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void testMain() {
        Assert.assertEquals(true, true);
    }
    @Test
    public void testOutputToken() {
    	String inputTest = " W S North run walk D ";
    	Lexer lexer = new Lexer();
    	ArrayList<Token> tokens = lexer.lex(inputTest);
    	String output = "";
    	for (Token token : tokens)
    		output += token.type + " ";
        assertTrue(output.contains("MOVEMENT"));
        assertTrue(output.contains("DIRECTION"));
        assertTrue(output.contains("WALK"));
        assertTrue(output.contains("RUN"));
    }
    @Test
    public void testOutputNumberOfWords() {
    	String inputTest = " W S North run walk D ";
    	Lexer lexer = new Lexer();
    	ArrayList<Token> tokens = lexer.lex(inputTest);
    	assertEquals(6, tokens.size());
    }
    
}
