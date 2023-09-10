package com.example.backoffice2.servlet;

import com.example.backoffice2.emf.ConnexionDb;
import com.example.backoffice2.entity.Admin;
import com.example.backoffice2.entity.User;
import com.example.backoffice2.repository.AdminRepository;
import com.example.backoffice2.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListAdminsServlet", value = "/listAdmins")
public class ListAdminsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Connexion à la bdd
        AdminRepository adminRepo = new AdminRepository(ConnexionDb.getInstanceEmf());

        List<Admin> admins = adminRepo.findAll();
        request.setAttribute("admins", admins);

        // Affichage de la Vue jsp
        request.getRequestDispatcher("/WEB-INF/list-admins.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Affichage de la Vue jsp
        request.getRequestDispatcher("/WEB-INF/list-admins.jsp")
                .forward(request, response);
    }
}