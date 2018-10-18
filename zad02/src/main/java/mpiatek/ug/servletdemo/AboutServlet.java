package mpiatek.ug.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/about")
public class AboutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(arg0, httpServletResponse);
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<html><body><h1>O mnie</h1><br>To jest strona o mnie.</body></html>");
    }
}