<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.Computer" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComputerDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %><%--
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
<%= computer.toString()%>
</br>
Количество: <%=computer.getCount()%>
</body>
</html>
