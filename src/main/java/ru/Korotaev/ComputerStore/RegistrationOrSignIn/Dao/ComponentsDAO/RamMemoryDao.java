package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Dao.ComponentsDAO;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

/***
 * This DAO class with method for connection and actions with RAM Memory Database. It is
 * select all information about RAM Memory which has specified value id, insert RAM Memory into shoppingCart with
 * specified value count,update in RAM Memory quantity count on quantity value count and found counts how mane different RAM Memory
 * on the warehouse.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class RamMemoryDao {
    /**
     * @param ramMemory - is RAM Memory object with specified id by which found name,
     *                  price and count it is RAM Memory.
     * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory
     */
    public void select(ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory ramMemory) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from rammemory where id=?");
            preparedStatement.setInt(1 , ramMemory.getId());
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

    /**
     * @param name  - by specified RAM Memory which user choose
     * @param price - by specified RAM Memory
     * @param count - by specified RAM Memory
     * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory
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
     * @param count - is value by which update count in warehouse about RAM Memory
     * @param id    - specified indicator RAM Memory
     * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory
     */
    public void updateInPowerUnitQuantityCount(int count , int id) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Update rammemory set counts=? where id=?");
            preparedStatement.setInt(1 , count);
            preparedStatement.setInt(2 , id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return - count lines from rammemory Database
     */
    public int countRamMemory() {
        int n = 0;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from rammemory");
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
