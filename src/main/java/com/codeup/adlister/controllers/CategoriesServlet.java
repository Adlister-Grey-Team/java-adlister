package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers/CategoriesServlet.java", urlPatterns = "/category")
public class CategoriesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dropDownVal = request.getParameter("category");
        // need to make the category name show will have to refactor
//        request.setAttribute("result", "Here are the ads for the category: ");
//        request.setAttribute("search", dropDownVal);
        long selectVaL = Long.parseLong(dropDownVal);
        if (selectVaL != 15) {
            request.setAttribute("ads", DaoFactory.getAdsDao().listAdsByCatId(selectVaL));
            request.setAttribute("cats", DaoFactory.getCatDao().all());
            request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp").forward(request, response);
            return;
        }
    }
}

