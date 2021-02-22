package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.AdminAllComponents;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.CountInDB.CountMainPlate;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.MainPlateDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.MainPlate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.*;
import static ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ConnectionData.PASSWORD;

public class AdminMainPlateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminMainPlate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountMainPlate countMainPlate = new CountMainPlate();
        int n = countMainPlate.count();
        for(int i=1;i<=n;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);
            req.setAttribute("message","ожидайте поступление товара");
            if(count>=0){
                MainPlateDao mainPlateDao = new MainPlateDao();
                MainPlate mainPlate = new MainPlate(i);
                mainPlateDao.select(mainPlate);
                try{Class.forName(DRIVER);
                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE mainPlate set counts=? where id=?");
                    preparedStatement.setInt(1,count);
                    preparedStatement.setInt(2,mainPlate.getId());
                    preparedStatement.executeUpdate();

                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminMainPlate.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminMainPlate.jsp").forward(req,resp);

    }
}
