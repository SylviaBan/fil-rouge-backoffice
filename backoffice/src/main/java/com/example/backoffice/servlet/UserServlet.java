package com.example.backoffice.servlet;

import com.example.backoffice.emf.ConnexionDb;
import com.example.backoffice.entity.User;
import com.example.backoffice.repository.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/home")
public class UserServlet extends HttpServlet {
    UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                case "/find":
                    findUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        // Mise en place de l'attribut listUser
        List<User> listUser = userRepo.findAll();
        request.setAttribute("listUser", listUser);
        // Vue jsp en request
        request.getRequestDispatcher("/WEB-INF/user-list.jsp")
                .forward(request, response);
    }
    private void findUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        // Demande de saisie de paramètres
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List<User> userFound = (List<User>) userRepo.findUser(username, password);
        request.setAttribute("userFound", userFound);
        // Vue jsp en request
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user-form.jsp");
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        // Demande de saisie de paramètres
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User newUser = new User(username, password, email);
        userRepo.create(newUser);
        // Vue jsp
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        // Demande de saisie de paramètres
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User userUpdated = new User(username, password, email);
        userRepo.update(userUpdated);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));
        userRepo.deleteById(id);
        response.sendRedirect("list");
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userRepo.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

}