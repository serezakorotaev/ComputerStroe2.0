<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.VideoCardDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.VideoCard" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 21.02.2021
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Video card</title>
</head>
<body>
<% VideoCardDao videoCardDao = new VideoCardDao();
    final String SELECT_ALL="SELECT * from videocard";
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
        VideoCard videoCard = new VideoCard(i);
        videoCardDao.select(videoCard);%>
<%= videoCard.getName()%>
Price: <%= videoCard.getPrice()%>
</br>
Count: <%=videoCard.getCounts()%>
</br>
<% Integer s = i;%>

<form action="adminvideocard" method="POST">
    Введите кол-во, на которое изменить количество товара
    <p>
        <input type="text" name="count-<%=i%>"/>
        <input type="submit" value="Update"/>
</form>
<%  }
%>
</body>
</html>
