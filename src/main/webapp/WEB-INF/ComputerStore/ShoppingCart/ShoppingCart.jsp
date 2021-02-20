<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ModelShoppingCart.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.URL" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 17.02.2021
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
Your cart:
</br>
<%  final String SELECT_QUERY = "Select * from shoppingCart";
ShoppingCart shoppingCart = new ShoppingCart();
    try{
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);


        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            shoppingCart.setId(resultSet.getInt("id"));
            shoppingCart.setName(resultSet.getString("name"));
            shoppingCart.setPrice(resultSet.getInt("price"));
            shoppingCart.setCounts(resultSet.getInt("counts"));
            %>
            <%= shoppingCart.toString()%>
</br>
</br>
<%
        }
        }catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }



%>


<form action="ShoppingCartServlet" method="POST">
    Купить эти продукты
        <input type="submit" value="Buy"/>
</form>
<input type="button" onclick="history.back();" value="Назад"/>

</body>
</html>
