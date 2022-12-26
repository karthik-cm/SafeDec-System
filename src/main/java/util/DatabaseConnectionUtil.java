package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton Design Pattern (Creational) is used here.
 * Only one instance of the DatabaseConnectionUtil class will be created and a method will be exposed globally to access created DB object.
 */

public final class DatabaseConnectionUtil {

    private static Connection dbConnection = null;

    private DatabaseConnectionUtil() { }

    public static Connection getDbConnection() {
        if (dbConnection != null) {
            System.out.println("Found existing DB connection");
            return dbConnection;
        }

        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/safeDecDB?autoReconnect=true&useSSL=false", "root", "Test@123");
        }
        catch (SQLException e) {
            System.out.println("Connection to Database Failed!");
            e.printStackTrace();
        }

        if (dbConnection == null) {
            System.out.println("Issue in initializing database! Database not initialized");
        }

        return dbConnection;
    }

}
