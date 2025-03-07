package oc.epiccrafters.journey.blocks;

public abstract class Block implements IBlock {
    protected int width;
    protected int height;
    protected int depth;
    protected Color color;

    public Block(final int width, final int height, final int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
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
