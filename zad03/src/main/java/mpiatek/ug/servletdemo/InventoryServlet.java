package mpiatek.ug.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import mpiatek.ug.servletdemo.model.Router;

@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(arg0, httpServletResponse);
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<html><body><h1>Menu</h1><a href='http://localhost:8080/zad03/add'>Dodaj asortyment</a><br><a href='" +
                "http://localhost:8080/zad03/about'>O mnie</a></body></html>");
    }
}
