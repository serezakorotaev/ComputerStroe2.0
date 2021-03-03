package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Dao.ComponentsDAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;

/***
 * This DAO class with method for connection and actions with mainplate Database. It is
 * select all information about main plate which has specified value id, insert main plate into shoppingCart with
 * specified value count,update in main plate quantity count on quantity value count and found counts how mane different plate
 * on the warehouse.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class MainPlateDao {
    /**
     * @param manePlate - is mane plate object with specified id by which found name,
     *                  price and count it is main plate.
     * @see MainPlate
     */
    public void select(MainPlate manePlate) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from mainplate where id=?");
            preparedStatement.setInt(1 , manePlate.getId());
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

    /**
     * @param name  - by specified main plate which user choose
     * @param price - by specified main plate
     * @param count - by specified main plate
     * @see MainPlate
     */
    public void insertMainPlateIntoShoppingCart(String name , int price , int count) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into shoppingCart (name,price,counts) values (?,?,?) ");
            preparedStatement.setString(1 , name);
            preparedStatement.setInt(2 , price);
            preparedStatement.setInt(3 , count);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param count - is value by which update count in warehouse about main plate
     * @param id    - specified indicator main plate
     * @see MainPlate
     */
    public void updateInMainPlateQuantityCount(int count , int id) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Update mainPlate set counts=? where id=?");
            preparedStatement.setInt(1 , count);
            preparedStatement.setInt(2 , id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return - count lines from mainplate Database
     */
    public int countMainPlate() {
        int n = 0;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from mainplate");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                n++;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
