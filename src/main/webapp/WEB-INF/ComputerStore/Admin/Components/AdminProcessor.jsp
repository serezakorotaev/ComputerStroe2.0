<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.Componentsdao.ProcessorDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.URL" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel.Processor" %>
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
    <title>Admin processor</title>
</head>
<body>
<% ProcessorDao processorDao = new ProcessorDao();
    int n = processorDao.countProcessor();

    for(int i =1; i<=n;i++){
        Processor processor = new Processor(i);
        processorDao.select(processor);%>
<%= processor.getName()%>
Price: <%= processor.getPrice()%>
</br>
Count: <%=processor.getCounts()%>
<% if(processor.getCounts() == 0){ %>
${message}
<% } %>
</br>


<form action="adminprocessor" method="POST">
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
