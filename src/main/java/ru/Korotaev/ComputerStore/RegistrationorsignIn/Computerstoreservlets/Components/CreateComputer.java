package ru.Korotaev.ComputerStore.RegistrationorsignIn.Computerstoreservlets.Components;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * This class with doGet method which forwarded on jsp page with links on pages with different components.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class CreateComputer extends HttpServlet {
    /**
     * This method send on jsp page which show page with links on pages with different components.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/CreateComputer.jsp").forward(req , resp);
    }
}
