<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Computer" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.ComputerDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.DRIVER" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 22.02.2021
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit computer3</title>
</head>
<body>
<% Computer computer = new Computer(3);
    ComputerDao computerDao = new ComputerDao();
    try {
        Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    computerDao.select(computer);
%>
</br>
<br>
Main plate:
<%= computer.getManeplate()%>
</br>
<br>
Power unit:
<%= computer.getPowerunit()%>
</br>
<br>
Processor:
<%= computer.getProcessor()%>
</br>
<br>
RAM memory:
<%= computer.getRammemory()%>
</br>
<br>
Video card:
<%= computer.getVideocard()%>
</br>
Количество: <%=computer.getCount()%>
<% if(computer.getCount() == 0){ %>
${message}
<% } %>
<form action="admincomputer3" method="POST">
    Введите новое кол-во товара:
    <p>
        <input type="text" name="count"/>
        <input type="submit" value="Update"/>
</form>
</br>
<a href="adminallcomputers">Назад</a>
</body>
</html>
