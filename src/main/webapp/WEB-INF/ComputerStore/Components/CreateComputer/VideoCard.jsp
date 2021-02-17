<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.VideoCardDao" %>
<%@ page import="ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.VideoCard" %><%--
  Created by IntelliJ IDEA.
  User: Mvideo
  Date: 15.02.2021
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video card</title>
</head>
<body>
Video cards:
</br>
<%
    VideoCardDao videoCardDao = new VideoCardDao();
    for(int i=0;i<5;i++){
        VideoCard videoCard = new VideoCard(i);
        videoCardDao.select(videoCard);%>
<%= videoCard.getName()%>
Price: <%= videoCard.getPrice()%>
<br>
Count: <%=videoCard.getCounts()%>
</br>
<% Integer s = i;%>
<form action="videocard" method="POST">
    Введите кол-во, которое вы хотите приобрести:
    <p>
        <input type="text" name="count-<%=s%>"/>
        <input type="submit" value="Buy"/>
</form>
<% videoCard.setNumber(i);%>
</br>
<% }
%>
<input type="button" onclick="history.back();" value="Назад"/>
<a href=""
</body>
</html>
