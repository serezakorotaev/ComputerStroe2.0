<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Computer" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.ComputerDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.DRIVER" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 09.02.2021
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Computer 1</title>
</head>
<body>
<% Computer computer = new Computer(1);
    ComputerDao computerDao = new ComputerDao();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        computerDao.select(computer);
    %>
Computer1! SuperPuper computer!
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
<form action="Computer1" method="POST">
    Введите кол-во, которое вы хотите приобрести:
    <p>
        <input type="text" name="count"/>
    <input type="submit" value="Buy"/>
</form>
${message}
</br>
<a href="ReadyMadeComputer">Назад</a>
</body>
</html>
