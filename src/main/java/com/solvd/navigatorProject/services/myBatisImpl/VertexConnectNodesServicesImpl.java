package com.solvd.navigatorProject.services.myBatisImpl;

import com.solvd.navigatorProject.binary.VertexConnectNodes;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.dao.interfaces.IVertexConnectNodesDao;
import com.solvd.navigatorProject.services.interfaces.IVertexConnectNodes;
import com.solvd.navigatorProject.utils.MyBatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class VertexConnectNodesServicesImpl implements IVertexConnectNodes {
    private static final Logger log = LogManager.getLogger(NodeServiceImpl.class);

    @Override
    public void joinNodes(VertexConnectNodes nhs) {
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            IVertexConnectNodesDao vertexConnectNodesDao = session.getMapper(IVertexConnectNodesDao.class);
            vertexConnectNodesDao.joinNodes( nhs);
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Vertex> getVerticesByNodeId(long id) {
        List<Vertex> vertices = new ArrayList<>();
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            IVertexConnectNodesDao vertexConnectNodesDao = session.getMapper(IVertexConnectNodesDao.class);
            vertices = vertexConnectNodesDao.getVerticesByNodeId(id);
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return vertices;
    }

    @Override
    public void deleteAllJoinedNodes() {
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            IVertexConnectNodesDao vertexConnectNodesDao = session.getMapper(IVertexConnectNodesDao.class);
            vertexConnectNodesDao.deleteAllJoinedNodes();
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
