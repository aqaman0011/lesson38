package Lesson38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://robot-do-user-1968994-0.b.db.ondigitalocean.com:25060/sydorov";
    private static final String DB_USERNAME = "doadmin";
    private static final String DB_PASSWORD = "AVNS_I6wlDKjGszZn1wvLr9t";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
    }
}
