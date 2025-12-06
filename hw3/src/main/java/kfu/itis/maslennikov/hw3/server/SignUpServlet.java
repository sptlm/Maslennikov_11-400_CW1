package kfu.itis.maslennikov.hw3.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUp", urlPatterns = "/sign_up")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sign_up.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // registration

        // DONE: persist in memory (Map) login + pasword and after use it in LoginServlet instead of "login" and "password"
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (Users.signUp(login, password)) {
            resp.sendRedirect("registered.html");
        } else {
            resp.sendRedirect("user_already_exists.html");
        }
    }
}
