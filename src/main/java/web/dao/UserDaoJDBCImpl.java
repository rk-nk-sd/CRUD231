package web.dao;

import web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final String table = "user_crud";

    /**
     * Конфигурация для подключения к БД
     */
    private static final String url = "jdbc:mysql://127.0.0.1/test";
    private static final String user = "jm";
    private static final String pass = "1111";

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection connection;
    private static Statement statement;

    /**
     * Подключение к БД через JDBC
     */
    public Statement getConnectionFromDataBase() {
        connection = null;
        statement = null;

        try {
            /**
             * Открываем соединение с БД
             */
            Class.forName(JDBC_DRIVER);

            connection = (Connection) DriverManager.getConnection(url, user, pass);
            statement = (Statement) connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement;
    }

    /**
     * Реализация интерфейса UserDao
     * @return
     */

     // Возвращает список пользователей вида List<User>

    @Override
    public List<User> getAllUsers() {
        String SQL = "SELECT * FROM " + table;
        List<User> listUsers = new ArrayList<User>();

        try {
            ResultSet resultSet = getConnectionFromDataBase().executeQuery(SQL);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                //Assuming you have a user object
                User user = new User(id, name, lastname, email);
                listUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listUsers;
    }

    @Override
    public User getCurrentUser(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM " + table + " WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            user = new User();

            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public void createNewUser(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO "+ table +"(`name`, `surname`, `email`) VALUE (?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE " + table + " SET name=?, surname=?, email=? WHERE id=?");

            preparedStatement.setString(1, updatedUser.getName());
            preparedStatement.setString(2, updatedUser.getSurname());
            preparedStatement.setString(3, updatedUser.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM " + table + " WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
