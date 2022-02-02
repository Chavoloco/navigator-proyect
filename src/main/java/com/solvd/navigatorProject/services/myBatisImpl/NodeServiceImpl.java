package com.solvd.navigatorProject.services.myBatisImpl;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.dao.interfaces.INodeDao;
import com.solvd.navigatorProject.services.interfaces.INodeService;
import com.solvd.navigatorProject.utils.MyBatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class NodeServiceImpl implements INodeService {
    private static final Logger log = LogManager.getLogger(NodeServiceImpl.class);

    @Override
    public void save(Node node) {
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            INodeDao nodeDao = session.getMapper(INodeDao.class);
            nodeDao.save(node);
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public Node getById(long id) {
        Node node = new Node();
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            INodeDao nodeDao = session.getMapper(INodeDao.class);
            node = nodeDao.getById(id);
            log.info(node);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return node;
    }

    @Override
    public void delete(long id) {
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            INodeDao nodeDao = session.getMapper(INodeDao.class);
            nodeDao.delete(id);
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void connectNodes(Node node1, Node node2, Vertex vertex) {
        try {
            VertexServiceImpl vertexService = new VertexServiceImpl();
            vertexService.setSource(node1);
            vertexService.setDestination(node2);
            vertexService.save(vertex);
        } catch (Exception e){
            log.error(e.getMessage(), e);
        }

    }

    @Override
    public List<Node> getAll() {
        List<Node> nodeList = new ArrayList<>();
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            INodeDao nodeDao = session.getMapper(INodeDao.class);
            nodeList = nodeDao.getAll();
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return nodeList;
    }

    @Override
    public Node findFirst() {
        Node node = null;
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            INodeDao nodeDao = session.getMapper(INodeDao.class);
            node = nodeDao.findFirst();
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return node;
    }

    @Override
    public Node findLast() {
        Node node = null;
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            INodeDao nodeDao = session.getMapper(INodeDao.class);
            node = nodeDao.findLast();
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return node;
    }
}
