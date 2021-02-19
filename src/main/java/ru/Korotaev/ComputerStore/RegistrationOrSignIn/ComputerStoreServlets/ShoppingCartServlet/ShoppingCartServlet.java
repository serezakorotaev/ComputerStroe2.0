package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.ShoppingCartServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;

public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/ShoppingCart/ShoppingCart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try{
           Class.forName(DRIVER);
           Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);

           PreparedStatement preparedStatement = connection.prepareStatement("DELETE from shoppingcart");
           preparedStatement.executeUpdate();
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/ThankYou/Thankyou.jsp").forward(req,resp);
    }
}
