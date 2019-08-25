package com.textadventure.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.textadventure.entity.models.BaseEntity;
import com.textadventure.entity.models.Hero;
import com.textadventure.entity.models.Item;
import com.textadventure.entity.models.Skill;
import com.textadventure.entity.models.StatusEffect;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GameLoader {

    public static Map<GameFileType, Map<String, Object>> gamefiles = new HashMap<>();

    public enum GameFileType {
        heroes,
        items,
        skills,
        statusEffects,
        interactables,
        enemies;
    }

    public GameLoader(String gameMap)
    {
        gamefiles.put(GameFileType.statusEffects,loadGameFiles(GameFileType.statusEffects, gameMap, StatusEffect.class));
        gamefiles.put(GameFileType.skills,loadGameFiles(GameFileType.skills, gameMap, Skill.class));
        gamefiles.put(GameFileType.items,loadGameFiles(GameFileType.items, gameMap, Item.class));
        gamefiles.put(GameFileType.heroes,loadGameFiles(GameFileType.heroes, gameMap, Hero.class));
    }

    public static <T> Map<String, Object> loadGameFiles(GameFileType gameFileType, String gameMap, Class<T> clazz){
        Map<String, Object> fileMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            String fileLocation = "maps/" + gameMap + "/"+gameFileType.name()+".json";

            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            fileLocation = String.valueOf(classloader.getResource(fileLocation).getFile());
            File file = new File(fileLocation);

            FileReader reader = new FileReader(file);
            JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();

            JavaType type = objectMapper.getTypeFactory().constructParametricType(HashMap.class,String.class,clazz);
            fileMap = objectMapper.readValue(jsonObject.toString(),type);

        }catch (Exception e)
        {
            log.error(e.getMessage());
        }
        return fileMap;
    }

    public static StatusEffect getStatusEffect(String statusEffectId) {
        return (StatusEffect) gamefiles.get(GameFileType.statusEffects).get(statusEffectId);
    }

    public static Skill getSkill(String skillId) {
        return (Skill) gamefiles.get(GameFileType.skills).get(skillId);
    }

    public static Item getItem(String itemId) {
        return (Item) gamefiles.get(GameFileType.items).get(itemId);
    }

    public static Hero getHero(String heroId) {
        return (Hero) gamefiles.get(GameFileType.heroes).get(heroId);
    }

    public static List<Hero> getHeroList(){
        List<Hero> heroList = new ArrayList<>();
        Map<String, Object> heroMap = gamefiles.get(GameFileType.heroes);
        heroMap.values().forEach(hero -> {
            heroList.add(((Hero)hero));
        });
        return heroList;
    }


}
