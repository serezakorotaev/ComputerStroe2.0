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


public class UserSignIn extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("<head>\r\n")
                .append("<title> Sign in </title>\r\n")
                .append("</head>\r\n")
                .append("<body>\r\n")
                .append("<center>")
                .append("<form action=\"UserSignIn\" method=\"POST\">\r\n")
                .append("Enter your login: \r\n")
                .append("<input type=\"text\" name=\"login\" />\r\n")
                .append("</br>")
                .append("Enter your password:")
                .append("<input type=\"password\" name=\"password\" />\r\n")
                .append("<input type=\"submit\" value=\"Sing in\" />\r\n")
                .append("</form>\r\n")
                .append("</center>")
                .append("</body>\r\n")
                .append("</html>\r\n");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        String login =req.getParameter("login");
        String password = req.getParameter("password");
        user.setLogin(login);
        user.setPassword(password);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
              user.setLogin(resultSet.getString("login"));
              user.setPassword(resultSet.getString("password"));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("user",user);
        if(login.equals(user.getLogin()) && password.equals(user.getPassword())){
            req.getRequestDispatcher("WEB-INF/ComputerStore/MainPage.jsp").forward(req,resp);
        } else {
            req.setAttribute("errorMessage", "Login or password is incorrect");
            req.getRequestDispatcher("UserSignIn").forward(req,resp);
        }

    }
}
