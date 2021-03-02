package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * This class with doGet method which forwarded on jsp page with links on ready-made computers.
 *
 * @see Computer1
 * @see Computer2
 * @see Computer3
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class ReadyMadeComputer extends HttpServlet {
    /**
     * This method which forwarded on jsp page with links on ready-made computers.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/ReadyComputer.jsp").forward(req , resp);
    }
}
