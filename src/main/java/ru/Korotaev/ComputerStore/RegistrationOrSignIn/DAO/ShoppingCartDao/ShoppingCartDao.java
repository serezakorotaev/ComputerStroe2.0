//package ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ShoppingCartDao;
//
//import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ModelShoppingCart.ShoppingCart;
//
//import java.sql.*;
//import java.util.List;
//
//
//import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
//import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;
//
//public class ShoppingCartDao {
//    final String SELECT_QUERY = "Select * from shoppingCart where id=?";
//
//    public void select(ShoppingCart shoppingCart, List<ShoppingCart> shoppingCartList) {
//        Connection connection;
//        PreparedStatement preparedStatement;
//
//        try{
//            Class.forName(DRIVER);
//            connection = DriverManager.getConnection(URL,USER,PASSWORD);
//            preparedStatement = connection.prepareStatement(SELECT_QUERY);
//
//            preparedStatement.setInt(1,shoppingCart.getId());
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet.next()){
//                shoppingCart.setId(resultSet.getInt("id"));
//                shoppingCart.setName(resultSet.getString("name"));
//                shoppingCart.setPrice(resultSet.getInt("price"));
//                shoppingCart.setCounts(resultSet.getInt("counts"));
//                shoppingCartList.add(shoppingCart);
//            } else {
//                preparedStatement.setInt(1, shoppingCart.getId() + 1);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//    }

