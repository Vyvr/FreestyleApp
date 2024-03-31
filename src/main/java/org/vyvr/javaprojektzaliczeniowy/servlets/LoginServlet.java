package org.vyvr.javaprojektzaliczeniowy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.vyvr.javaprojektzaliczeniowy.entities.User;
import org.vyvr.javaprojektzaliczeniowy.services.UserService;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();
        String email = request.getParameter("email");
        String inputPassword = request.getParameter("password"); // The password provided by the user

        User user = us.getUserByEmail(email);

        
        if (user != null && checkPassword(inputPassword, user.getPassword())) {
            // Password matches, login successful
            request.getSession().setAttribute("students", "Login successful.");
            response.sendRedirect("students.jsp"); // Redirect to index.jsp
        } else {
            // User not found, or password does not match
            request.getSession().setAttribute("errorMessage", "Invalid email or password.");
            response.sendRedirect("login.jsp"); // Assuming you have a login page to show the error
        }
    }

    private boolean checkPassword(String inputPassword, String storedHash) {
        // Placeholder for your password checking logic
        // In a real scenario, you would hash `inputPassword` and compare it with `storedHash`
        // For example, if using BCrypt: return BCrypt.checkpw(inputPassword, storedHash);
        return inputPassword.equals(storedHash); // Simplified for demonstration. Do not use in production.
    }
}
