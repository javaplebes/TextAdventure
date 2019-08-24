package com.textadventure;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;

@Slf4j
public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
        log.info("Hi there! Let's rock this");
        String input = " w walk s North";

        ArrayList<Token> tokens = Lexer.lex(input);
        for (Token token : tokens)
          log.info(token.toString());
=======
        System.out.println("Hi there! Let's rock this");
>>>>>>> 2379c5d31875271667c3eed689ccf1d115ff8d03
    }
}