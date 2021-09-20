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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Long.parseLong;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Category category = new Category();
        String[] cats = request.getParameterValues("checkbox");
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );
        if (cats == null) {
            request.setAttribute("selectCategoryAlert", "<span style=color:red>*</span> Please select a category!");
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
            return;
        }
        Long adID = DaoFactory.getAdsDao().insert(ad);
        for (String cat : cats) {
            Long newCat = parseLong(cat);
            category.setAd_id(adID);
            category.setCat_id(newCat);
            DaoFactory.getCatDao().insert(adID, newCat);
        }
        response.sendRedirect("/ads");
    }
}
