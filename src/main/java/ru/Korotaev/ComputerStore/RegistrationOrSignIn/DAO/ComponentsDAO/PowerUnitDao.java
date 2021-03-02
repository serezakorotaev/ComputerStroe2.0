package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.PowerUnit;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

/***
 * This DAO class with method for connection and actions with powerunit Database. It is
 * select all information about power unit which has specified value id, insert power unit into shoppingCart with
 * specified value count,update in power unit quantity count on quantity value count and found counts how mane different power unit
 * on the warehouse.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class PowerUnitDao {
    /**
     * @param powerUnit - is power unit object with specified id by which found name,
     *                  price and count it is power unit.
     * @see PowerUnit
     */
    public void select(PowerUnit powerUnit) {
        final String SELECT_QUERY = "Select * from powerunit where id=?";
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1 , powerUnit.getId());
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

    /**
     * @param name  - by specified power unit which user choose
     * @param price - by specified power unit
     * @param count - by specified power unit
     * @see PowerUnit
     */
    public void insertPowerUnitIntoShoppingCart(String name , int price , int count) {
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
     * @param count - is value by which update count in warehouse about power unit
     * @param id    - specified indicator power unit
     * @see PowerUnit
     */
    public void updateInPowerUnitQuantityCount(int count , int id) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE powerunit set counts=? where id=?");
            preparedStatement.setInt(1 , count);
            preparedStatement.setInt(2 , id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return - count lines from powerunit Database
     */
    public int countPowerUnit() {
        final String SELECT_ALL = "SELECT * from powerunit";
        int n = 0;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
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
