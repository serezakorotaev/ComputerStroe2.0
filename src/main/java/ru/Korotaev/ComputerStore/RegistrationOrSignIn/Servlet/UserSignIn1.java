package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Servlet;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;


public class UserSignIn1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/SignIn.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        String login = req.getParameter("login");
        String password = req.getParameter("password");



        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users where login = ? and password=?");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);

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
            req.getRequestDispatcher("/WEB-INF/ComputerStore/MainPage.jsp").forward(req,resp);
        } else{
            req.setAttribute("errorMessage", "Login and password don't exist");
            req.getRequestDispatcher("/WEB-INF/ComputerStore/SignIn.jsp").forward(req,resp);
        }
    }
}
