package ru.itis.testwork1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnectionUtil {
    private static Connection connection;

    private DatabaseConnectionUtil() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "postgres"
                );
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return connection;
    }
}
