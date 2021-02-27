package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.AdminAllComponents;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.ProcessorDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class create admin page with processors. Admin can correct count processor in warehouse.
 * DoGet method send on jsp page which show list with different processors. DoPost method give new count the one
 * admin want to edit this count specific processor.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class AdminProcessorServlet extends HttpServlet {
    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method send on jsp page which show list with different processor
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminProcessor.jsp").forward(req,resp);
    }

    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * @see ProcessorDao
     * @see Processor
     * This method give new count the one
     *  admin want to edit this count specific processor
     *  This method give value this field and to do update value count
     *  in processor database. After servlet redirects the user to another page.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProcessorDao processorDao = new ProcessorDao();

        int n = processorDao.countProcessor();
        for(int i=0;i<n;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);
            req.setAttribute("message","ожидайте поступление товара");
            if(count>=0){

                Processor processor = new Processor(i);
                {
                    processorDao.select(processor);
                    processorDao.updateInPowerUnitQuantityCount(count, processor.getId());
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminProcessor.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminProcessor.jsp").forward(req,resp);

    }
    }

