<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.PowerUnitDao" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.PowerUnit" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 15.02.2021
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Power unit</title>
</head>
<body>
Power Units:
</br>
<%
    PowerUnitDao powerUnitDao = new PowerUnitDao();
    for(int i=1;i<=5;i++){
        PowerUnit powerUnit = new PowerUnit(i);
        powerUnitDao.select(powerUnit);%>
<%= powerUnit.getName()%>
Price: <%= powerUnit.getPrice()%>
</br>
Count: <%=powerUnit.getCounts()%>
</br>
<form action="powerunit" method="POST">
    Введите кол-во, которое вы хотите приобрести:
    <p>
        <input type="text" name="count"/>
        <input type="submit" value="Buy"/>
</form>
</br>
<% powerUnit.setNumber(i);%>
<% }
%>
</body>
</html>