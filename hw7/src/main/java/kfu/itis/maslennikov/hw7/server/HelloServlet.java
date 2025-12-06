package kfu.itis.maslennikov.hw7.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;


@WebServlet(name = "Hello", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Hello! This is answer to your GET request! Your request parameters:");
        Map<String, String[]> params = req.getParameterMap();
        for (String key: params.keySet()){
            writer.write(key + "=");
            for (String s : params.get(key)){
                writer.write(s + ", ");
            }
            writer.println();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.write("Servlet got POST request with body: " + body);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.write("Servlet got PUT request with body: " + body);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.write("Servlet got DELETE request with body: " + body);
    }
}
