package com.solvd.navigatorProject;

import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.NodesHasVerticesServicesImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static VertexServiceImpl vertexService = new VertexServiceImpl();
    private static NodeServiceImpl nodeService = new NodeServiceImpl();
    private static NodesHasVerticesServicesImpl nhs = new NodesHasVerticesServicesImpl();
    private static final int numberOfVertices = 4;
    private static final int INF = 999999999;
    private static long[][] finalMatrix = new long[numberOfVertices][numberOfVertices];

    public static void main(String[] args) {

        createInitialMatrix();
    }

    public static void createInitialMatrix() {
        long matrix[][] = new long[numberOfVertices][numberOfVertices];
        long first = nodeService.findFist().getId();
        int column = 0;
        int line = -1;
        for (int i = (int) first; i < first + numberOfVertices; i++) {
            line++;
            for (int j = (int) first; j < first + numberOfVertices; j++) {
                if (!Objects.equals(nodeService.getById(i), nodeService.getById(j))) {
                    for (Vertex vertex : nhs.getVerticesByNodeId(i)) {
                        if (nhs.getVerticesByNodeId(j).contains(vertex)) {
                            matrix[line][column] = vertex.getDistance();
                            break;
                        } else {
                            matrix[line][column] = INF;
                        }
                    }
                    column++;
                } else if (Objects.equals(nodeService.getById(i), nodeService.getById(j))) {
                    matrix[line][column] = 0;
                    column++;
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

        floydAlgorithm(matrix);

    }

    public static void floydAlgorithm(long[][] matrix) {
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
        createFinalMatrix();
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
