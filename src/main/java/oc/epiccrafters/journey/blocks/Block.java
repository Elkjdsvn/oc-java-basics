package oc.epiccrafters.journey.blocks;

import java.util.stream.Stream;
import static oc.epiccrafters.journey.blocks.BlockConstants.*;

public abstract class Block implements IBlock {
    protected int width;
    protected int height;
    protected int depth;
    protected Color color;

    public Block(final int width, final int height, final int depth, final Color color) {
        if (width < MIN_WIDTH || height <= MIN_HEIGHT || depth <= MIN_DEPTH) {
            throw new IllegalArgumentException("Block dimensions must be positive");
        }
        if (color == null || !Stream.of(Color.values()).anyMatch(v -> v.name().equals(color.name()))) {
            throw new IllegalArgumentException("Block color must be defined");
        }
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.color = color;
    }

    public int getWidth() {

        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getDepth() {
        return this.depth;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
