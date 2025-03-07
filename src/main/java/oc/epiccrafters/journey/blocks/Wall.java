package oc.epiccrafters.journey.blocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Wall extends Block {
    private boolean isBearing;

    private final static Logger logger = LogManager.getLogger(Wall.class);

    public Wall(final int width, final int height, final int depth, final boolean isBearing) {
        super(width, height, depth);
        logger.info("New wall");
        System.out.println("Logger level: " + logger.getLevel());
        this.isBearing = isBearing;
        this.color = Color.GREY;
    }

    public boolean canGoThrough() {
        return !isBearing;
    }

    @Override
    public void showDescription() {
        System.out.println("This is a wall.");
    }

}
