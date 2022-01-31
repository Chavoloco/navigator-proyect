package com.solvd.navigatorProject.services.myBatisImpl;

import com.solvd.navigatorProject.Main;
import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.dao.interfaces.IVertexDao;
import com.solvd.navigatorProject.services.interfaces.IVertexService;
import com.solvd.navigatorProject.utils.MyBatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class VertexServiceImpl implements IVertexService {
    private static final Logger log = LogManager.getLogger(VertexServiceImpl.class);

    @Override
    public double getShortestDistance(Node node) {
        //Algorithm
        return 0;
    }

    @Override
    public void save(Vertex vertex) {
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            IVertexDao vertexDao = session.getMapper(IVertexDao.class);
            vertexDao.save(vertex);
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public Vertex getById(long id) {
        Vertex vertex = null;
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            IVertexDao vertexDao = session.getMapper(IVertexDao.class);
            vertex = vertexDao.getById(id);
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return vertex;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Vertex> getAll() {
        List<Vertex> vertexList = new ArrayList<>();
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            IVertexDao vertexDao = session.getMapper(IVertexDao.class);
            vertexList = vertexDao.getAll();
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return vertexList;
    }

    @Override
    public double getWeightById() {
        return 0;
    }
}
