package com.textadventure;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

	public enum TokenType {
		MOVEMENT(" w | a | s | d "), WALK("walk"), RUN("run"), DIRECTION("North|South|East|West"),
		WHITESPACE("[ \t\f\r\n]+");
		public final String pattern;

		private TokenType(String pattern) {
			this.pattern = pattern;
		}
	}

	public static ArrayList<Token> lex(String input) {
		// The tokens to return
		ArrayList<Token> tokens = new ArrayList<>();

		// Lexer logic begins here
		StringBuffer tokenPatternsBuffer = new StringBuffer();
		for (TokenType tokenType : TokenType.values())
			tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
		Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));

		// Begin matching tokens
		Matcher matcher = tokenPatterns.matcher(input);
		while (matcher.find()) {
			if (matcher.group(TokenType.MOVEMENT.name()) != null) {
				tokens.add(new Token(TokenType.MOVEMENT, matcher.group(TokenType.MOVEMENT.name())));
				continue;
			} else if (matcher.group(TokenType.WALK.name()) != null) {
				tokens.add(new Token(TokenType.WALK, matcher.group(TokenType.WALK.name())));
				continue;
			} else if (matcher.group(TokenType.RUN.name()) != null) {
				tokens.add(new Token(TokenType.RUN, matcher.group(TokenType.RUN.name())));
				continue;
			} else if (matcher.group(TokenType.DIRECTION.name()) != null) {
				tokens.add(new Token(TokenType.DIRECTION, matcher.group(TokenType.DIRECTION.name())));
				continue;
			} else if (matcher.group(TokenType.WHITESPACE.name()) != null)
				continue;
		}

		return tokens;
	}
}