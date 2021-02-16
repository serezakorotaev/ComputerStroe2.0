package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.PowerUnit;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

public class PowerUnitDao {
    public void select(PowerUnit powerUnit) {
        final String SELECT_QUERY = "Select * from powerunit";

        try {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                powerUnit.setId(resultSet.getInt("id"));
                powerUnit.setName(resultSet.getString("name"));
                powerUnit.setPrice(resultSet.getInt("price"));
                powerUnit.setCounts(resultSet.getInt("counts"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
