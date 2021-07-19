//package com.codeup.adlister.controllers;
//
//import com.codeup.adlister.dao.DaoFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//
//@WebServlet(urlPatterns = "/delete")
//public class UpdateDeleteServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        if(req.getParameterValues("deleteAd").equals("delete")){
//            Long adIdNum = Long.parseLong(req.getParameter("deleteAd"));
//            DaoFactory.getAdsDao().deleteAdByAdId(adIdNum);
////        }
//        req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
//    }
//}
