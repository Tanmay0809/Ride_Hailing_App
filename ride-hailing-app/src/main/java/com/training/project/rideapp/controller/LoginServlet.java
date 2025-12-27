package com.training.project.rideapp.controller;

import com.training.project.rideapp.model.User;
import com.training.project.rideapp.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	// private static final long serialVersionUID = 1L;
    private final AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = authService.login(email, password);

            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);
            session.setAttribute("role", user.getRole());

            response.sendRedirect("jsp/dashboard.jsp");

        } catch (Exception e) {
            request.setAttribute("error", "Invalid credentials");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }
}
