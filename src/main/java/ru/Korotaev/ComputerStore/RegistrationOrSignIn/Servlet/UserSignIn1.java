package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Servlet;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.UserDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 * This class show Sign in page with user's entrance. He need to write his login and password for entrance. After that he can
 * buy different things in computer shop.
 * If user is ADMIN then he is entrancing in admin pages where he might correct count all products on warehouse
 *
 * @see UserSignIn1
 * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.ReadyMadeComputer
 * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.MainPage
 * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components.CreateComputer
 * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.MainPageAdminServlet
 *
 */
public class UserSignIn1 extends HttpServlet {
    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method send on jsp page which entrance user where he can to write his login and password
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/SignIn.jsp").forward(req,resp);
    }
    /**
     *
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This there is check on user is database or no. If no then send message about it and he entranced on first page with
     * registration
     * @see UserServlet
     * or result is yes then user sent by main page.
     * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.MainPage
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        UserDao userDao = new UserDao();
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        userDao.selectUserByLoginAndPassword(user,login,password);
        req.getSession().setAttribute("user",user);


        if(login.equals("admin") && password.equals("admin")){
            req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/mainPageAdmin.jsp").forward(req,resp);
        }else
        if(login.equals(user.getLogin()) && password.equals(user.getPassword())){
            req.getRequestDispatcher("/WEB-INF/ComputerStore/MainPage.jsp").forward(req,resp);
        } else{
            req.setAttribute("errorMessage", "Login and password don't exist");
            req.getRequestDispatcher("/WEB-INF/ComputerStore/SignIn.jsp").forward(req,resp);
        }
    }
}
