package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.User;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;

public class UserDao {//нужны только методы удаления и сохранения пользователя. Возможно для админки понадобится показ всех.
    public void save(User user){
        final String INSERT_QUERY = "INSERT INTO Users (login,password) VALUES (?,?)";
        try(
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            ResultSet  resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            }
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    public void delete(User user){
        final String DELETE_QUERY = "DELETE FROM Users WHERE id=?";
        try(
                Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)){
            preparedStatement.setInt(1,user.getId());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}
