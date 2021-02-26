package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Servlet;


import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.UserDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

public class UserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("<head>\r\n")
                .append("<title> Form input </title>\r\n")
                .append("</head>\r\n")
                .append("<body>\r\n")
                .append("<center>")
                .append("<form action=\"index.jsp\" method=\"POST\">\r\n")
                .append("Enter your login: \r\n")
                .append("<p>")
                .append("<input type=\"text\" name=\"login\" />\r\n")
                .append("</p>")
                .append("</br>")
                .append("Enter your password:")
                .append("<p>")
                .append("<input type=\"password\" name=\"password\" />\r\n")
                .append("</p>")
                .append("<input type=\"submit\" value=\"Registration\" />\r\n")
                .append("</form>\r\n")
                .append("</br>")
                .append("<h3>I have account yet!</h3>")
                .append("<a href=\"UserSignIn1\">Sign in</a>")
                .append("</center>")
                .append("</body>\r\n")
                .append("</html>\r\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //регистрация
        User user = new User();
        UserDao userDao = new UserDao();
//        try {
//            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        String login =req.getParameter("login");
        String password = req.getParameter("password");

        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);//создать дао с методами select по логину и паролю. просто по логину
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users where login = ?");
            preparedStatement.setString(1,login);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user.setLogin(resultSet.getString("login"));
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("user",user);

        if(login.equals(user.getLogin())){
            req.setAttribute("errorMessage", "Login exist");
            req.getRequestDispatcher("/WEB-INF/ComputerStore/SignIn.jsp").forward(req,resp);
//            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } else{
            user.setLogin(login);
            user.setPassword(password);
            userDao.save(user);

            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/WEB-INF/ComputerStore/MainPage.jsp").forward(req,resp);


        }






    }
}
