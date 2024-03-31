package org.vyvr.javaprojektzaliczeniowy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String jdbcURL = "jdbc:yourdb://localhost:3306/freestyle-app";
        String jdbcUsername = "yourusername";
        String jdbcPassword = "yourpassword";
        Class.forName("com.yourdb.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }
}
