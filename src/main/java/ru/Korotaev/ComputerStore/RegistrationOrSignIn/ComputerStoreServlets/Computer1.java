package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComputerDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.Computer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
/***
 * This class with doGet method which forwarded on jsp page with Computer1.
 * doPost method catch new computer's count in warehouse and old count updated on (new count - old count).
 * If new count more then old count then doPost send message that in warehouse hasn't there things.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class Computer1 extends HttpServlet {
    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method send on jsp page which show Computer1
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Computers/Computer1.jsp").forward(req, resp);
    }

    /**
     *
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * @see ComputerDao
     * @see Computer
     * This method catch new computer's count in warehouse and old count updated on (new count - old count).
     * If new count more then old count then doPost send message that in warehouse hasn't there things.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String strCount = req.getParameter("count");
        int count = Integer.parseInt(strCount);


        Computer computer = new Computer(1);
        ComputerDao computerDao = new ComputerDao();

        try{
            Class.forName(DRIVER);
            computerDao.select(computer);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int newCount = computer.getCount() - count;

        if(newCount<0){

            String message= "Столько товара нет в наличии";
            req.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Computers/Computer1.jsp").forward(req,resp);}

        else {

            computerDao.updateComputer(newCount,1);
            req.getRequestDispatcher("/WEB-INF/ComputerStore/ThankYou/Thankyou.jsp").forward(req,resp);

        }
    }
}


