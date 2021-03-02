package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.ProcessorDao;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * This class implements page with list different processor. User can get different count processor.
 * doGet method forwarded on the jsp pages with list processors.
 * doPost method implements different operation with processor counts in database. After connection
 * count update in processor database and value insert in shoppingcart database.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class ProcessorServlet extends HttpServlet {
    /**
     * This method forwarded on the jsp pages with list processors.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/Processor.jsp").forward(req , resp);
    }

    /**
     * This method implements different operation with processor counts in database. After connection
     * count update in processor database and value insert in shoppingcart database.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     * @see Processor
     * @see ProcessorDao
     */
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        ProcessorDao processorDao = new ProcessorDao();
        int n = processorDao.countProcessor();
        for (int i = 0; i < n; i++) {
            String stringCount = req.getParameter("count-" + i);
            if (stringCount == null) {
                continue;
            }
            int count = Integer.parseInt(stringCount);
            if (count != 0) {
                Processor processor = new Processor(i);
                int newCount = processor.getCounts() - count;
                {
                    processorDao.select(processor);
                    processorDao.insertPowerUnitIntoShoppingCart(processor.getName() , processor.getPrice() , count);
                    processorDao.select(processor);
                    processorDao.updateInPowerUnitQuantityCount(newCount , processor.getId());
                }
                req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/Processor.jsp").forward(req , resp);
                break;
            }
        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/Processor.jsp").forward(req , resp);
    }
}
