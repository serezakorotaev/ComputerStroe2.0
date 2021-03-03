package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Dao.ComponentsDAO.RamMemoryDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * This class implements page with list different RAM Memory. User can get different count RAM Memory.
 * doGet method forwarded on the jsp pages with list RAM Memories.
 * doPost method implements different operation with RAM Memories counts in database. After connection
 * count update in RAM Memory database and value insert in shoppingcart database.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class RamMemoryServlet extends HttpServlet {
    /**
     * This method forwarded on the jsp pages with list RAM Memory.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/RamMemory.jsp").forward(req , resp);
    }

    /**
     * This method implements different operation with RAM Memory counts in database. After connection
     * count update in rammemory database and value insert in shoppingcart database.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     * @see RamMemory
     * @see RamMemoryDao
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
            if (count != 0) {
                RamMemory ramMemory = new RamMemory(i);
                int newCount = ramMemory.getCounts() - count;
                {
                    ramMemoryDao.select(ramMemory);
                    ramMemoryDao.insertPowerUnitIntoShoppingCart(ramMemory.getName() , ramMemory.getPrice() , count);
                    ramMemoryDao.select(ramMemory);
                    ramMemoryDao.updateInPowerUnitQuantityCount(newCount , ramMemory.getId());
                }
                req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/RamMemory.jsp").forward(req , resp);
                break;
            }
        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/RamMemory.jsp").forward(req , resp);
    }
}
