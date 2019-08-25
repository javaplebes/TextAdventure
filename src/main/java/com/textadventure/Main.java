package com.textadventure;

import com.textadventure.entity.models.Hero;
import com.textadventure.loader.GameLoader;
import com.textadventure.misc.ConsoleColors;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class Main {

    public static void main(String[] args) {
        GameLoader gameLoader = new GameLoader("vault");

        List<Hero> heroList = GameLoader.getHeroList();
        System.out.println("Available heroes: "+ ConsoleColors.GREEN);
        int heroCounter=1;
        for (Hero hero: heroList)
        {
            System.out.println("\n"+heroCounter+" "+hero.getId());
            heroCounter++;
        }
        System.out.println(ConsoleColors.RESET + "\n\nChoose your hero: ");

        Scanner scanner = new Scanner(System.in);
        String heroId = scanner.nextLine();
        System.out.println(GameLoader.getHero(heroId).toString());
    }
}