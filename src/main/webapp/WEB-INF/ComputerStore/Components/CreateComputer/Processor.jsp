<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.ProcessorDao" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.Processor" %><%--
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
    for(int i=0;i<5;i++){
        Processor processor = new Processor(i);
        processorDao.select(processor);%>
<%= processor.getName()%>
Price: <%= processor.getPrice()%>
<br>
Count: <%=processor.getCounts()%>
<% }
%>
</body>
</html>
