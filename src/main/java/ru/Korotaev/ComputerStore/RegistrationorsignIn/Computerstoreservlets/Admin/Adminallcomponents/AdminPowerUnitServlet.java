package ru.Korotaev.ComputerStore.RegistrationorsignIn.Computerstoreservlets.Admin.Adminallcomponents;

import ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.Componentsdao.PowerUnitDao;
import ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel.PowerUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class create admin page with power unit. Admin can correct count power unit in warehouse.
 * DoGet method send on jsp page which show list with different power units. DoPost method give new count the one
 * admin want to edit this count specific mane plate.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class AdminPowerUnitServlet extends HttpServlet {
    /**
     * This method send on jsp page which show list with different power units
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminPowerUnit.jsp").forward(req , resp);
    }

    /**
     * This method give new count the one
     *  admin want to edit this count specific power unit
     *
     * @param req - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException - include message that this page not found
     * @see PowerUnitDao
     * @see PowerUnit
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
            req.setAttribute("message" , "ожидайте поступление товара");
            if (count >= 0) {
                PowerUnit powerUnit = new PowerUnit(i);
                {
                    powerUnitDao.select(powerUnit);
                    powerUnitDao.updateInPowerUnitQuantityCount(count , powerUnit.getId());
                }
                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminPowerUnit.jsp").forward(req , resp);

                break;
            }
        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminPowerUnit.jsp").forward(req , resp);
    }
}

