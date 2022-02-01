package com.solvd.navigatorProject;


import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        VertexServiceImpl vertex = new VertexServiceImpl();
        vertex.getShortestDistance();
        vertex.createShortDistanceMatrix();

    }
}
