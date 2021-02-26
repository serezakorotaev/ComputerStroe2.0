package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.CountInDB.CountVideoCard;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.VideoCardDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.VideoCard;

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

public class VideoCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/VideoCard.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountVideoCard countVideoCard = new CountVideoCard();
        int n = countVideoCard.count();
        for(int i=0;i<n;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);
            if(count!=0){
                VideoCardDao videoCardDao = new VideoCardDao();
                VideoCard videoCard = new VideoCard(i);//в дао создать метод insert'а с элементами String name, int price,int count
                int newCount =videoCard.getCounts()-count;
                {
                    videoCardDao.select(videoCard);
                    videoCardDao.insertPowerUnitIntoShoppingCart(videoCard.getName(), videoCard.getPrice(), count);
                    videoCardDao.select(videoCard);//в дао добавить метод update'а , с элементами которые входять это int newCount and int id
                    videoCardDao.updateInPowerUnitQuantityCount(newCount, videoCard.getId());
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/VideoCard.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/VideoCard.jsp").forward(req,resp);

    }
}
