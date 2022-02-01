package com.solvd.navigatorProject.services.myBatisImpl;

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
    private final int INF = 999999999;
    private int numberOfVertices = 4;
    private final long[][] finalMatrix = new long[numberOfVertices][numberOfVertices];

    @Override
    public long[][] createInitialMatrix() {
        return new long[][]{{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0},};
    }

    @Override
    public void getShortestDistance() {

        for (int i = 0; i < numberOfVertices; i++)
            for (int j = 0; j < numberOfVertices; j++)
                finalMatrix[i][j] = createInitialMatrix()[i][j];
        for (int k = 0; k < createInitialMatrix().length; k++) {
            for (int i = 0; i < createInitialMatrix().length; i++) {
                for (int j = 0; j < createInitialMatrix().length; j++) {
                    if (finalMatrix[i][k] + finalMatrix[k][j] < finalMatrix[i][j])
                        finalMatrix[i][j] = finalMatrix[i][k] + finalMatrix[k][j];
                }
            }
        }
    }

    @Override
    public void createShortDistanceMatrix() {
        log.info("Shortest distance between every pair of vertices is: ");

        for (int i=0; i<numberOfVertices; ++i)
        {
            for (int j=0; j<numberOfVertices; ++j)
            {
                if (finalMatrix[i][j]==INF)
                    log.info("INF ");
                else
                    log.info(finalMatrix[i][j]+"   ");
            }
            System.out.println();
        }
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

    public int getINF() {
        return INF;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }
}
