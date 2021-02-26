package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComputerDao;
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


        Computer computer = new Computer(1);
        ComputerDao computerDao = new ComputerDao();

        try{
            Class.forName(DRIVER);
            computerDao.select(computer);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int newCount = computer.getCount() - count;

        if(newCount<0){

            String message= "Столько товара нет в наличии";
            req.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Computers/Computer1.jsp").forward(req,resp);}

        else {

            computerDao.updateComputer(newCount,1);
            req.getRequestDispatcher("/WEB-INF/ComputerStore/ThankYou/Thankyou.jsp").forward(req,resp);

        }
    }
}


