package com.textadventure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @DisplayName("Single dummy test")
    @Test
    void dummyTest() {
         assertTrue(true);
    }
}
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class LexerTest {

	@Test
	void testOutputToken() {
		String inputTest = "North run walk";
		ArrayList<Token> tokens = Lexer.lex(inputTest);
		String output = "";
		for (Token token : tokens)
			output += token.type + " ";
		assertTrue(output.contains("DIRECTION"));
		assertTrue(output.contains("WALK"));
		assertTrue(output.contains("RUN"));
	}

	@Test
	public void testOutputNumberOfWords() {
		String inputTest = "North run walk";
		ArrayList<Token> tokens = Lexer.lex(inputTest);
		int numberOfWords = 1;
		for (Token token : tokens)
			numberOfWords++;

		assertEquals(3, tokens.size());
	}
}
>>>>>>> 2379c5d31875271667c3eed689ccf1d115ff8d03
