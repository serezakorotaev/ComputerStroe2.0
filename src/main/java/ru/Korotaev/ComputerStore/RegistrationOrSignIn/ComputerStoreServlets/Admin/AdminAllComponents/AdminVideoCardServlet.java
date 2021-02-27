package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Admin.AdminAllComponents;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.VideoCardDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.VideoCard;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminVideoCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminVideoCard.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VideoCardDao videoCardDao = new VideoCardDao();
        int n = videoCardDao.countVideoCard();
        for(int i=0;i<n;i++){
            String stringCount = req.getParameter("count-"+i);
            if(stringCount==null)
                continue;
            int count = Integer.parseInt(stringCount);

            req.setAttribute("message","ожидайте поступление товара");

            if(count>=0){
                VideoCard videoCard = new VideoCard(i);//Смотреть в классы не админских сервлетов. реализовать все в одном дао для упрощения кода


                {
                    videoCardDao.select(videoCard);
                    videoCardDao.updateInPowerUnitQuantityCount(count, videoCard.getId());
                }

                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminVideoCard.jsp").forward(req,resp);

                break;
            }

        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminVideoCard.jsp").forward(req,resp);

    }
    }

