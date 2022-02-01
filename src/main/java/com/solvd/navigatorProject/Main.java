package com.solvd.navigatorProject;


import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.NodesHasVerticesServicesImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static VertexServiceImpl vertexService = new VertexServiceImpl();
    private static final int numberOfVertices = 4;
    private static final int INF = 999999999;
    private static final long[][] finalMatrix = new long[numberOfVertices][numberOfVertices];
    private static final List<Long> nodesId = new ArrayList<>();

    public static void main(String[] args) {
        NodesHasVerticesServicesImpl nhs = new NodesHasVerticesServicesImpl();
        VertexServiceImpl vertex = new VertexServiceImpl();
        NodeServiceImpl nodeService = new NodeServiceImpl();
        List<Vertex> vertexList = vertex.getAll();


        NodeServiceImpl nodeService = new NodeServiceImpl();
       
        log.info(node.getName());

        floydAlgorithm();
        createFinalMatrix();
        createInitialMatrix();

    }

    public static void createInitialMatrix() {
        Random random = new Random();
        Collections.shuffle(nodesId);

        int randomAmountNodes = 4;

        log.info(nodesId.get(0));

        List<Long> randomNodes = nodesId.subList(0, randomAmountNodes);
        for (Long aLong : randomNodes) {
            log.info(aLong);
        }

    }

    public static void floydAlgorithm() {
        NodeServiceImpl nodeService = new NodeServiceImpl();

        long shortestDistance = 0;

        long[][] matrix = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0},};

        for (int i = 0; i < numberOfVertices; i++)
            for (int j = 0; j < numberOfVertices; j++)
                finalMatrix[i][j] = matrix[i][j];
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (finalMatrix[i][k] + finalMatrix[k][j] < finalMatrix[i][j])
                        finalMatrix[i][j] = finalMatrix[i][k] + finalMatrix[k][j];
                    shortestDistance += finalMatrix[i][j];
                }
            }
        }
    }

    public static void createFinalMatrix() {
        log.info('\n' + "Shortest distance matrix is: ");
        for (int i = 0; i < numberOfVertices; ++i) {
            for (int j = 0; j < numberOfVertices; ++j) {
                if (finalMatrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(finalMatrix[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static VertexServiceImpl getVertexService() {
        return vertexService;
    }

    public static void setVertexService(VertexServiceImpl vertexService) {
        Main.vertexService = vertexService;
    }
}
