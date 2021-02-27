package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.AdminAllComponents;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.PowerUnitDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.PowerUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminPowerUnitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminPowerUnit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PowerUnitDao powerUnitDao = new PowerUnitDao();
        int n = powerUnitDao.countPowerUnit();
        for(int i=1;i<=n;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);
            req.setAttribute("message","ожидайте поступление товара");
            if(count>=0){

                PowerUnit powerUnit = new PowerUnit(i);//Смотреть в классы не админских сервлетов. реализовать все в одном дао для упрощения кода
                {
                    powerUnitDao.select(powerUnit);
                    powerUnitDao.updateInPowerUnitQuantityCount(count, powerUnit.getId());
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminPowerUnit.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminPowerUnit.jsp").forward(req,resp);

    }
    }

