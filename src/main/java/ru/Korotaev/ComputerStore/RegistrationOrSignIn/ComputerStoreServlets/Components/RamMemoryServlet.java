package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.CountInDB.CountRamMemory;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.MainPlateDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.RamMemoryDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory;

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

public class RamMemoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/RamMemory.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountRamMemory countRamMemory = new CountRamMemory();
        int n = countRamMemory.count();
        for(int i=0;i<n;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);
            if(count!=0){
                RamMemoryDao ramMemoryDao = new RamMemoryDao();
               RamMemory ramMemory = new RamMemory(i);//в дао создать метод insert'а с элементами String name, int price,int count
                int newCount =ramMemory.getCounts()-count;
                {
                    ramMemoryDao.select(ramMemory);
                    ramMemoryDao.insertPowerUnitIntoShoppingCart(ramMemory.getName(), ramMemory.getPrice(), count);
                    ramMemoryDao.select(ramMemory);//в дао добавить метод update'а , с элементами которые входять это int newCount and int id
                    ramMemoryDao.updateInPowerUnitQuantityCount(newCount, ramMemory.getId());
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/RamMemory.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/RamMemory.jsp").forward(req,resp);

    }
}
