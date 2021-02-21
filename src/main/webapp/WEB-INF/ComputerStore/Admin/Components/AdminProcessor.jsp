<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.ProcessorDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.URL" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.Processor" %>
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
    <title>Admin processor</title>
</head>
<body>
<% ProcessorDao processorDao = new ProcessorDao();
    final String SELECT_ALL="SELECT * from processor";
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
        Processor processor = new Processor(i);
        processorDao.select(processor);%>
<%= processor.getName()%>
Price: <%= processor.getPrice()%>
</br>
Count: <%=processor.getCounts()%>
</br>
<% Integer s = i;%>

<form action="adminprocessor" method="POST">
    Введите кол-во, на которое изменить количество товара
    <p>
        <input type="text" name="count-<%=i%>"/>
        <input type="submit" value="Update"/>
</form>
<%  }
%>
</body>
</html>
