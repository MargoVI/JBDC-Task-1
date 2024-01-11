package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static final String DB = "Task_1.1.3";
    public static final String URL = "jdbc:postgresql://localhost:5432/" + DB;
    public static final String USER = "postgres";
    public static final String PASSWORD = "rootroot";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS users (Id SERIAL PRIMARY KEY, name VARCHAR, lastName varchar, age integer)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS users";
    public static final String INSERT_INTO = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
    public static final String DELETE_FROM = "DELETE FROM users WHERE id = ?";
    public static final String CLEAN = "DELETE FROM users";
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}