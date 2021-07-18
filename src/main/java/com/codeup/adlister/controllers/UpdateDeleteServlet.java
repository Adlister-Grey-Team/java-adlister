package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.parseLong;

@WebServlet(name = "controller.UpdateDeleteServlet")
public class UpdateDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterValues("deleteUpdate").equals("delete")){
            DaoFactory.getUpDelDao().delete();
        }
    }

}
