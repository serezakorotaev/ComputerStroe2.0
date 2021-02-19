<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Servlet.UserSignIn1" %>
<%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 03.02.2021
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns: th="http://www.thymeleaf.org" xmlns:th="http://www.w3.org/1999/xhtml">
<head>

    <title>Sign in</title>

</head>
<body>
<center>
    <form action="UserSignIn1" method="POST">
        Enter your login:
    <p>
        <input type="text" name="login" />
        <div style="color:green" th:if="${fields.hasErrors('login')}" th:errors="*{login}">login should be not empty :)</div>
    </p>
    </br>
        Enter your password:
        <p>
            <input type="password" name="password"/>
        <div style="color:green" th:if="${fields.hasErrors('password')}" th:errors="*{password}">password should be not empty :)</div>
        </p>
        <input type="submit" value="Sign in"/>
    </form>
    <div style="color: red"><h2>${errorMessage} </h2> </div>

    <br>
    <button type="button"><a href="index.jsp">назад на регистрацию</a> </button>
</center>

</body>
</html>
