package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

public class RamMemoryDao {
    public void select(ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory ramMemory) {
        final String SELECT_QUERY = "Select * from rammemory where id=?";

        try {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1,ramMemory.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE rammemory set counts=? where id=?");
            preparedStatement.setInt(1,count);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int countRamMemory(){
        final String SELECT_ALL="SELECT * from rammemory";

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
