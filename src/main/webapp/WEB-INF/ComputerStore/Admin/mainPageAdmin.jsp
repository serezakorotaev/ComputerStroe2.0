<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 21.02.2021
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin main page</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
%>
Welcome
<%=user.getLogin()%> !
<br/>
You can to edit computer store.
</br>
<center><p>
    <a href="allcomponentsadmin">Склад</a>
</p>
    <p>
        <a href="ReadyMadeComputer">Все готовые компьютеры</a>
    </p><p>
        <a href="index.jsp">Выход</a>
    </p>


</center>
</body>
</html>
