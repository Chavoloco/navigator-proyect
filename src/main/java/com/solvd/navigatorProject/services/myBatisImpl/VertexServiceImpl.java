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

    @Override
    public long[][] createInitialMatrix() {
        int INF = 999999999;
        int numberOfVertices = 4;

        long matrix[][] = {{0, 5, INF, 10},
                          {INF, 0, 3, INF},
                          {INF, INF, 0, 1},
                          {INF, INF, INF, 0},};
        return matrix;
    }

    @Override
    public void getShortestDistance() {
        int INF = 999999999;
        int numberOfVertices = 4;

        long kaka[][] = {{0, 5, INF, 10},
                         {INF, 0, 3, INF},
                         {INF, INF, 0, 1},
                        {INF, INF, INF, 0},};

        long list[][] = new long[numberOfVertices][numberOfVertices];
        long shortestDistance = 0;

        for (int i = 0; i < numberOfVertices; i++)
            for (int j = 0; j < numberOfVertices; j++)
                list[i][j] = kaka[i][j];
        for (int k = 0; k < kaka.length; k++) {
            for (int i = 0; i < kaka.length; i++) {
                for (int j = 0; j < kaka.length; j++) {
                    if (list[i][k] + list[k][j] < list[i][j])
                        list[i][j] = list[i][k] + list[k][j];
                     shortestDistance += list[i][j];
                }
            }
        }

        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");

        for (int i=0; i<numberOfVertices; ++i)
        {
            for (int j=0; j<numberOfVertices; ++j)
            {
                if (list[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(list[i][j]+"   ");
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
}
