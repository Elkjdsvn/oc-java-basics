package oc.epiccrafters.journey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oc.epiccrafters.journey.blocks.IBlock;

public class Kit {
    private List<IBlock> blocks;
    private Set<String> keywords;

    public Kit(final List<IBlock> blocks, final Set<String> keywords) {
        this.blocks = blocks;
        this.keywords = keywords;
    }

    public void showKitBlocks() {
        System.out.println("Kit blocks number: " + blocks.size());
    }

    public Map<String, Integer> getKitMap() {
        Map<String, Integer> blocksMap = new HashMap<String, Integer>();
        blocks.forEach(block -> {
            if (blocksMap.containsKey(block.getClass().getSimpleName())) {
                blocksMap.put(block.getClass().getSimpleName(), blocksMap.get(block.getClass().getSimpleName()) + 1);
            } else {
                blocksMap.put(block.getClass().getSimpleName(), 1);
            }
        });
        return blocksMap;
    }

    public void showKeywords() {
        keywords.forEach(System.out::println);
    }
}
