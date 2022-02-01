package com.solvd.navigatorProject;


import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.NodeHasVertices;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.NodesHasVerticesServicesImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        List<Node> nodeList = nodeService.getAll();
        for (Node node : nodeList){
            log.info("node id: " + node.getId() + " node name: " + node.getName() );
            for (Vertex vertex : node.getVertices()){
                log.info(vertex.getId() + " " + vertex.getDistance());
            }
        }
        NodeHasVertices nhs1 = new NodeHasVertices(30, 21);

        Node node2 = nodeService.getById(30).getVertices() == nodeService.getById(31).getVertices()


        nhs.joinNodes(nhs1);

        createInitialMatrix();
        createFinalMatrix();

    }

    public static void createInitialMatrix() {
        long matrix[][] = new long[numberOfVertices][numberOfVertices];
        long min = nodeService.findFist().getId();
        long max = nodeService.findLast().getId();
        Random random = new Random();
        int randomIndex = random.nextInt(numberOfVertices);
        matrix[randomIndex][randomIndex] = (long) Math.floor(Math.random() * (max - min + 1) + min);

        long[][] matrix2 = {{0, INF, INF, (long)vertexService.getDistanceById(24), INF},
                            {INF, 0, (long)vertexService.getDistanceById(22), INF},
                            {INF, INF, 0, 1},
                            {INF, INF, INF, 0},};

                floydAlgorithm(matrix);

        long r = Math.floor(Math.random() * (max - min + 1) + min);
        NodeHasVertices nhs1 = new NodeHasVertices(r, 21);
        for (int i = 0; i < ; i++) {
            for (int j = 0; j < ; j++) {
                //
                if (nodeService.getById(30).getVertices() == nodeService.getById(31).getVertices()){
                    int[i][j] = vertexService.getById(2).getDistance();
                }else if(nodeService.getById(30) == nodeService.getById(30)){
                    int[i][j] = 0;
                }else{
                    int[i][j] = INF;
                }
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

        public static void floydAlgorithm ( long[][] matrix){
            NodeServiceImpl nodeService = new NodeServiceImpl();

            long shortestDistance = 0;

            //  long[][] matrix = {{0, 5, INF, 10},
            //         {INF, 0, 3, INF},
            //         {INF, INF, 0, 1},
            //        {INF, INF, INF, 0},};

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
