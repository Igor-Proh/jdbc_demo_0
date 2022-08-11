package com.prokhnov;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_Test_1_Connection {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_test?useSSL=false";
    private static final String USERNAME = "bestuser";
    private static final String PASSWORD = "bestuser";


    public static void main(String[] args) {
        Connection connection;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Start connection to DB !!!");
            }

            connection.close();
            if (connection.isClosed()) {
                System.out.println("Stop connection to DB !!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Cant connect!!!");
        }

    }
}
