package com.solvd.navigatorProject;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.exceptions.NoNodesAdded;
import com.solvd.navigatorProject.exceptions.NoShortestPath;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final NodeServiceImpl nodeService = new NodeServiceImpl();
    private static final VertexServiceImpl vertexService = new VertexServiceImpl();
    private static final int INF = 999999999;
    private static long[] amountOfVertices;
    private static long[][] initialMatrix;
    private static long[][] finalMatrix;


    public static void main(String[] args) {


        createInitialMatrix();


    }

    public static void askAmountOfNodes() throws NoNodesAdded {
        Scanner scanner = new Scanner(System.in);

        try {
            log.info("Add nodes writing their name. Type exit to stop.");
            while (!scanner.nextLine().toUpperCase(Locale.ROOT).equals("EXIT")) {
                String nodeName = scanner.nextLine();
                nodeService.save(new Node(nodeName));
            }
        } catch (InputMismatchException e) {
            log.error("That wasn't what we asked.");
        }
    }

    public static void createInitialMatrix() {

        amountOfVertices = new Random().longs(0, vertexService.getAll().size()).distinct().limit(6).toArray();
        int i;
        int j;

        for (i = 0; i < amountOfVertices.length; i++) {
            for (j = 0; j < amountOfVertices.length; j++) {
                log.info(" " + '\t' +initialMatrix[i][j]);
            }
        }
        log.info('\n');
    }

    public static void findShortestPath() {

        for (int i = 0; i < vertexService.getDistanceById(i); i++) {
            for (int j = 0; j < vertexService.getDistanceById(j); j++) {
                finalMatrix[i][j] = initialMatrix[i][j];
                for (int k = 0; k < vertexService.getDistanceById(k); k++) {
                    for (i = 0; i < vertexService.getDistanceById(i); i++) {
                        for (j = 0; j < vertexService.getDistanceById(j); j++) {
                            if (finalMatrix[i][k] + finalMatrix[k][j] < finalMatrix[i][j])
                                finalMatrix[i][j] = finalMatrix[i][k] + finalMatrix[k][j];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < finalMatrix.length; i++) {
            for (int j = 0; j < finalMatrix.length; j++) {
                if (initialMatrix == finalMatrix) {
                    log.error(NoShortestPath::new);
                }
            }
        }
    }

    public static void createFinalMatrix() {
        log.info('\n' + "Shortest distance matrix is: ");
        for (int i = 0; i < vertexService.getDistanceById(i); ++i) {
            for (int j = 0; j < vertexService.getDistanceById(j); ++j) {
                if (finalMatrix[i][j] == INF) {
                    log.info(" " + '\t' + "INF ");
                } else {
                    log.info(" " + '\t' + finalMatrix[i][j]);
                }
                log.info('\n');
            }
        }
    }

    public static long[][] getInitialMatrix() {
        return initialMatrix;
    }

    public static void setInitialMatrix(long[][] initialMatrix) {
        Main.initialMatrix = initialMatrix;
    }

    public static long[][] getFinalMatrix() {
        return finalMatrix;
    }

    public static void setFinalMatrix(long[][] finalMatrix) {
        Main.finalMatrix = finalMatrix;
    }
}





