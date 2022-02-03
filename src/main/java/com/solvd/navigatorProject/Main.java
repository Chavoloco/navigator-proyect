package com.solvd.navigatorProject;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.NodesHasVerticesServicesImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static VertexServiceImpl vertexService = new VertexServiceImpl();
    private static NodeServiceImpl nodeService = new NodeServiceImpl();
    private static NodesHasVerticesServicesImpl nhs = new NodesHasVerticesServicesImpl();
    private static final int numberOfVertices = 4;
    private static final int INF = 999999999;
    private static final long[][] finalMatrix = new long[numberOfVertices][numberOfVertices];

    public static void main(String[] args) {

        List<Vertex> vertices = nhs.getVerticesByNodeId(31);
        for (Vertex vertex :
                vertices) {
            log.info(vertex.getId() + " " + vertex.getDistance());
        }

        if(nhs.getVerticesByNodeId(31).contains(nhs.getVerticesByNodeId(32))){
            log.info("true");
        }

        createInitialMatrix();
        //createFinalMatrix();

    }

    public static void createInitialMatrix() {
        //long matrix[][] = new long[numberOfVertices][numberOfVertices];
        //long min = nodeService.findFist().getId();
        //long max = nodeService.findLast().getId();
        //Random random = new Random();
        //matrix[randomIndex][randomIndex] = (long) Math.floor(Math.random() * (max - min + 1) + min);
        //floydAlgorithm(matrix);
        //long randomIndex = (long) Math.floor(Math.random() * (first - last + 1) + first);

        long matrix[][] = new long[numberOfVertices][numberOfVertices];
        long first = nodeService.findFist().getId();
        long last = nodeService.findLast().getId();
        int column = 0;
        int line = -1;
        for (int i = (int) first; i < first + numberOfVertices; i++) {
            line++;
            for (int j = (int) first; j < first + numberOfVertices; j++) {
                if (!Objects.equals(nodeService.getById(i), nodeService.getById(j))) {
                    for (Vertex vertex : nodeService.getById(i).getVertices()) {
                        if (nodeService.getById(j).getVertices().contains(vertex)) {
                            matrix[line][column] = vertex.getDistance();
                        } else {
                            matrix[line][column] = INF;
                        }
                        column++;
                    }
                } else if (Objects.equals(nodeService.getById(i), nodeService.getById(j))) {
                    matrix[line][column] = 0;
                }
            }
            column = 0;

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

    public static void floydAlgorithm(long[][] matrix) {
        NodeServiceImpl nodeService = new NodeServiceImpl();

        long shortestDistance = 0;

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
