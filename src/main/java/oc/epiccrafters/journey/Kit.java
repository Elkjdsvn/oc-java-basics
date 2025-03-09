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
        this.getKitMap().forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public Map<String, Integer> getKitMap() {
        Map<String, Integer> blocksMap = new HashMap<String, Integer>();
        blocks.forEach(block -> {
            String blockName = block.getClass().getSimpleName();
            blocksMap.merge(blockName, 1, Integer::sum);
        });
        return blocksMap;
    }

    public void showKeywords() {
        keywords.forEach(System.out::println);
    }
}
