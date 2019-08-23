package com.textadventure;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

	public enum TokenType {
		WALK("walk"), RUN("run"), DIRECTION("North|South|East|West");
		public final String pattern;

		TokenType(String pattern) {
			this.pattern = pattern;
		}
	}

	public static ArrayList<Token> lex(String input) {
		// The tokens to return
		ArrayList<Token> tokens = new ArrayList<Token>();

		// Lexer logic begins here
		StringBuilder tokenPatternsBuilder = new StringBuilder();
		for (TokenType tokenType : TokenType.values())
<<<<<<< HEAD
			tokenPatternsBuilder.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
		Pattern tokenPatterns = Pattern.compile(tokenPatternsBuilder.substring(1));

		for (String word : input.split(" ")) {
			// Begin matching tokens
			Matcher matcher = tokenPatterns.matcher(word);
			while (matcher.find()) {
				if (matcher.group(TokenType.WALK.name()) != null) {
					tokens.add(new Token(TokenType.WALK, matcher.group(TokenType.WALK.name())));
					continue;
				} else if (matcher.group(TokenType.RUN.name()) != null) {
					tokens.add(new Token(TokenType.RUN, matcher.group(TokenType.RUN.name())));
					continue;
				} else if (matcher.group(TokenType.DIRECTION.name()) != null) {
					tokens.add(new Token(TokenType.DIRECTION, matcher.group(TokenType.DIRECTION.name())));
				}
			}
=======
			tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
		Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));
		
		for(String word: input.split(" ")) {
		// Begin matching tokens
		Matcher matcher = tokenPatterns.matcher(word);
		while (matcher.find()) {
			 if (matcher.group(TokenType.WALK.name()) != null) {
				tokens.add(new Token(TokenType.WALK, matcher.group(TokenType.WALK.name())));
				continue;
			} else if (matcher.group(TokenType.RUN.name()) != null) {
				tokens.add(new Token(TokenType.RUN, matcher.group(TokenType.RUN.name())));
				continue;
			} else if (matcher.group(TokenType.DIRECTION.name()) != null) {
				tokens.add(new Token(TokenType.DIRECTION, matcher.group(TokenType.DIRECTION.name())));
				continue;
			}
		}
>>>>>>> 2379c5d31875271667c3eed689ccf1d115ff8d03
		}
		return tokens;
	}
}