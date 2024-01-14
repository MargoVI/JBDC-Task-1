package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String DB = "Task_1.1.3";
    public static final String URL = "jdbc:postgresql://localhost:5432/" + DB;
    public static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
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
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, DRIVER);
        properties.put(Environment.URL, URL);
        properties.put(Environment.USER, USER);
        properties.put(Environment.PASS, PASSWORD);
        properties.put(Environment.DIALECT, DIALECT);
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        SessionFactory sessionFactory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        return sessionFactory;
    }
}