<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.RamMemoryDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory" %>
<%@ page import="java.sql.*" %><%--
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
    final String SELECT_ALL="SELECT * from rammemory";
    int n = 0;
    try{
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            n++;
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }

    for(int i =1; i<=n;i++){
        RamMemory ramMemory = new RamMemory(i);
        ramMemoryDao.select(ramMemory);%>
<%= ramMemory.getName()%>
Price: <%= ramMemory.getPrice()%>
</br>
Count: <%=ramMemory.getCounts()%>
</br>
<% Integer s = i;%>

<form action="adminrammemory" method="POST">
    Введите кол-во, на которое изменить количество товара
    <p>
        <input type="text" name="count-<%=i%>"/>
        <input type="submit" value="Update"/>
</form>
<%  }
%>
</body>
</html>
