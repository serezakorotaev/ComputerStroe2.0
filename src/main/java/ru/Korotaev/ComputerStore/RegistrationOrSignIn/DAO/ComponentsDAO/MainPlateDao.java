package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate;


import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;

public class MainPlateDao {

    public void select(MainPlate manePlate) {
        final String SELECT_QUERY = "Select * from mainplate where id=?";

        try {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1,manePlate.getId());
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

    public void insertMainPlateIntoShoppingCart(String name,int price,int count){
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

    public void updateInMainPlateQuantityCount(int count,int id){
        try{Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE mainPlate set counts=? where id=?");
            preparedStatement.setInt(1,count);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int countMainPlate(){
        final String SELECT_ALL="SELECT * from mainplate";

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
