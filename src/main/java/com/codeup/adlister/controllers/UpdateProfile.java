package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.VerifyData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updateProfile")
public class UpdateProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        if (request.getSession().getAttribute("user") != null && request.getSession().getAttribute("allowEdit") == null) {
            request.getSession().setAttribute("allowEdit", "yes");
            request.getSession().removeAttribute("user");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        User loggedInUser = (User) request.getSession().getAttribute("user");
        String username = loggedInUser.getUsername();
        request.setAttribute("usersInputUsername", username);
        request.getRequestDispatcher("/WEB-INF/updateProfile.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User loggedInUser = (User) request.getSession().getAttribute("user");
        String username = loggedInUser.getUsername();
        request.setAttribute("usersInputUsername", username);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");


        boolean updatedProfileVerified = VerifyData.checkUserInputAndGenerateErrorMessages(
                request, response, email, password, confirmPassword, "updateProfile");

        if (updatedProfileVerified){
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().updateUser(user);
        }
        request.getSession().removeAttribute("allowEdit");
        response.sendRedirect("/login");
    }
}


