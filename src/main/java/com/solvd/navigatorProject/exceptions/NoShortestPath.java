package com.solvd.navigatorProject.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoShortestPath extends Throwable{
    private static final Logger logger = LogManager.getLogger(NoShortestPath.class);

    public NoShortestPath() {
        logger.error("No shortest path available.");
    }
}
