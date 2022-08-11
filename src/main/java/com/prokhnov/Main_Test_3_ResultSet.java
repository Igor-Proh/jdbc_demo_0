package com.prokhnov;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main_Test_3_ResultSet {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_test?useSSL=false";
    private static final String USERNAME = "bestuser";
    private static final String PASSWORD = "bestuser";

    public static void main(String[] args) throws SQLException {
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String query = "select * from animal";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.print(resultSet.getInt(1) + " ");
            System.out.print(resultSet.getString(2) + " ");
            System.out.print(resultSet.getString(3) + "\n");

        }

    }
}
