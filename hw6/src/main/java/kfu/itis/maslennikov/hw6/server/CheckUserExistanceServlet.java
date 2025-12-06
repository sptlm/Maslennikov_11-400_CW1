package kfu.itis.maslennikov.hw6.server;

import kfu.itis.maslennikov.hw6.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ajax/user_exists")
public class CheckUserExistanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String login = req.getParameter("login");
        String target = req.getParameter("target");

        if(!UserServiceImpl.userExists(login) && target.equalsIgnoreCase("login")){
            resp.getWriter().write("User with this login do not exist. Try to sign up first.");
        } else if (UserServiceImpl.userExists(login) && target.equalsIgnoreCase("signup")) {
            resp.getWriter().write("User with this login already exists, try to log in.");
        }
    }
}
