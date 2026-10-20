
package com.example.springmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/spring_mvc_db";

    private static final String USER = "root";

    // Replace with your own MySQL password
    private static final String PASSWORD = "TempPass123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver is missing.", e);
        }
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connected database: " +
                con.getCatalog());
        return con;

    }
}
