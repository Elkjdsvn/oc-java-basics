package oc.epiccrafters.journey.blocks;

public abstract class Block implements IBlock {
    protected int width;
    protected int height;
    protected int depth;
    protected Color color;

    public Block(final int width, final int height, final int depth, final Color color) {
        if (width <= 0 || height <= 0 || depth <= 0) {
            throw new IllegalArgumentException("Block dimensions must be positive");
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

    public void setColor(Color color) {
        this.color = color;
    }

}
