package mpiatek.app.web;

import mpiatek.app.domain.Newsletter;
import mpiatek.app.service.NewsletterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;

@WebServlet("/newsletter")
public class NewsletterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.sendRedirect("newsletter.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        NewsletterService newsletterService = (NewsletterService) getServletContext().getAttribute("newsletter_service");
        String freq =request.getParameter("radiobtn");
        String sub = request.getParameter("checkboxbtn");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateB = LocalDate.parse(request.getParameter("dateBeg"), formatter);
        LocalDate dateE = LocalDate.parse(request.getParameter("dateEnd"), formatter);
        Date begDate = java.sql.Date.valueOf(dateB);
        Date endDate = java.sql.Date.valueOf(dateE);
        newsletterService.addNewsletter(new Newsletter(
                begDate,
                endDate,
                freq,
                sub));
        getServletContext().setAttribute("newsletter_service",newsletterService);
        out.println("<html><body>Dodano nowy newsletter."+
                "<p><a href=\"http://localhost:8080/zad03/shop\">Wstecz</a></p>" +
                "</body></html>");

    }

}
