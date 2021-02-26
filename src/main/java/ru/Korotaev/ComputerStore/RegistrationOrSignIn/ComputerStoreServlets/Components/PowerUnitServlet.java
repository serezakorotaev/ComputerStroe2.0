package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;


import ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.CountInDB.CountPowerUnit;
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
        CountPowerUnit countPowerUnit = new CountPowerUnit();
        int n = countPowerUnit.count();
        for(int i=1;i<=n;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);
            if(count!=0){
                PowerUnitDao powerUnitDao = new PowerUnitDao();
                PowerUnit powerUnit = new PowerUnit(i);//в дао создать метод insert'а с элементами String name, int price,int count
                int newCount =powerUnit.getCounts()-count;
                {
                    powerUnitDao.select(powerUnit);
                    powerUnitDao.insertPowerUnitIntoShoppingCart(powerUnit.getName(), powerUnit.getPrice(), count);
                    powerUnitDao.select(powerUnit);//в дао добавить метод update'а , с элементами которые входять это int newCount and int id
                    powerUnitDao.updateInPowerUnitQuantityCount(newCount, powerUnit.getId());
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/PowerUnit.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/PowerUnit.jsp").forward(req,resp);

    }
}
