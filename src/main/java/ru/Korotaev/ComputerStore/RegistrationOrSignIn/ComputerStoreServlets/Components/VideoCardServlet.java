package ru.Korotaev.ComputerStore.RegistrationOrSignIn.ComputerStoreServlets.Components;

import ru.Korotaev.ComputerStore.RegistrationOrSignIn.DAO.ComponentsDAO.VideoCardDao;
import ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model.ComponentModel.VideoCard;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * This class implements page with list different video card. User can get different count video card.
 * doGet method forwarded on the jsp pages with list Video cards.
 * doPost method implements different operation with Video cards counts in database. After connection
 * count update in videocard database and value insert in shoppingcart database.
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class VideoCardServlet extends HttpServlet {
    /**
     * This method forwarded on the jsp pages with list video card.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/VideoCard.jsp").forward(req , resp);
    }

    /**
     * This method implements different operation with video card counts in database. After connection
     * count update in videocard database and value insert in shoppingcart database.
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     * @see VideoCardDao
     * @see VideoCard
     */
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        VideoCardDao videoCardDao = new VideoCardDao();
        int n = videoCardDao.countVideoCard();
        for (int i = 0; i < n; i++) {
            String stringCount = req.getParameter("count-" + i);
            if (stringCount == null) {
                continue;
            }
            int count = Integer.parseInt(stringCount);
            if (count != 0) {
                VideoCard videoCard = new VideoCard(i);//в дао создать метод insert'а с элементами String name, int price,int count
                int newCount = videoCard.getCounts() - count;
                {
                    videoCardDao.select(videoCard);
                    videoCardDao.insertPowerUnitIntoShoppingCart(videoCard.getName() , videoCard.getPrice() , count);
                    videoCardDao.select(videoCard);//в дао добавить метод update'а , с элементами которые входять это int newCount and int id
                    videoCardDao.updateInPowerUnitQuantityCount(newCount , videoCard.getId());
                }
                req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/VideoCard.jsp").forward(req , resp);
                break;
            }
        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Components/CreateComputer/VideoCard.jsp").forward(req , resp);
    }
}
