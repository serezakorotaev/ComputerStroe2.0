<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.Componentsdao.ProcessorDao" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel.Processor" %>
<%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 15.02.2021
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Processor</title>
</head>
<body>
Processors:
</br>
<%
    ProcessorDao processorDao = new ProcessorDao();
    int n = processorDao.countProcessor();
    for(int i=0;i<n;i++){
        Processor processor = new Processor(i);
        processorDao.select(processor);%>
<%= processor.getName()%>
Price: <%= processor.getPrice()%>
<br>
Count: <%=processor.getCounts()%>
</br>
<% Integer s = i;%>
<form action="processor" method="POST">
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
