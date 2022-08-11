package com.prokhnov;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main_Test_2_Statement {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_test?useSSL=false";
    private static final String USERNAME = "bestuser";
    private static final String PASSWORD = "bestuser";


    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Insert, Get some resultSET
//            statement.execute("INSERT INTO animal(animal_name, animal_desc) VALUES ('xxx', 'xxx')");

            // Insert, Update, Delete
//            statement.executeUpdate("UPDATE animal SET animal_name='NewName' WHERE id = 1");

            // Get resultSET only SELECT
//            statement.executeQuery("SELECT * FROM city");


            // Выполняет пакетные запросы (более 1 шт.)
            statement.addBatch("INSERT INTO animal(animal_name, animal_desc) VALUES ('n1', 'd1')");
            statement.addBatch("INSERT INTO animal(animal_name, animal_desc) VALUES ('n2', 'd2')");
            statement.addBatch("INSERT INTO animal(animal_name, animal_desc) VALUES ('n3', 'd3')");

            // Выгрузить запросы в БД
            statement.executeBatch();

            // Очистить запросы
            statement.clearBatch();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
