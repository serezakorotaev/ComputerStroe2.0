package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;


import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.MainPlateDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * This class implements page with list different main plate. User can get different count main plates.
 * doGet method forwarded on the jsp pages with list main plates.
 * doPost method implements different operation with main plate counts in database. after connection
 * count update in mainplate database and value insert in shoppingcart database.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class MainPlateServlet extends HttpServlet {
    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method forwarded on the jsp pages with list main plates.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/ManePlate.jsp").forward(req,resp);
    }

    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method implements different operation with main plate counts in database. after connection
     * count update in mainplate database and value insert in shoppingcart database.
     * @see MainPlate
     * @see MainPlateDao
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MainPlateDao mainPlateDao = new MainPlateDao();
        int n = mainPlateDao.countMainPlate();
        for(int i=1;i<=n;i++){
         String stringCount = req.getParameter("count-"+i);
         if(stringCount==null)
         continue;
         int count = Integer.parseInt(stringCount);
         if(count!=0){
             MainPlate mainPlate = new MainPlate(i);
             int newCount = mainPlate.getCounts()-count;


             {
                 mainPlateDao.select(mainPlate);

                 mainPlateDao.insertMainPlateIntoShoppingCart(mainPlate.getName(), mainPlate.getPrice(), count);

                 mainPlateDao.select(mainPlate);

                 mainPlateDao.updateInMainPlateQuantityCount(newCount, mainPlate.getId());
             }
             req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/ManePlate.jsp").forward(req,resp);

             break;
         }

     }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/ManePlate.jsp").forward(req,resp);

    }
    }
