package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;


import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Dao.ComponentsDAO.PowerUnitDao;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.PowerUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * This class implements page with list different power unit. User can get different count power unit.
 * doGet method forwarded on the jsp pages with list power units.
 * doPost method implements different operation with power unit counts in database. After connection
 * count update in powerunit database and value insert in shoppingcart database.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class PowerUnitServlet extends HttpServlet {
    /**
     * This method forwarded on the jsp pages with list power units.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/PowerUnit.jsp").forward(req , resp);
    }

    /**
     * This method implements different operation with power unit counts in database. After connection
     * count update in powerunit database and value insert in shoppingcart database.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     * @see PowerUnit
     * @see PowerUnitDao
     */
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        PowerUnitDao powerUnitDao = new PowerUnitDao();
        int n = powerUnitDao.countPowerUnit();
        for (int i = 1; i <= n; i++) {
            String stringCount = req.getParameter("count-" + i);
            if (stringCount == null) {
                continue;
            }
            int count = Integer.parseInt(stringCount);
            if (count != 0) {
                PowerUnit powerUnit = new PowerUnit(i);
                int newCount = powerUnit.getCounts() - count;
                {
                    powerUnitDao.select(powerUnit);
                    powerUnitDao.insertPowerUnitIntoShoppingCart(powerUnit.getName() , powerUnit.getPrice() , count);
                    powerUnitDao.select(powerUnit);
                    powerUnitDao.updateInPowerUnitQuantityCount(newCount , powerUnit.getId());
                }
                req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/PowerUnit.jsp").forward(req , resp);
                break;
            }
        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/PowerUnit.jsp").forward(req , resp);
    }
}
