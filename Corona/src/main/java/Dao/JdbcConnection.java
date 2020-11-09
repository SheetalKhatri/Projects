package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class JdbcConnection {
    public static Connection getDbConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("COULD NOT LOAD JDBC DRIVER FOR MYSQL");
            e.printStackTrace();
        }

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/corona_db", "root", "1234");

        if (connection == null) System.out.println("COULD NOT GET CONNECTION TO DB");
        return connection;

    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = JdbcConnection.getDbConnection();
            if (conn != null) {
                System.out.println("Connection Establish");
            }
        } catch (SQLException throwables) {
            System.out.println("Failed to establish connection");
        }
    }
}
