package com.prokhnov;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Date;

public class Main_Test_4_PrepearedStatement {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_test?useSSL=false";
    private static final String USERNAME = "bestuser";
    private static final String PASSWORD = "bestuser";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES (?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM dish";

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
//
//        preparedStatement.setInt(1,2);
//        preparedStatement.setString(2, "Inserted title");
//        preparedStatement.setString(3, "Inserted desc");
//        preparedStatement.setFloat(4, 0.2f);
//        preparedStatement.setBoolean(5,true);
//        preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
//        preparedStatement.setBlob(7, new FileInputStream("1.png"));

        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            float rating = resultSet.getFloat("rating");
            boolean published = resultSet.getBoolean("published");
            Date date = resultSet.getDate("created");
            byte[] icon = resultSet.getBytes("icon");

            System.out.println(
                    id + "  " +
                            title + "  " +
                            description + "  " +
                            rating + "  " +
                            published + "  " +
                            date + "  " +
                            icon);

        }

        preparedStatement.execute();
    }
}
