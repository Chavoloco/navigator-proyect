package com.solvd.navigatorProject;


import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.NodeHasVertices;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.dao.interfaces.INodesHasVerticesDao;
import com.solvd.navigatorProject.dao.interfaces.IVertexDao;
import com.solvd.navigatorProject.services.interfaces.NodesHasVerticesService;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.services.myBatisImpl.NodesHasVerticesServicesImpl;
import com.solvd.navigatorProject.services.myBatisImpl.VertexServiceImpl;
import com.solvd.navigatorProject.utils.MyBatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        NodeServiceImpl nodeService = new NodeServiceImpl();
        VertexServiceImpl vertexService = new VertexServiceImpl();
        NodesHasVerticesServicesImpl nhs = new NodesHasVerticesServicesImpl();

        List<Node> nodeList = new ArrayList<>();
        nodeList = nodeService.getAll();
        for (Node node :
                nodeList) {
            log.info("node: " + node.getName());
            for (Vertex vertex :
                    node.getVertices()) {
                log.info("vertex distance: " + vertex.getDistance());
            }
        }
        List<Vertex> vertexList = new ArrayList<>();
        vertexList = vertexService.getAll();
        for (Vertex vertex :
                vertexList) {
            log.info("vertex distance: " + vertex.getDistance());
            for (Node node :
                    vertex.getNodes()) {
                log.info("node: " + node.getName());

            }
        }
    }
}
