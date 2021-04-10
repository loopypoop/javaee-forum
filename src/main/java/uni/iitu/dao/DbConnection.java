package uni.iitu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String jdbcURL = "jdbc:postgresql://localhost:5436/midterm";
        String dbUser = "postgres";
        String dbPassword = "postgres";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        return connection;
    }
}
