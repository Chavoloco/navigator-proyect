package com.solvd.navigatorProject;


import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        NodeServiceImpl nodeService = new NodeServiceImpl();
        VertexServiceImpl vertexService = new VertexServiceImpl();

        List<Vertex> vertices = vertexService.getAll();
        for (Vertex vertex :
                vertices) {
            log.info("vertex " + vertex.getId() + " " + vertex.getDistance());
        }
        List<Node> nodes = nodeService.getAll();
        for (Node n :
                nodes) {
            for (Vertex vertex :
                    n.getVertices()) {
                log.info("vertex " + vertex.getId() + " " + vertex.getDistance());

            }
        }
    }
}
