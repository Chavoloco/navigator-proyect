package com.solvd.navigatorProject;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final VertexServiceImpl vertexService = new VertexServiceImpl();
    private static final NodeServiceImpl nodeService = new NodeServiceImpl();
    private static final Logger logger = LogManager.getLogger();
    private static int amountOfNodes;
    private static final List<Node> nodeList = new ArrayList<>();
    private static final List<Node> connectedNodes = new ArrayList<>();
    private static Vertex vertex;
    private static final int INF = 999999999;
    private static final long[][] finalMatrix = new long[amountOfNodes][amountOfNodes];

    public static void main(String[] args) {

        vertexService.save(new Vertex(1));
        nodeService.save(new Node("A"));
        nodeService.save(new Node("B"));

        Node node1 = nodeService.getById(0);
        Node node2 = nodeService.getById(1);
        vertex = vertexService.getById(0);

        Node connectednode = nodeService.connectNodes(node1, node2, vertex);

        connectedNodes.add(connectednode);


    }

    public static void createInitialMatrix(int amountOfNodes) {

        Random random = new Random();
        long[][] initialMatrix = new long[amountOfNodes][amountOfNodes];

        List<Node> newList = new ArrayList<>();
        for (int i = 0; i < amountOfNodes; i++) {
            int randomIndex = random.nextInt(nodeList.size());
            newList.add(nodeService.getById(randomIndex));
            for (i = 0; i < amountOfNodes; i++) {
                for (int j = 0; j < amountOfNodes; j++) {
                    for (i = 0; i < newList.size(); i++) {
                        if (newList.get(i) == connectedNodes.get(i)) {
                            initialMatrix[i][j] = (long) vertex.getDistance();
                            System.out.print(vertex.getDistance() + " ");
                        } else if (newList.get(i) == nodeService.getById(i)) {
                            initialMatrix[i][j] = 0;
                            System.out.print("0 ");
                        } else if (newList.get(i) != connectedNodes.get(i)) {
                            initialMatrix[i][j] = INF;
                            System.out.print("INF ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void findShortestPath() {
        long shortestDistance = 0;

        for (int i = 0; i < amountOfNodes; i++) {
            for (int j = 0; j < amountOfNodes; j++) {
                finalMatrix[i][j] = finalMatrix[i][j];
                for (int k = 0; k < finalMatrix.length; k++) {
                    for (i = 0; i < finalMatrix.length; i++) {
                        for (j = 0; j < finalMatrix.length; j++) {
                            if (finalMatrix[i][k] + finalMatrix[k][j] < finalMatrix[i][j])
                                finalMatrix[i][j] = finalMatrix[i][k] + finalMatrix[k][j];
                            shortestDistance += finalMatrix[i][j];
                        }
                    }
                }
            }
        }
    }

    public static void createFinalMatrix() {
        logger.info('\n' + "Shortest distance matrix is: ");
        for (int i = 0; i < amountOfNodes; ++i) {
            for (int j = 0; j < amountOfNodes; ++j) {
                if (finalMatrix[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(finalMatrix[i][j] + "   ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int getAmountOfNodes() {
        return amountOfNodes;
    }

    public static void setAmountOfNodes(int amountOfNodes) {
        Main.amountOfNodes = amountOfNodes;
    }
}



