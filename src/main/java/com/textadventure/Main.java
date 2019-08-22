package com.textadventure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Hi there! Let's rock this");
        String input = " w walk s North";

        ArrayList<Token> tokens = Lexer.lex(input);
        for (Token token : tokens)
          log.info(token.toString());
    }
}