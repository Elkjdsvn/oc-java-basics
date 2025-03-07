package oc.epiccrafters.journey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LockedDoorException extends Exception {
    private final static Logger logger = LogManager.getLogger(LockedDoorException.class);

    public LockedDoorException() {
        super("The door is already locked!");
        logger.error("The door is already locked!");
    }
}
