package com.solvd.navigatorProyect.dao;

import com.solvd.navigatorProyect.utils.connectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDao {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public Connection getCon() throws SQLException {
        return connectionPool.getConnection();
    }

    public void realiseConnection(Connection connection) {
        connectionPool.getBack(connection);
    }
}
