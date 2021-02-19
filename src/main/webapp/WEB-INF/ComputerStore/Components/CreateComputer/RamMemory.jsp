<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.RamMemoryDao" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 15.02.2021
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RAM memory</title>
</head>
<body>
RAM memories:
</br>
<%
    RamMemoryDao ramMemoryDao = new RamMemoryDao();
    for(int i=0;i<5;i++){
        RamMemory ramMemory = new RamMemory(i);
        ramMemoryDao.select(ramMemory);%>
<%= ramMemory.getName()%>
Price: <%= ramMemory.getPrice()%>
</br>
Count: <%=ramMemory.getCounts()%>
</br>
<% Integer s = i;%>
<form action="rammemory" method="POST">
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
