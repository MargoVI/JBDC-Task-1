package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl jdbc = new UserDaoJDBCImpl();

        jdbc.createUsersTable();
        jdbc.saveUser("Ivan", "Ivanov", (byte) 20);
        jdbc.saveUser("Max", "Nok", (byte) 21);
        jdbc.saveUser("Olga", "Io", (byte) 24);
        jdbc.saveUser("Kate", "Nio", (byte) 27);
        jdbc.getAllUsers();
        jdbc.cleanUsersTable();
        jdbc.dropUsersTable();
    }
 }
