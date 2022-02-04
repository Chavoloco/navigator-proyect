package com.solvd.navigatorProject;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexConnectNodesServicesImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static NodeServiceImpl nodeService = new NodeServiceImpl();
    private static VertexConnectNodesServicesImpl nhs = new VertexConnectNodesServicesImpl();
    private static final int INF = 999999999;
    private static long[] amountOfNodes;
    private static long[][] initialMatrix;
    private static long[][] finalMatrix;


    public static void main(String[] args) {


        createInitialMatrix();


    }

    public static void askAmountOfNodes() {
        Scanner scanner = new Scanner(System.in);

        log.info("Add nodes writing their name. Type exit to stop.");
        while (!scanner.nextLine().toUpperCase(Locale.ROOT).equals("EXIT")) {
            String nodeName = scanner.nextLine();
            nodeService.save(new Node(nodeName));
        }
    }

    public static void createInitialMatrix() {

        amountOfNodes = new Random().longs(0, nodeService.getAll().size()).distinct().limit(6).toArray();
        initialMatrix = new long[0][];
        int i;
        int j;
        int k;

        for (i = 0; i < amountOfNodes.length; i++) {
            for (j = 0; j < amountOfNodes.length; j++) {
                System.out.print(initialMatrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void findShortestPath() {

        for (int i = 0; i < amountOfNodes.length; i++) {
            for (int j = 0; j < amountOfNodes.length; j++) {
                finalMatrix = new long[0][];
                finalMatrix[i][j] = initialMatrix[i][j];
                for (int k = 0; k < finalMatrix.length; k++) {
                    for (i = 0; i < finalMatrix.length; i++) {
                        for (j = 0; j < finalMatrix.length; j++) {
                            if (finalMatrix[i][k] + finalMatrix[k][j] < finalMatrix[i][j])
                                finalMatrix[i][j] = finalMatrix[i][k] + finalMatrix[k][j];
                        }
                    }
                }
            }
        }
    }

    public static void createFinalMatrix() {
        log.info('\n' + "Shortest distance matrix is: ");
        for (int i = 0; i < amountOfNodes.length; ++i) {
            for (int j = 0; j < amountOfNodes.length; ++j) {
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
}





