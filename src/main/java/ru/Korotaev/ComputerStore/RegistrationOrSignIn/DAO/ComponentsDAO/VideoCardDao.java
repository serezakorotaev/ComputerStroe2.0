package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

public class VideoCardDao {
    public void select(ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.VideoCard videoCard) {
        final String SELECT_QUERY = "Select * from videocard where  id=?";

        try {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1,videoCard.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                videoCard.setId(resultSet.getInt("id"));
                videoCard.setName(resultSet.getString("name"));
                videoCard.setPrice(resultSet.getInt("price"));
                videoCard.setCounts(resultSet.getInt("counts"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
