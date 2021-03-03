<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.Componentsdao.VideoCardDao" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.DRIVER" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.PASSWORD" %>
<%@ page import="static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel.VideoCard" %>
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
    <title>Admin Video card</title>
</head>
<body>
<% VideoCardDao videoCardDao = new VideoCardDao();
    int n = videoCardDao.countVideoCard();

    for(int i =1; i<=n;i++){
        VideoCard videoCard = new VideoCard(i);
        videoCardDao.select(videoCard);%>
<%= videoCard.getName()%>
Price: <%= videoCard.getPrice()%>
</br>
Count: <%=videoCard.getCounts()%>
<% if(videoCard.getCounts() == 0){ %>
${message}
<% } %>
</br>


<form action="adminvideocard" method="POST">
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
