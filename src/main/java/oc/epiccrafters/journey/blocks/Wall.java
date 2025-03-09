package oc.epiccrafters.journey.blocks;

public class Wall extends Block {
    private boolean isBearing;

    public Wall(final int width, final int height, final int depth, final boolean isBearing, final Color color) {
        super(width, height, depth, color);
        this.isBearing = isBearing;
    }

    public boolean canGoThrough() {
        return !isBearing;
    }

    @Override
    public void showDescription() {
        System.out.println("This is a wall.");
    }

}
