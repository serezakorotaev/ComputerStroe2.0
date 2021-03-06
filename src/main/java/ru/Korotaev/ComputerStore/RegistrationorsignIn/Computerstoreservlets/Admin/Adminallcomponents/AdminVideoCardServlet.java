package ru.Korotaev.ComputerStore.RegistrationorsignIn.Computerstoreservlets.Admin.Adminallcomponents;

import ru.Korotaev.ComputerStore.RegistrationorsignIn.Dao.Componentsdao.VideoCardDao;
import ru.Korotaev.ComputerStore.RegistrationorsignIn.Model.Componentmodel.VideoCard;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * In doGet Method forwarded in jsp pages where show list
 * with different video cards. Each one video card has field
 * for entering the value that they want to buy. Button throws in doPost method.
 * This method give value this field and to do update value count
 * in videocard database. After servlet redirects the user to another page.
 *
 * Implementation class of the Video Card Admin page
 * @version 15.0.01
 * @autor Sergey Korotaev
 */
public class AdminVideoCardServlet extends HttpServlet {
    /**
     * This method send on jsp page which show list with different video card
     *
     * @param req  - request
     * @param resp - response
     * @throws ServletException - include message that something that interfered with its normal operation
     * @throws IOException      - include message that this page not found
     */
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminVideoCard.jsp").forward(req , resp);
    }

    /**
     * This method give new count the one
     * admin want to edit this count specific videocard
     * This method give value this field and to do update value count
     * in videocard database. After servlet redirects the user to another page.
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
            req.setAttribute("message" , "ожидайте поступление товара");
            if (count >= 0) {
                VideoCard videoCard = new VideoCard(i);
                {
                    videoCardDao.select(videoCard);
                    videoCardDao.updateInPowerUnitQuantityCount(count , videoCard.getId());
                }
                req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminVideoCard.jsp").forward(req , resp);
                break;
            }
        }
        req.getRequestDispatcher("/WEB-INF/ComputerStore/Admin/Components/AdminVideoCard.jsp").forward(req , resp);
    }
}

