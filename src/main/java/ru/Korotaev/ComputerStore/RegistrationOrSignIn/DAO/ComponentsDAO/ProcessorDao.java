package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.Processor;

import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

public class ProcessorDao {
    public void select(Processor processor) {
        final String SELECT_QUERY = "Select * from processor where id=?";

        try {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1,processor.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE processor set counts=? where id=?");
            preparedStatement.setInt(1,count);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public int countProcessor(){
        final String SELECT_ALL="SELECT * from processor";

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
