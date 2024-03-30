package org.vyvr.javaprojektzaliczeniowy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vyvr.javaprojektzaliczeniowy.entities.User;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String inputPassword = request.getParameter("password");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User u WHERE u.email = :email";
            Query<User> result = session.createQuery(hql, User.class)
                    .setParameter("email", email);

            if (!(result == null)) {
                User user = result.getSingleResult();
                if (user.getPassword().equals(inputPassword)) { // For demonstration. Use password hashing in production.
                    request.setAttribute("successMessage", "Login successful.");
                } else {
                    request.setAttribute("errorMessage", "Invalid password.");
                }
            } else {
                request.setAttribute("errorMessage", "User not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred.");
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
