package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.AdminComputers;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComputerDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.Computer;

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
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

public class AdminComputer3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Computers/AdminComputer3.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strCount = req.getParameter("count");
        int count = Integer.parseInt(strCount);


        Computer computer = new Computer(3);
        ComputerDao computerDao = new ComputerDao();
        try{
            Class.forName(DRIVER);
            computerDao.select(computer);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(count==0) {
            req.setAttribute("message", "Ожидайте поступление товара");
        }
        if(count>=0){
            try {
                Class.forName(DRIVER);
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                PreparedStatement preparedStatement = connection.prepareStatement("Update madecomputers SET counts=? where id=3 ");
                preparedStatement.setInt(1, count);
                preparedStatement.executeUpdate();
                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Computers/AdminComputer3.jsp").forward(req,resp);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
