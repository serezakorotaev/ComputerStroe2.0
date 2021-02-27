package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Servlet;


import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.UserDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/***
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 * This class show first page with user's registration. He need to write new login and password for registration. After that he can
 * buy different things in computer shop. If user has account yet he can tap on button 'sign in' and go over
 * on next page with entrance where he write his login and password.
 * If user is ADMIN then he is entrancing in admin pages where he might correct count all products on warehouse
 *
 * @see UserSignIn1
 * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.ReadyMadeComputer
 * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.MainPage
 * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components.CreateComputer
 * @see ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.MainPageAdminServlet
 *
 */
public class UserServlet extends HttpServlet{
    /**
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This method show first page with registration or If user has account yet he can tap on button 'sign in' and go over
     * on next page with entrance where he write his login and password.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("<head>\r\n")
                .append("<title> Form input </title>\r\n")
                .append("</head>\r\n")
                .append("<body>\r\n")
                .append("<center>")
                .append("<form action=\"index.jsp\" method=\"POST\">\r\n")
                .append("Enter your login: \r\n")
                .append("<p>")
                .append("<input type=\"text\" name=\"login\" />\r\n")
                .append("</p>")
                .append("</br>")
                .append("Enter your password:")
                .append("<p>")
                .append("<input type=\"password\" name=\"password\" />\r\n")
                .append("</p>")
                .append("<input type=\"submit\" value=\"Registration\" />\r\n")
                .append("</form>\r\n")
                .append("</br>")
                .append("<h3>I have account yet!</h3>")
                .append("<a href=\"UserSignIn1\">Sign in</a>")
                .append("</center>")
                .append("</body>\r\n")
                .append("</html>\r\n");
    }

    /**
     *
     * @param req request
     * @param resp response
     * @throws ServletException include message that something that interfered with its normal operation
     * @throws IOException include message that this page not found
     * This there is check on user is database or no. If yes then send message about it and he entranced on signIn page
     * @see UserSignIn1
     * or result is no then user save in database.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        UserDao userDao = new UserDao();


        String login =req.getParameter("login");
        String password = req.getParameter("password");

        userDao.selectUserByLogin(user,login);

        req.getSession().setAttribute("user",user);

        if(login.equals(user.getLogin())){
            req.setAttribute("errorMessage", "Login exist");
            req.getRequestDispatcher("/WEB-INF/ComputerStore/SignIn.jsp").forward(req,resp);

        } else{
            user.setLogin(login);
            user.setPassword(password);
            userDao.save(user);

            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/WEB-INF/ComputerStore/MainPage.jsp").forward(req,resp);


        }






    }
}
