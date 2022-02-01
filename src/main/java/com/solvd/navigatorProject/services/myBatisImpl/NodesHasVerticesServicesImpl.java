package com.solvd.navigatorProject.services.myBatisImpl;

import com.solvd.navigatorProject.binary.NodeHasVertices;
import com.solvd.navigatorProject.dao.interfaces.INodesHasVerticesDao;
import com.solvd.navigatorProject.services.interfaces.NodesHasVerticesService;
import com.solvd.navigatorProject.utils.MyBatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class NodesHasVerticesServicesImpl implements NodesHasVerticesService {
    private static final Logger log = LogManager.getLogger(NodeServiceImpl.class);

    @Override
    public void joinNodes(NodeHasVertices nhs) {
        try (SqlSession session = MyBatisDAOFactory.getSessionFactory().openSession()) {
            INodesHasVerticesDao nodesHasVerticesDao = session.getMapper(INodesHasVerticesDao.class);
            nodesHasVerticesDao.joinNodes( nhs);
            session.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
