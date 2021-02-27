package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.VideoCard;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;
/***
 * This DAO class with method for connection and actions with Video Card Database. It is
 * select all information about Video Card which has specified value id, insert Video Card into shoppingCart with
 * specified value count,update in Video Card quantity count on quantity value count and found counts how mane different Video Card
 * on the warehouse.
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class VideoCardDao {
    /**
     *
     * @param videoCard is Video Card object with specified id by which found name,
     *                  price and count it is Video Card.
     * @see VideoCard
     */
    public void select(VideoCard videoCard) {
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

    /**
     *
     * @param name by specified Video Card which user choose
     * @param price by specified Video Card
     * @param count by specified Video Card
     * @see VideoCard
     */
    public void insertPowerUnitIntoShoppingCart(String name,int price,int count){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into shoppingCart (name,price,counts) values (?,?,?) ");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2,price);
            preparedStatement.setInt(3,count);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param count is value by which update count in warehouse about Video Card
     * @param id specified indicator Video Card
     * @see VideoCard
     */
    public void updateInPowerUnitQuantityCount(int count,int id){
        try{Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE videocard set counts=? where id=?");
            preparedStatement.setInt(1,count);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return count lines from videocard Database
     */
    public int countVideoCard(){
        final String SELECT_ALL="SELECT * from videocard";

        int n = 0;

            try{
                Class.forName(DRIVER);
                Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
                connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    n++;
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return n;

    }
}
