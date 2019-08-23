package com.textadventure;

import com.textadventure.entity.Token;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Hi there! Let's rock this");
        String input = " w walk s North";

        ArrayList<Token> tokens = Lexer.lex(input);
        for (Token token : tokens)
          log.info(token.toString());
    }
}