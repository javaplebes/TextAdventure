package com.textadventure;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class LexerTest {

	@Test
	public void testOutputToken() {
		String inputTest = "North run walk";
		ArrayList<Token> tokens = Lexer.lex(inputTest);
		StringBuilder output = new StringBuilder();
		for (Token token : tokens)
			output.append(token);
		assertTrue(output.toString().contains("DIRECTION"));
		assertTrue(output.toString().contains("WALK"));
		assertTrue(output.toString().contains("RUN"));
	}

	@Test
	public void testOutputNumberOfWords() {
		String inputTest = "North run walk";
		ArrayList<Token> tokens = Lexer.lex(inputTest);
		int numberOfWords = 0;
		for (Token token : tokens)
			numberOfWords++;

		assertEquals(3, tokens.size());
	}
}