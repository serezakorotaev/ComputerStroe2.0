package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;


import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.PowerUnitDao;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.PowerUnit;

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

public class PowerUnitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/PowerUnit.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(int i=1;i<=5;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);
            if(count!=0){
                PowerUnitDao powerUnitDao = new PowerUnitDao();
                PowerUnit powerUnit = new PowerUnit(i);
                powerUnitDao.select(powerUnit);
                try {
                    Class.forName(DRIVER);
                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

                    PreparedStatement preparedStatement = connection.prepareStatement("insert into shoppingCart (name,price,counts) values (?,?,?) ");
                    preparedStatement.setString(1, powerUnit.getName());
                    preparedStatement.setInt(2,powerUnit.getPrice());
                    preparedStatement.setInt(3,count);
                    preparedStatement.executeUpdate();//добавление в корзину
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

                powerUnitDao.select(powerUnit);
                try{Class.forName(DRIVER);
                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE powerunit set counts=? where id=?");
                    preparedStatement.setInt(1,powerUnit.getCounts()-count);
                    preparedStatement.setInt(2,powerUnit.getId());
                    preparedStatement.executeUpdate();

                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/PowerUnit.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/PowerUnit.jsp").forward(req,resp);

    }
}
