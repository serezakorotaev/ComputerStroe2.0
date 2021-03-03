package ru.Korotaev.ComputerStore.RegistrationorsignIn.Computerstoreservlets;

import ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.ComputerDao;
import ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Computer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.ConnectionData.*;

/***
 * This class with doGet method which forwarded on jsp page with Computer2.
 * doPost method catch new computer's count in warehouse and old count updated on (new count - old count).
 * If new count more then old count then doPost send message that in warehouse hasn't there things.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class Computer2 extends HttpServlet {
    /**
     * This method send on jsp page which show Computer2
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Computers/Computer2.jsp").forward(req , resp);
    }

    /**
     * This method catch new computer's count in warehouse and old count updated on (new count - old count).
     * If new count more then old count then doPost send message that in warehouse hasn't there things.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     * @see ComputerDao
     * @see Computer
     */
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        String strCount = req.getParameter("count");
        int count = Integer.parseInt(strCount);
        Computer computer = new Computer(2);
        ComputerDao computerDao = new ComputerDao();
        try {
            Class.forName(DRIVER);
            computerDao.select(computer);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int newCount = computer.getCount() - count;
        if (newCount < 0) {
            String message = "Столько товара нет в наличии";
            req.setAttribute("message" , message);
            getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Computers/Computer1.jsp").forward(req , resp);
        } else {
            computerDao.updateComputer(newCount , 2);
            req.getRequestDispatcher("/WEB-INF/ComputerStore/ThankYou/Thankyou.jsp").forward(req , resp);
        }
    }
}

