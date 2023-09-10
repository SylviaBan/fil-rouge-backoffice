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

@WebServlet(name = "AddAdminServlet", value = "/addAdmin")
public class AddAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/add-admin.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        AdminRepository adminRepo = new AdminRepository(ConnexionDb.getInstanceEmf());

        try {
            adminRepo.create(new Admin(login, password));
            request.setAttribute("confirmationMessage", "Administrateur ajouté avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("Error", "This user already exists.");
        }

        // Redirect
        response.sendRedirect(request.getContextPath() + "/listAdmins");
    }
}