package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "controllers/CategoriesServlet.java", urlPatterns = "/ads")
//public class CategoriesServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("cats", DaoFactory.getCatDao().printCategories(18L));
//        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
//    }
//}
