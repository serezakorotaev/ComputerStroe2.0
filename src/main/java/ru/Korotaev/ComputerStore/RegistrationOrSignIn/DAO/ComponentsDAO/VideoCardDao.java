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
    public void insertPowerUnitIntoShoppingCart(String name,int price,int count){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into shoppingCart (name,price,counts) values (?,?,?) ");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2,price);
            preparedStatement.setInt(3,count);
            preparedStatement.executeUpdate();//добавление в корзину
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

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
