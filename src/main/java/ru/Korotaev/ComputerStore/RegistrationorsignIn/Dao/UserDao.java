package ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao;

import ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.User;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.*;

/***
 * This class has method for action with user database. it is insert new user with specific login and password,
 * select user by specific login or select user by specific login and password.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class UserDao {
    /**
     * @param user - is User object with specified id by which found login and password.
     * @see User
     */
    public void save(User user) {
        try (
                Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement("Insert into Users (login,password) values (?,?)")) {
            preparedStatement.setString(1 , user.getLogin());
            preparedStatement.setString(2 , user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * @param user  - is User object with specified id by which found login and password.
     * @param login - specific field by each user
     * @see User
     */
    public void selectUserByLogin(User user , String login) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * From Users where login = ?");
            preparedStatement.setString(1 , login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setLogin(resultSet.getString("login"));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param user     - is User object with specified id by which found login and password.
     * @param login    - specific field by each user
     * @param password - specific field by each user
     * @see User
     */
    public void selectUserByLoginAndPassword(User user , String login , String password) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from Users where login = ? and password=?");
            preparedStatement.setString(1 , login);
            preparedStatement.setString(2 , password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
