package com.solvd.navigatorProject;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static VertexServiceImpl vertexService = new VertexServiceImpl();
    private static NodeServiceImpl nodeService = new NodeServiceImpl();
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args){
        Node node = new Node();
        vertexService.save(new Vertex(1));
        nodeService.save(new Node("A"));
        nodeService.save(new Node("B"));

        Node node1 = nodeService.getById(0);
        Node node2 = nodeService.getById(1);
        Vertex vertex = vertexService.getById(0);

        nodeService.connectNodes(node1, node2, vertex);



    }

    public static void createInitialMatrix(){

    }

    public static void findShortestPath(){
        
    }

    public static void createFinalMatrix(){

    }

}
