package com.textadventure;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi there! Let's rock this");
        String input = "W walk W S S South ";
        Lexer lexer = new Lexer();
        ArrayList<Token> tokens = lexer.lex(input);
        for (Token token : tokens)
          System.out.println(token);
    }
}