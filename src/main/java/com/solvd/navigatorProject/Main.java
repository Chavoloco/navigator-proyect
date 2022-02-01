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
    private static NodeServiceImpl nodeService = new NodeServiceImpl();
    private static NodesHasVerticesServicesImpl nhs = new NodesHasVerticesServicesImpl();
    private static final int numberOfVertices = 4;
    private static final int INF = 999999999;
    private static final long[][] finalMatrix = new long[numberOfVertices][numberOfVertices];

    public static void main(String[] args) {

        createInitialMatrix();
        floydAlgorithm();
        createFinalMatrix();

    }

    public static void createInitialMatrix() {
        long matrix[][] = new long[numberOfVertices][numberOfVertices];
        int c = 0;
        int p = 0;
        for (Node node :
                nodeService.getAll()) {
            if (c > numberOfVertices || p > numberOfVertices) break;
            c++;
            for (Vertex vertex  :
                  node.getVertices()) {
                if (vertex.getNodes().contains(node)){
                    matrix[c][p] = node.getId();
                }else{
                    matrix[c][p] = INF;
                }
                p++;
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {

                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
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

}
