<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ModelShoppingCart.ShoppingCart" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ShoppingCartDao.ShoppingCartDao" %><%--
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
<% ShoppingCart shoppingCart = new ShoppingCart();
    ShoppingCartDao shoppingCartDao = new ShoppingCartDao();

do{int i = 0;
    shoppingCartDao.select(shoppingCart);
if (shoppingCart.getName()==null){
    break;
}%>
</br>
<%=shoppingCart.getName() + " Цена: " + shoppingCart.getPrice() + "руб количество: " + shoppingCart.getCounts()%>
</br>
<%
} while (shoppingCart.getName()==null);

%>

<form action="ShoppingCartServlet" method="POST">
    Купить эти продукты
        <input type="submit" value="Buy"/>
</form>
<input type="button" onclick="history.back();" value="Назад"/>
</body>
</html>
