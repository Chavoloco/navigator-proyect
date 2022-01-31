package com.solvd.navigatorProject;


import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.dao.interfaces.INodeDao;
import com.solvd.navigatorProject.dao.interfaces.IVertexDao;
import com.solvd.navigatorProject.services.myBatisImpl.NodeServiceImpl;
import com.solvd.navigatorProject.utils.MyBatisDAOFactory;
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

    public static void main(String[] args) {
        NodeServiceImpl nodeService = new NodeServiceImpl();

        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            INodeDao nodeDao = session.getMapper(INodeDao.class);
            //IVertexDao vertexDao = session.getMapper(IVertexDao.class);
            nodeDao.delete(18);
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
