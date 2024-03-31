package org.vyvr.javaprojektzaliczeniowy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vyvr.javaprojektzaliczeniowy.entities.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetCookiesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetCookiesServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Here, add your logic for registering the user, e.g., inserting into a database.
        boolean isRegistrationSuccessful = registerUser(name, surname, password, email);

        if (isRegistrationSuccessful) {
            // Redirect to a login page or a registration success page
            request.setAttribute("successMessage", "Successfully registered");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            // Redirect back to the registration page or to an error page with a message
            request.setAttribute("errorMessage", "Registration Failed");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        processRequest(request, response);
    }

    private boolean registerUser(String name, String surname, String password, String email) {
        // Hash the password here (not covered in this example)

        User newUser = new User(name, surname, password, email);

        try {
            // Obtain a database session
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // Save the user
            session.persist(newUser);

            // Commit the transaction
            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void destroy() {
    }
}