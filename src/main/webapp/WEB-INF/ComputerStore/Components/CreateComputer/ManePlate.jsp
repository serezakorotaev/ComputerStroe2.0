<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.MainPlateDao" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 15.02.2021
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mane Plate</title>
</head>
<body>
Mane Plates:
</br>
<%
    MainPlateDao mainPlateDao = new MainPlateDao();
    for(int i=1;i<=5;i++){
        MainPlate mainPlate = new MainPlate(i);
        mainPlateDao.select(mainPlate);%>
        <%= mainPlate.getName()%>
Price: <%= mainPlate.getPrice()%>
</br>
Count: <%=mainPlate.getCounts()%>
</br>
<% Integer s = i;%>
<form action="maneplate" method="POST">
    Введите кол-во, которое вы хотите приобрести:
    <p>
        <input type="text" name="count-<%=i%>"/>
        <input type="submit" value="Buy"/>
</form>

</br>
   <% }
%>
</br>
<a href="CreateComputer">назад</a>
</br>
<a href="ShoppingCartServlet">Shopping cart</a>
<a href="mainpage">Main page</a>
</body>
</html>
