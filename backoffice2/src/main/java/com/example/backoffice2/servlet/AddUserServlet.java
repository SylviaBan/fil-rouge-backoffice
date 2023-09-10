package com.example.backoffice2.servlet;

import com.example.backoffice2.emf.ConnexionDb;
import com.example.backoffice2.entity.User;
import com.example.backoffice2.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/add-user.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String photoUrl = request.getParameter("photoUrl");
        String email = request.getParameter("email");

        Long phoneNumber = null;
        // Essayez de convertir la chaîne phoneString en Long
        if (phone != null) {
            phoneNumber = Long.parseLong(phone);
        }

        // Connexion à la bdd
        UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());

        try {
            userRepo.create(new User(username, password, phoneNumber, photoUrl, email));
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("Error", "This user already exists.");
        }

        // Redirect
        response.sendRedirect(request.getContextPath() + "/list");
    }
}