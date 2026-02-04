package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/hospital_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "your_password_here";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Connected to database successfully!");
        } catch (SQLException e) {
            System.out.println(" Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public class TestConnection {
        public static void main(String[] args) {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection test passed! ");
                DatabaseConnection.closeConnection(connection);
            } else {
                System.out.println("Connection test failed! ");
            }
        }
    }

}

