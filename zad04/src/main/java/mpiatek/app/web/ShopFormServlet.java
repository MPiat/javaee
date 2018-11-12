package mpiatek.app.web;

import mpiatek.app.domain.Router;
import mpiatek.app.service.RouterService;
import mpiatek.app.service.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/shop")
public class ShopFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(request.getSession().getAttribute("newsletterStatus") != null){
            out.print("<p> Newsletter zaakceptowany.</p>");
        }
        if(getServletContext().getAttribute("router_service")!=null) {
            out.println("<h2>Routery</h2>");
            RouterService routerService = (RouterService) getServletContext().getAttribute("router_service");
            for(Router router : routerService.getMap().values()) {
                out.println("<p>Nazwa:" + router.getName() + "<br>Data produkcji: "
                        + router.getDateOfProduction() +  "<br>Częstotliwość: "+ router.getFrequency());
                if(router.isWireless()) {
                    out.print("<br> Bezprzewodowy</p>");
                } else {
                    out.print("<br> Przewodowy</p>");
                }
                out.print("<form action=\"shop\" method=\"post\">"
                +"<input type=\"hidden\" name=\"id\" value=\""+ router.getId() +"\">" +
                "<input type=\"submit\" value=\"Dodaj do koszyka\"></form></p>");
            }
        } else {
            getServletContext().setAttribute("router_service",new RouterService());
            out.println("<h4>Brak routerów.</h4>");
        }
        if(ShopService.getCart(request)!=null) {
            if (ShopService.getCart(request).size() > 0) {
                out.println("<h2>Twój koszyk</h2>");
                for (Router router : ShopService.getCart(request)) {
                    out.println("<p>Nazwa:" + router.getName() + "<br>Data produkcji: "
                    + router.getDateOfProduction() +  "<br>Częstotliwość: "+ router.getFrequency());
                    if(router.isWireless()) {
                        out.print("<br> Bezprzewodowy</p>");
                    } else {
                        out.print("<br> Przewodowy</p>");
                    }
                }
            } else {
                out.println("<h2>Koszyk jest pusty</h2>");
            }
        }
        else {
            out.println("<h2>Koszyk jest pusty</h2>");
        }
        out.println("<p><a href=\"http://localhost:8080/zad03/add\">Dodaj router</a></p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("cart")!=null) {
            ShopService.addToCart(Integer.parseInt(request.getParameter("id")), request,getServletContext());
        } else {
            request.getSession().setAttribute("cart",new ArrayList<Router>());
            ShopService.addToCart(Integer.parseInt(request.getParameter("id")), request,getServletContext());
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Router dodany do koszyka.");
        out.println("<p><a href=\"http://localhost:8080/zad03/shop\">Wstecz</a></p>");
        out.println("</body></html>");
    }

}
