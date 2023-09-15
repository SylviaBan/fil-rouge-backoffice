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

@WebServlet(name = "EditUserServlet", value = "/edit")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Getting id query param (in url)
        String idStr = req.getParameter("id");

        Long idUser = Long.parseLong(idStr);
        UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());
        Optional<User> userOptional = Optional.ofNullable(userRepo.findById(idUser));

        if (userOptional.isPresent()) {
            // Setting data in view
            req.setAttribute("userEdit", userOptional.get());
        } else {
            req.setAttribute("userNotFound", true);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/edit-user.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String photoUrl = request.getParameter("photoUrl");
        String email = request.getParameter("email");

        Long idUser = Long.parseLong(idStr);

        User user = new User(username, password, phoneNumber, photoUrl, email);
        UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());

        try {
            Optional<User> userOptional = Optional.ofNullable(userRepo.findById(idUser));

            if (userOptional.isPresent()) {
                User userEdit = userOptional.get();
                userEdit.setUsername(username);
                userEdit.setPassword(password);
                userEdit.setPhoneNumber((phoneNumber));
                userEdit.setPhotoUrl(photoUrl);
                userEdit.setEmail(email);

                userRepo.update(userEdit);

                //response.sendRedirect(request.getContextPath() + ListUsersServlet.URL);
                response.sendRedirect(request.getContextPath() + "/list");

            } else {
                System.err.println("Impossible de mettre à jour l'utilisateur " + idStr);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}

