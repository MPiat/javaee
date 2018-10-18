package mpiatek.ug.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(arg0, httpServletResponse);
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<html><body><h1>Linki</h1><a href='http://localhost:8080/zad02/date'>Data</a><br><a href='" +
                "http://localhost:8080/zad02/about'>O mnie</a></body></html>");
    }
}
