package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

/***
 * This class has method about delete from shoppingcart database all list products. When delete completed then
 * it's mean that user bought all products
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class ShoppingCartDao {
    /**
     * delete all information from Database
     */
    public void deleteFromShoppingCart() {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from shoppingcart");
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
