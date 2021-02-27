package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.ShoppingCartServlet;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ShoppingCartDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/***
 * This class implements page with list different products. User can to see what he put in shopping cart.
 * doGet method forwarded on the jsp pages with list products.
 * doPost method implements different operation with products counts in database. After connection
 * all product delete from shoppingcart database. This mean that user bought products
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class ShoppingCartServlet extends HttpServlet {
    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method forwarded on the jsp pages with list products.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/ShoppingCart/ShoppingCart.jsp").forward(req,resp);
    }

    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method implements different operation with products counts in database. After connection
     * all product delete from shoppingcart database. This mean that user bought products.
     * @see ShoppingCartDao
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCartDao shoppingCartDao = new ShoppingCartDao();
        shoppingCartDao.deleteFromShoppingCart();
        req.getRequestDispatcher("/WEB-INF/ComputerStore/ThankYou/Thankyou.jsp").forward(req,resp);
    }
}
