package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.AdminAllComponents;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.CountInDB.CountRamMemory;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.RamMemoryDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.RamMemory;

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

public class AdminRamMemoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminRammemory.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountRamMemory countRamMemory = new CountRamMemory();
        int n = countRamMemory.count();
        for(int i=0;i<n;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);
            req.setAttribute("message","ожидайте поступление товара");
            if(count>=0){
                RamMemoryDao ramMemoryDao = new RamMemoryDao();
                RamMemory ramMemory = new RamMemory(i);
                ramMemoryDao.select(ramMemory);

                try{Class.forName(DRIVER);
                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE rammemory set counts=? where id=?");
                    preparedStatement.setInt(1,count);
                    preparedStatement.setInt(2,ramMemory.getId());
                    preparedStatement.executeUpdate();

                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminRammemory.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminRammemory.jsp").forward(req,resp);

    }
    }

