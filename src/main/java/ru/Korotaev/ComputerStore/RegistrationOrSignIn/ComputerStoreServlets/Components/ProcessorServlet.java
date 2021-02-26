package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.CountInDB.CountProcessor;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.ProcessorDao;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.Processor;

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

public class ProcessorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/Processor.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountProcessor countProcessor = new CountProcessor();
        int n = countProcessor.count();
        for(int i=0;i<n;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);
            if(count!=0) {
                ProcessorDao processorDao = new ProcessorDao();
                Processor processor = new Processor(i);//в дао создать метод insert'а с элементами String name, int price,int count
                int newCount = processor.getCounts() - count;

                {
                    processorDao.select(processor);
                    processorDao.insertPowerUnitIntoShoppingCart(processor.getName(), processor.getPrice(), count);
                    processorDao.select(processor);//в дао добавить метод update'а , с элементами которые входять это int newCount and int id
                    processorDao.updateInPowerUnitQuantityCount(newCount, processor.getId());
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/Processor.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/Processor.jsp").forward(req,resp);

    }
}
