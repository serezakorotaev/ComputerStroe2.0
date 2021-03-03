<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 02.02.2021
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<%
User user = (User) session.getAttribute("user");
%>
Welcome
<%=user.getLogin()%> !
<br/>
You can to create your computer!
</br>
<center><p>
    <a href="CreateComputer">Create your own computer from components</a>
</p>
    <p>
    <a href="ReadyMadeComputer">Ready-made computers</a>
    </p><p>
    <a href="ShoppingCartServlet">Shopping cart</a>
    </p>
    <p>
        <a href="index.jsp">Выход</a>
    </p>


</center>
</body>
</html>
