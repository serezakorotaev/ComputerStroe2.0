package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Dao.ComponentsDAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.Processor;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

/***
 * This DAO class with method for connection and actions with processor Database. It is
 * select all information about processor which has specified value id, insert processor into shoppingCart with
 * specified value count,update in processor quantity count on quantity value count and found counts how mane different processor
 * on the warehouse.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class ProcessorDao {
    /**
     * @param processor - is processor object with specified id by which found name,
     *                  price and count it is processor.
     * @see Processor
     */
    public void select(Processor processor) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from processor where id=?");
            preparedStatement.setInt(1 , processor.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                processor.setId(resultSet.getInt("id"));
                processor.setName(resultSet.getString("name"));
                processor.setPrice(resultSet.getInt("price"));
                processor.setCounts(resultSet.getInt("counts"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name  - by specified processor which user choose
     * @param price - by specified processor
     * @param count - by specified processor
     * @see Processor
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
     * @param count - is value by which update count in warehouse about processor
     * @param id    - specified indicator processor
     * @see Processor
     */
    public void updateInPowerUnitQuantityCount(int count , int id) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Update processor set counts=? where id=?");
            preparedStatement.setInt(1 , count);
            preparedStatement.setInt(2 , id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return - count lines from processor Database
     */
    public int countProcessor() {
        int n = 0;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from processor");
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
