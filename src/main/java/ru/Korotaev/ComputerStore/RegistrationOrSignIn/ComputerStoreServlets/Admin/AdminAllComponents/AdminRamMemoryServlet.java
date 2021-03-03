package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.AdminAllComponents;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Dao.ComponentsDAO.RamMemoryDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class create admin page with RAM Memory. Admin can correct count RAM Memory in warehouse.
 * DoGet method send on jsp page which show list with different RAM Memories. DoPost method give new count the one
 * admin want to edit this count specific RAM Memory.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class AdminRamMemoryServlet extends HttpServlet {
    /**
     * This method send on jsp page which show list with different RAM Memory
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminRammemory.jsp").forward(req,resp);
    }

    /**
     * This method give new count the one
     * admin want to edit this count specific rammemory
     * This method give value this field and to do update value count
     * in rammemory database. After servlet redirects the user to another page.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     * @see RamMemoryDao
     * @see RamMemory
     */
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        RamMemoryDao ramMemoryDao = new RamMemoryDao();
        int n = ramMemoryDao.countRamMemory();
        for (int i = 0; i < n; i++) {
            String stringCount = req.getParameter("count-" + i);
            if (stringCount == null) {
                continue;
            }
            int count = Integer.parseInt(stringCount);
            req.setAttribute("message" , "ожидайте поступление товара");
            if (count >= 0) {
                RamMemory ramMemory = new RamMemory(i);
                {
                    ramMemoryDao.select(ramMemory);
                    ramMemoryDao.updateInPowerUnitQuantityCount(count , ramMemory.getId());
                }
                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminRammemory.jsp").forward(req , resp);
                break;
            }
        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminRammemory.jsp").forward(req , resp);
    }
}

