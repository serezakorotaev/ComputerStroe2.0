<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.URL" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD" %>
<%@ page import="java.sql.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.MainPlateDao" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.CountInDB.CountMainPlate" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 21.02.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Main Plate</title>
</head>
<body>
<% MainPlateDao mainPlateDao = new MainPlateDao();
    CountMainPlate countMainPlate = new CountMainPlate();
    int n = countMainPlate.count();

    for(int i =1; i<=n;i++){
        ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate mainPlate = new MainPlate(i);
        mainPlateDao.select(mainPlate);%>
<%= mainPlate.getName()%>
Price: <%= mainPlate.getPrice()%>
</br>
Count: <%=mainPlate.getCounts()%>
</br>

<form action="adminmainplate" method="POST">
    Введите кол-во, на которое изменить количество товара
    <p>
        <input type="text" name="count-<%=i%>"/>
        <input type="submit" value="Update"/>
</form>
  <%  }
%>
</body>
</html>