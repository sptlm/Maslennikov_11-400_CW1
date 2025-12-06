package kfu.itis.maslennikov.hw7.server;

import kfu.itis.maslennikov.hw7.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "SignUp", urlPatterns = "/sign_up")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sign_up.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // registration
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        Part part = req.getPart("file");

        if (UserServiceImpl.signUp(login, password, name, lastname, part)) {
            resp.sendRedirect("registered.ftl");
        } else {
            resp.sendRedirect("user_already_exists.ftl");
        }
    }
}
