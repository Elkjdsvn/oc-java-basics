package oc.epiccrafters.journey.blocks;

import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import oc.epiccrafters.journey.LockedDoorException;

public class Door extends Block {
    private boolean isLocked;
    private final static Logger logger = LogManager.getLogger(Door.class);

    public Door(final int width, final int height, final int depth, final boolean isLocked) {
        super(width, height, depth);
        this.isLocked = isLocked;
        this.color = Color.BLUE;
        logger.info("New door");
    }

    public boolean isDoorLocked() {
        return isLocked;
    }

    @Override
    public void showDescription() {
        System.out.println("This is a door.");
    }

    public void lockDoor() throws LockedDoorException {
        if (isLocked) {
            throw new LockedDoorException();
        }
        isLocked = true;
    }

    public void bypassLock(Predicate<String> password) {
        if (password.test("password")) {
            isLocked = false;
        } else {
            System.out.println("Wrong password");
        }
    }

}
