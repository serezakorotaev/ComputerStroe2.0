<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.URL" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.*" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.PASSWORD" %>
<%@ page import="java.sql.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel.MainPlate" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.Componentsdao.MainPlateDao" %>
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
    <title>Admin Main Plate</title>
</head>
<body>
<% MainPlateDao mainPlateDao = new MainPlateDao();
    int n = mainPlateDao.countMainPlate();

    for(int i =1; i<=n;i++){
        ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel.MainPlate mainPlate = new MainPlate(i);
        mainPlateDao.select(mainPlate);%>
<%= mainPlate.getName()%>
Price: <%= mainPlate.getPrice()%>
</br>
Count: <%=mainPlate.getCounts()%>
<% if(mainPlate.getCounts() == 0){ %>
${message}
<% } %>
</br>

<form action="adminmainplate" method="POST">
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
