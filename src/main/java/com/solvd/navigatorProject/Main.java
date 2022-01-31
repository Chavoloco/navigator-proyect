package com.solvd.navigatorProject;


import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.dao.interfaces.INodesHasVerticesDao;
import com.solvd.navigatorProject.dao.interfaces.IVertexDao;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
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
        VertexServiceImpl vertexService =new VertexServiceImpl();

        List<Vertex> vertices = vertexService.getAll();
        for (Vertex vertex :
                vertices) {
            log.info("vertex " + vertex.getId() + " " + vertex.getWeight());
            for (Node node :
                    vertex.getNodes()) {
                log.info(node.getId() + " " + node.getName() + " " + node.getPositionX() + " " + node.getPositionY());
            }
        }
        List<Node> nodes = nodeService.getAll();
        for (Node n :
                nodes) {
            log.info(n.getId() + " " + n.getName() + " " + n.getPositionX() + " " + n.getPositionY());
            for (Vertex vertex :
                    n.getVertices()) {
                log.info("vertex " + vertex.getId() + " " + vertex.getWeight());

            }
        }
   //     Vertex vertex = vertexService.getById(20);
   //     Node nodeA = nodeService.getById(26);
   //     Node nodeB = nodeService.getById(27);
   //     try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
   //         INodesHasVerticesDao nodesHasVerticesDao = session.getMapper(INodesHasVerticesDao.class);
   //         long vertexId = vertex.getId();
   //         long nodeId = nodeA.getId();
   //         nodesHasVerticesDao.joinNodes(nodeId, vertexId);
   //         nodeId = nodeB.getId();
   //         nodesHasVerticesDao.joinNodes(nodeId, vertexId);
   //         session.commit();
   //     } catch (Exception e) {
   //         log.error(e.getMessage(), e);
   //     }
    }
}
