package com.example.backoffice2.servlet;

import com.example.backoffice2.emf.ConnexionDb;
import com.example.backoffice2.entity.User;
import com.example.backoffice2.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "SearchUserServlet", value = "/search")
public class SearchUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchUsername = request.getParameter("username");

        UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());

        Optional<User> userFound = Optional.ofNullable(userRepo.findByUsername(searchUsername));
        if (userFound.isPresent()) {
            request.setAttribute("user", userFound.get());
        } else {
            System.err.println("Username not found");
        }

        request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}