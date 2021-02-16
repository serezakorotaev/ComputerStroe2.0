package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate;


import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;

public class MainPlateDao {

    public void select(MainPlate manePlate) {
        final String SELECT_QUERY = "Select * from mainplate where id=?";

        try {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1,manePlate.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                manePlate.setId(resultSet.getInt("id"));
                manePlate.setName(resultSet.getString("name"));
                manePlate.setPrice(resultSet.getInt("price"));
                manePlate.setCounts(resultSet.getInt("counts"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
