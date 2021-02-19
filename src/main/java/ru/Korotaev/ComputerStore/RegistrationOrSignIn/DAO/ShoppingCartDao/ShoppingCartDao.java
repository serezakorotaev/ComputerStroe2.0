package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ShoppingCartDao;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ModelShoppingCart.ShoppingCart;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

public class ShoppingCartDao {
    final String SELECT_QUERY = "Select * from shoppingCart";
        public void select(ShoppingCart shoppingCart){
        try {
        Class.forName(DRIVER);

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            shoppingCart.setId(resultSet.getInt("id"));
            shoppingCart.setName(resultSet.getString("name"));
            shoppingCart.setPrice(resultSet.getInt("price"));
            shoppingCart.setCounts(resultSet.getInt("counts"));
        }
            System.out.println();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}
}
