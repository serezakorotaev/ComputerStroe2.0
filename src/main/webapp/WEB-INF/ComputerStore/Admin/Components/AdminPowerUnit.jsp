<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.PowerUnitDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.URL" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.PowerUnit" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 21.02.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin power unit</title>
</head>
<body>
<% PowerUnitDao powerUnitDao = new PowerUnitDao();
    final String SELECT_ALL="SELECT * from powerunit";
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
        PowerUnit powerUnit = new PowerUnit(i);
        powerUnitDao.select(powerUnit);%>
<%= powerUnit.getName()%>
Price: <%= powerUnit.getPrice()%>
</br>
Count: <%=powerUnit.getCounts()%>
</br>
<% Integer s = i;%>

<form action="adminpowerunit" method="POST">
    Введите кол-во, на которое изменить количество товара
    <p>
        <input type="text" name="count-<%=i%>"/>
        <input type="submit" value="Update"/>
</form>
<%  }
%>
</body>
</html>
