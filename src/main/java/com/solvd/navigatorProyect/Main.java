package com.solvd.navigatorProyect;

import com.solvd.navigatorProyect.utils.connectionPool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ConnectionPool cp = ConnectionPool.getInstance();

        CompletableFuture<Void> thread1 = CompletableFuture
                .runAsync(() -> {
                    try {
                        cp.getConnection();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
    }
}
