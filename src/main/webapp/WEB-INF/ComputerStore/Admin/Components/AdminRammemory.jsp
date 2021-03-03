<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Dao.ComponentsDAO.RamMemoryDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory" %>
<%@ page import="java.sql.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 21.02.2021
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin RAM memory</title>
</head>
<body>
<% RamMemoryDao ramMemoryDao = new RamMemoryDao();
    int n = ramMemoryDao.countRamMemory();

    for(int i =1; i<=n;i++){
        RamMemory ramMemory = new RamMemory(i);
        ramMemoryDao.select(ramMemory);%>
<%= ramMemory.getName()%>
Price: <%= ramMemory.getPrice()%>
</br>
Count: <%=ramMemory.getCounts()%>
<% if(ramMemory.getCounts() == 0){ %>
${message}
<% } %>
</br>


<form action="adminrammemory" method="POST">
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
