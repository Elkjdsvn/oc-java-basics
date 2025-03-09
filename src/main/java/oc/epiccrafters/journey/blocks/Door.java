package oc.epiccrafters.journey.blocks;

import java.util.function.Predicate;

import oc.epiccrafters.journey.LockedDoorException;

public class Door extends Block {
    private boolean isLocked;

    public Door(final int width, final int height, final int depth, final boolean isLocked, final Color color) {
        super(width, height, depth, color);
        this.isLocked = isLocked;
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
