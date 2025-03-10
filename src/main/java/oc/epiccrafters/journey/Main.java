package oc.epiccrafters.journey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import oc.epiccrafters.journey.blocks.BlockFactory;
import oc.epiccrafters.journey.blocks.Color;
import oc.epiccrafters.journey.blocks.Door;
import oc.epiccrafters.journey.blocks.Wall;

public class Main {

    final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Set<String> keywords = new HashSet<String>();

        keywords.add("house");
        keywords.add("rampart");

        Kit starterKit = new Kit(
                Stream.of(
                        BlockFactory.createBlocks(5000, () -> new Wall(1, 1, 1, true, Color.GREY)),
                        BlockFactory.createBlocks(5000, () -> new Door(1, 1, 1, true, Color.BLUE)))
                        .flatMap(Collection::stream)
                        .toList(),
                keywords);

        System.out.println("You have a starter kit\nWhat do you want to see next?\\n" +
                "\\t1 - Build ideas with the blocks\\n" +
                "\\t2 - The amount of each block in the kit");

        // Try-with-resources automatically closes the reader
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String choice = reader.readLine();
            switch (choice) {
                case "1" -> starterKit.showKeywords();
                case "2" -> starterKit.showKitBlocks();
                default -> System.out.println("Invalid choice, please type 1 or 2");
            }
        } catch (IOException e) {
            logger.error("Error while reading user input");
        }
    }
}