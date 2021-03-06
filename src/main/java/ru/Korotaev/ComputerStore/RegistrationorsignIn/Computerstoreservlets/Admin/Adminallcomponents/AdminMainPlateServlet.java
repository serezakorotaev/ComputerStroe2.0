package ru.Korotaev.ComputerStore.RegistrationorsignIn.Computerstoreservlets.Admin.Adminallcomponents;


import ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.Componentsdao.MainPlateDao;
import ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel.MainPlate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class create admin page with main plate. Admin can correct count main plate in warehouse.
 * DoGet method send on jsp page which show list with different mane plates. DoPost method give new count the one
 * admin want to edit this count specific mane plate.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class AdminMainPlateServlet extends HttpServlet {
    /**
     * This method send on jsp page which show list with different main plates
     *
     * @param req  request
     * @param resp response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminMainPlate.jsp").forward(req , resp);
    }

    /**
     * This method give new count the one
     * admin want to edit this count specific mane plate
     *
     * @param req - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException - include message that this page not found
     * @see MainPlateDao
     * @see MainPlate
     */
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        MainPlateDao mainPlateDao = new MainPlateDao();
        int n = mainPlateDao.countMainPlate();

        for (int i = 1; i <= n; i++) {
            String stringCount = req.getParameter("count-" + i);
            if (stringCount == null) {
                continue;
            }
            int count = Integer.parseInt(stringCount);
            req.setAttribute("message" , "ожидайте поступление товара");
            if (count >= 0) {
                MainPlate mainPlate = new MainPlate(i);
                {
                    mainPlateDao.select(mainPlate);
                    mainPlateDao.updateInMainPlateQuantityCount(count , mainPlate.getId());
                }
                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminMainPlate.jsp").forward(req , resp);
                break;
            }
        }
            req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminMainPlate.jsp").forward(req , resp);
    }
}
