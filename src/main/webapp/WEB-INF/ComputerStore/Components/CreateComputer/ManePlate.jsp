<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.ManePlate" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.ManePlateDao" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 15.02.2021
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mane Plate</title>
</head>
<body>
Mane Plates:
</br>
<%
    ManePlateDao manePlateDao = new ManePlateDao();
    for(int i=0;i<5;i++){
        ManePlate manePlate = new ManePlate(i);
        manePlateDao.select(manePlate);%>
        <%= manePlate.getName()%>
Price: <%= manePlate.getPrice()%>
<br>
Count: <%=manePlate.getCounts()%>
   <% }
%>

</body>
</html>
