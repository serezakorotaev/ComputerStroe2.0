<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.URL" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD" %>
<%@ page import="java.sql.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.MainPlateDao" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 21.02.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Main Plate</title>
</head>
<body>
<% MainPlateDao mainPlateDao = new MainPlateDao();
    final String SELECT_ALL="SELECT * from mainplate";
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
        ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate mainPlate = new MainPlate(i);
        mainPlateDao.select(mainPlate);%>
<%= mainPlate.getName()%>
Price: <%= mainPlate.getPrice()%>
</br>
Count: <%=mainPlate.getCounts()%>
</br>
<% Integer s = i;%>

<form action="adminmainplate" method="POST">
    Введите кол-во, на которое изменить количество товара
    <p>
        <input type="text" name="count-<%=i%>"/>
        <input type="submit" value="Update"/>
</form>
  <%  }
%>
</body>
</html>
