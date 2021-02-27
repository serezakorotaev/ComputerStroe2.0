package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/***
 * This class with doGet method which forwarded on jsp page with Main page where exist links on pages
 * with all computers, components,shopping cart and exit on registration page.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class MainPage extends HttpServlet {
    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method which forwarded on jsp page with Admin Main page where exist links on pages
     * with all computers, components and exit on registration.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/MainPage.jsp").forward(req,resp);
    }
}
