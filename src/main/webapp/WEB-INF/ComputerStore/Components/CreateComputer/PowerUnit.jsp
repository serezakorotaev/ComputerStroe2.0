<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.Componentsdao.PowerUnitDao" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel.PowerUnit" %>
<%--
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
    int n = powerUnitDao.countPowerUnit();
    for(int i=1;i<=n;i++){
        PowerUnit powerUnit = new PowerUnit(i);
        powerUnitDao.select(powerUnit);%>
<%= powerUnit.getName()%>
Price: <%= powerUnit.getPrice()%>
</br>
Count: <%=powerUnit.getCounts()%>
</br>
<% Integer s = i;%>
<form action="powerunit" method="POST">
    Введите кол-во, которое вы хотите приобрести:
    <p>
        <input type="text" name="count-<%=s%>"/>
        <input type="submit" value="Buy"/>
</form>
</br>
<% }
%>
<a href="CreateComputer">назад</a>
<p>
    <a href="ShoppingCartServlet">Shopping cart</a>
</p>
<a href="mainpage">Main page</a>
</body>
</html>
