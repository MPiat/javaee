package mpiatek.app.web;

import mpiatek.app.domain.Router;
import mpiatek.app.service.RouterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/add")
public class AddRouterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body><h1>Dodaj Router</h1>" +
                "<form action=\"add\" method=\"post\">" +
                "Nazwa: <input type=\"text\" name=\"name\" value=\"\">" + "<p></p>" +
                "Data produkcji: <input type=\"date\" name=\"dateOfProduction\" value=\"\">" + "<p></p>" +
                "Częstotliwość sygnału: <input type=\"number\" name=\"frequency\" value=\"\">" + "<p></p>" +
                "Bezprzewodowy: <input type=\"checkbox\" name=\"wireless\" value=\"\">"
                + "<input type=\"submit\" value=\"Dodaj do sklepu\"></form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        RouterService routerService = (RouterService) getServletContext().getAttribute("router_service");
        boolean wireless = request.getParameter("wireless")!=null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(request.getParameter("dateOfProduction"), formatter);
        Date myDate = java.sql.Date.valueOf(date);
        routerService.addRouter(new Router(request.getParameter("name"),
                myDate,
                Double.valueOf(request.getParameter("frequency")),
                wireless));
        getServletContext().setAttribute("router_service",routerService);
        out.println("<html><body>Zapisano: "+ routerService.getRouter(routerService.counter-1)  +
                "<p><a href=\"http://localhost:8080/zad03/shop\">Wstecz</a></p>" +
                "<p><a href=\"http://localhost:8080/zad03/add\">Dodaj kolejny router.</a></p>" +
                "</body></html>");

    }
}
