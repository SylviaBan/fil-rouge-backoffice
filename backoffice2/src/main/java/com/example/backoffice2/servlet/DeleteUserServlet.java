package com.example.backoffice2.servlet;

import com.example.backoffice2.emf.ConnexionDb;
import com.example.backoffice2.entity.User;
import com.example.backoffice2.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Affichage de la Vue jsp
        request.getRequestDispatcher("/WEB-INF/list-users.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());

        String idToDelete = request.getParameter("id");
        Long id = Long.parseLong(idToDelete);

        userRepo.deleteById(id);
        response.sendRedirect("list");
    }
}