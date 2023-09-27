package com.example.backoffice2.servlet;

import com.example.backoffice2.emf.ConnexionDb;
import com.example.backoffice2.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeactivateUserServlet", value = "/DeactivateUserServlet")
public class ActivateDeactivateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());

        long userId = Long.parseLong(request.getParameter("id"));
        boolean activate = request.getParameter("activate") != null;
        boolean deactivate = request.getParameter("deactivate") != null;

        if (activate) {
            userRepo.activateUser(userId);
        }

        if (deactivate) {
            userRepo.deactivateUser(userId);
        }

    }
}