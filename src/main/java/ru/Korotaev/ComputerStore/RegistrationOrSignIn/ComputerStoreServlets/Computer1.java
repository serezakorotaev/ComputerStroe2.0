package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.Computer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;

public class Computer1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Computers/Computer1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

String strCount = req.getParameter("count");
int count = Integer.parseInt(strCount);


    Computer computer = new Computer();
    try{
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from MadeComputers where id = ?");
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            computer.setCount(resultSet.getInt("count"));
        }
        connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
        int newCount = computer.getCount() - count;
    if(newCount<0){ getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Computers/Computer1.jsp").forward(req,resp);}
    else {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE MadeComputers SET count=? where id=?");
            preparedStatement.setInt(1, newCount);
            preparedStatement.setInt(2, computer.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                computer.setCount(newCount);
            }
            req.getRequestDispatcher("/WEB-INF/ComputerStore/ThankYou/Thankyou.jsp").forward(req,resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    }
        }


