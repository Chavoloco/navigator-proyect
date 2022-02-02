package com.solvd.navigatorProject.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Reader;

public class MyBatisDAOFactory {
    private static final Logger log = LogManager.getLogger(MyBatisDAOFactory.class);
    private final static MyBatisDAOFactory myBDF = new MyBatisDAOFactory();
    private static SqlSessionFactory sqlSessionFactory;

    private MyBatisDAOFactory() {
        try {
            Reader reader = Resources.getResourceAsReader("my-batis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sqlSessionFactory;
    }
}
