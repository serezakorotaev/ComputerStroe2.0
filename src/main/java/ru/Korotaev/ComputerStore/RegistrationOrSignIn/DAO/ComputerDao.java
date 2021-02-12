package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.Computer;


import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;

public class ComputerDao {

    public void select(Computer computer){
        final String SELECT_QUERY = "Select * from madecomputers where id =?";
        try(
                Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setInt(1, computer.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
               computer.setName(resultSet.getString("name"));
               computer.setManeplate(resultSet.getString("maneplate"));
               computer.setPowerunit(resultSet.getString("powerunit"));
                computer.setProcessor(resultSet.getString("processor"));
                computer.setRammemory(resultSet.getString("rammemory"));
                computer.setVideocard(resultSet.getString("videocard"));
                computer.setCount(resultSet.getInt("counts"));
            }
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}
