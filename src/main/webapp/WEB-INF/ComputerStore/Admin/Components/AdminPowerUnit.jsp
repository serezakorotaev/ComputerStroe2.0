<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.PowerUnitDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.URL" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.PowerUnit" %>
<%@ page import="java.sql.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 21.02.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin power unit</title>
</head>
<body>
<% PowerUnitDao powerUnitDao = new PowerUnitDao();
    int n = powerUnitDao.countPowerUnit();

    for(int i =1; i<=n;i++){
        PowerUnit powerUnit = new PowerUnit(i);
        powerUnitDao.select(powerUnit);%>
<%= powerUnit.getName()%>
Price: <%= powerUnit.getPrice()%>
</br>
Count: <%=powerUnit.getCounts()%>
<% if(powerUnit.getCounts() == 0){ %>
${message}
<% } %>
</br>


<form action="adminpowerunit" method="POST">
    Введите новое кол-во товара
    <p>
        <input type="text" name="count-<%=i%>"/>
        <input type="submit" value="Update"/>
</form>
<%  }
%>
</br>
<a href="allcomponentsadmin">Назад к компонентам</a>
</body>
</html>
