package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.AdminComputers;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComputerDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.Computer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;

/***
 * This class with doGet method which forwarded on jsp page with Computer2.
 * doPost method catch new computer's count in warehouse and old count updated on new count.
 * If new count more then old count then doPost send message that in warehouse hasn't there things.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class AdminComputer2 extends HttpServlet {
    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method send on jsp page which show Computer2
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Computers/AdminComputer2.jsp").forward(req,resp);
    }

    /**
     *
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * @see ComputerDao
     * @see Computer
     * This method catch new computer's count in warehouse and old count updated on new count.
     * If new count more then old count then doPost send message that in warehouse hasn't there things.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strCount = req.getParameter("count");
        int count = Integer.parseInt(strCount);


        Computer computer = new Computer(2);
        ComputerDao computerDao = new ComputerDao();
        try{
            Class.forName(DRIVER);
            computerDao.select(computer);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(count==0) {
            req.setAttribute("message", "Ожидайте поступление товара");
        }
        if(count>=0){
            computerDao.updateComputer(count,2);
            req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Computers/AdminComputer2.jsp").forward(req,resp);

        }
    }
}
