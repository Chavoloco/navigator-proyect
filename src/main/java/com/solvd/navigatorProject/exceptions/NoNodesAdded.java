package com.solvd.navigatorProject.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoNodesAdded extends Throwable{
    private static final Logger logger = LogManager.getLogger(NoNodesAdded.class);

    public NoNodesAdded() {
        logger.error("Something went wrong. No nodes added.");
    }
}
