package com.example.backoffice2.servlet;

import com.example.backoffice2.emf.ConnexionDb;
import com.example.backoffice2.repository.AdminRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Déclaration variables
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Connexion à la bdd
        AdminRepository adminRepo = new AdminRepository(ConnexionDb.getInstanceEmf());

        try {
            adminRepo.findAdmin(login, password);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("Error", "Compte déjà existant.");
            request.getRequestDispatcher("/WEB-INF/login.jsp");
        }

        response.sendRedirect(request.getContextPath() + "/home-admin");
    }
}