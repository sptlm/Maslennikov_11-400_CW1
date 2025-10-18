package kfu.itis.maslennikov.server;

import kfu.itis.maslennikov.dto.UserDto;
import kfu.itis.maslennikov.service.UserService;
import kfu.itis.maslennikov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Main", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String sessionUser = (String) req.getSession().getAttribute("user");
//        if (sessionUser == null) {
//            resp.sendRedirect("login.ftl");
//            return;
//        }

        String cookieUser = "";
        String sessionId = "";
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("user".equalsIgnoreCase(c.getName())) {
                    cookieUser = c.getValue();
                } else if ("jsessionid".equalsIgnoreCase(c.getName())) {
                    sessionId = c.getValue();
                }
            }
        } else {
            sessionId = req.getSession().getId();
        }
        req.setAttribute("cookieUser", cookieUser);
        req.setAttribute("sessionId", sessionId);
        req.setAttribute("sessionUser", sessionUser);
        req.setAttribute("image", userService.getByLogin(sessionUser).getImage());

        //resp.sendRedirect("main.ftl");
        req.getRequestDispatcher("main.ftl").forward(req,resp);
    }

}
