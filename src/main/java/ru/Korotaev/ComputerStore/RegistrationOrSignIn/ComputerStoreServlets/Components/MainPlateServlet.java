package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;


import ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.CountInDB.CountMainPlate;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.MainPlateDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate;

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


public class MainPlateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/ManePlate.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountMainPlate countMainPlate = new CountMainPlate();
        int n = countMainPlate.count();
        for(int i=1;i<=n;i++){
         String stringCount = req.getParameter("count-"+i);
         if(stringCount==null)
         continue;
         int count = Integer.parseInt(stringCount);
         if(count!=0){
             MainPlateDao mainPlateDao = new MainPlateDao();
             MainPlate mainPlate = new MainPlate(i);//в дао создать метод insert'а с элементами String name, int price,int count
             int newCount = mainPlate.getCounts()-count;


             {
                 mainPlateDao.select(mainPlate);

                 mainPlateDao.insertMainPlateIntoShoppingCart(mainPlate.getName(), mainPlate.getPrice(), count);

                 mainPlateDao.select(mainPlate);//в дао добавить метод update'а , с элементами которые входять это int newCount and int id

                 mainPlateDao.updateInMainPlateQuantityCount(newCount, mainPlate.getId());
             }
             req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/ManePlate.jsp").forward(req,resp);

             break;
         }

     }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/ManePlate.jsp").forward(req,resp);

    }
    }
