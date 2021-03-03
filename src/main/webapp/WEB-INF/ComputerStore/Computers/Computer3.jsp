<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Dao.ComputerDao" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.Computer" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 09.02.2021
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Computer 3</title>
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
Computer3! SuperPuper computer!
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
<form action="Computer3" method="POST">
    Введите кол-во, которое вы хотите приобрести:
    <p>
        <input type="text" name="count"/>
        <input type="submit" value="Buy"/>
</form>
<a href="ReadyMadeComputer">Назад</a>
${message}
</body>
</html>
