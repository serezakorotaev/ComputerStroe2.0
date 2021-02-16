package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

public class RamMemoryDao {
    public void select(ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory ramMemory) {
        final String SELECT_QUERY = "Select * from rammemory";

        try {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ramMemory.setId(resultSet.getInt("id"));
                ramMemory.setName(resultSet.getString("name"));
                ramMemory.setPrice(resultSet.getInt("price"));
                ramMemory.setCounts(resultSet.getInt("counts"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
