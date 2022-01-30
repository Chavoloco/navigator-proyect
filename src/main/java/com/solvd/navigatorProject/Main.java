package com.solvd.navigatorProject;


import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.dao.interfaces.INodeDao;
import com.solvd.navigatorProject.dao.interfaces.IVertexDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("my-batis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //SqlSession session = sqlSessionFactory.openSession();


        try (SqlSession session = sqlSessionFactory.openSession()) {
            INodeDao nodeDao = session.getMapper(INodeDao.class);
            IVertexDao vertexDao = session.getMapper(IVertexDao.class);
            List<Node> nodeList = new ArrayList<Node>();
            List<Vertex> vertexList = new ArrayList<Vertex>();
            try {
                //nodeDao.save(nodeA);
                //nodeDao.save(nodeB);
                //vertexDao.save(vertex);
                //nodeList = nodeDao.getAll();
                vertexList = vertexDao.getAll();
                log.info("record inserted");
                for (Vertex vertex : vertexList) {
                    log.info(vertex.toString());
                }
                session.commit();
            } catch (Exception e) {
                session.rollback();
                log.error(e.getMessage(), e);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
