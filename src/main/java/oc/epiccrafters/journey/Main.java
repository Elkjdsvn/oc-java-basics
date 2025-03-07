package oc.epiccrafters.journey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import oc.epiccrafters.journey.blocks.BlockFactory;
import oc.epiccrafters.journey.blocks.Door;
import oc.epiccrafters.journey.blocks.IBlock;
import oc.epiccrafters.journey.blocks.Wall;

public class Main {

    final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<IBlock> blocks = new ArrayList<IBlock>();
        Set<String> keywords = new HashSet<String>();
        BlockFactory.createBlocks(5000, () -> new Wall(1, 1, 1, true)).forEach(blocks::add);
        BlockFactory.createBlocks(5000, () -> new Door(1, 1, 1, true)).forEach(blocks::add);
        keywords.add("house");
        keywords.add("rampart");

        Kit starterKit = new Kit(blocks, keywords);

        System.out.println("You have a starter kit");
        System.out.println(
                "What do you want to see next?\n\t1 - Build ideas with the blocks\n\t2 - The number of each blocks in the kit");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String choice = reader.readLine();
            switch (choice) {
                case "1" -> starterKit.showKeywords();
                case "2" -> starterKit.getKitMap().forEach((k, v) -> System.out.println(k + ": " + v));
                default -> System.out.println("Invalid choice, please type 1 or 2");
            }
        } catch (IOException e) {
            logger.error("Error while reading user input");
        }
    }
}