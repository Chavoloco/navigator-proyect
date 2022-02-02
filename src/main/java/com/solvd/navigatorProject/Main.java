package com.solvd.navigatorProject;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;

public class Main {
    private static VertexServiceImpl vertexService = new VertexServiceImpl();
    private static NodeServiceImpl nodeService = new NodeServiceImpl();

    public static void main(String[] args){
        Node node = new Node();
        vertexService.save(new Vertex(1));
        nodeService.save(new Node("A"));
        nodeService.save(new Node("B"));
        
        nodeService.connectNodes();

    }

}
