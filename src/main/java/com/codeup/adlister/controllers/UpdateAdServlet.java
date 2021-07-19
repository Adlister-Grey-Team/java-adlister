package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.parseLong;

@WebServlet("/updateAd")
public class UpdateAdServlet extends HttpServlet {

    private long adId;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        "updateAd" gets ads id on button click
        adId = Long.parseLong(req.getParameter("updateAd"));
        req.setAttribute("selectedAd", DaoFactory.getAdsDao().findAdByAdId(adId));
//        req.setAttribute("cats", DaoFactory.getCatDao().adCategoriesPerAd(adId));
        req.getRequestDispatcher("/WEB-INF/ads/updateAd.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Category category = new Category();
//        String[] cats = request.getParameterValues("checkbox");

        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                adId,
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );
        DaoFactory.getAdsDao().updateAd(ad);
        response.sendRedirect("/profile");
//        for (String cat : cats) {
//            Long newCat = parseLong(cat);
//            category.setAd_id(adID);
//            category.setCat_id(newCat);
//            DaoFactory.getCatDao().insert(adID, newCat);
//        }
    }
}
