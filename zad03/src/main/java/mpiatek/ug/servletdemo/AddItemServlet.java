package mpiatek.ug.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import mpiatek.ug.servletdemo.model.Router;

@WebServlet("/add")
public class AddItemServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(arg0, httpServletResponse);
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        String name = request.getParameter("name");
        Date prodDate = new java.util.Date();
        try {
            //prodDate =  new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("prodDate"));

        }catch (Exception e){
            out.print(e);

        }

        Boolean isWireless = Boolean.parseBoolean(request.getParameter("isWireless"));
//        Double frequency = Double.parseDouble(request.getParameter("frequency"));


        Router router = new Router(name, prodDate, isWireless, 5.0);


        out.print("<html>\n" +
                "   <head>\n" +
                "     <title>Welcome</title>\n" +
                "     <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "   </head>\n" +
                "   <body>\n" +
                "     <h1>Wprowadzanie asortymentu</h1>\n" +
                "\n" +
                "     <p>Podaj dane produktu</p>\n" +
                "     <form action=\"add\" method=\"POST\">\n" +
                "       <label>Nazwa: </label><input type=\"text\" name=\"name\"><br />\n" +
                "       <label>Data produkcji: </label><input type=\"date\" name=\"prodDate\"><br />\n" +
                "       <label>Czy bezprzewodowy: </label><input type=\"checkbox\" name=\"isWireless\"><br />\n" +
                "       <label>Czestotliwosc: </label><input type=\"string\" name=\"frequency\"><br />\n" +
                "       <input type=\"submit\" value=\"Sign-up\">\n" +
                "     </form>\n" +
                "     \n" +
                "   </body>\n" +
                " </html>");


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(arg0, httpServletResponse);
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        String name = request.getParameter("name");
        Date prodDate = new java.util.Date();
        try {
            prodDate =  format.parse(request.getParameter("prodDate"));
        }catch (Exception e){
            out.print(e);

        }

        Boolean isWireless = Boolean.parseBoolean(request.getParameter("isWireless"));
//        TODO: fix the frequency
//        Double frequency = Double.parseDouble(request.getParameter("frequency"));


        Router router = new Router(name, prodDate, isWireless, 5.0);

        out.print(router.prodDate);
        out.print(request.getParameter("prodDate"));
        out.print("<html>\n" +
                "   <head>\n" +
                "     <title>Welcome</title>\n" +
                "     <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "   </head>\n" +
                "   <body>\n" +
                "     <h1>Wprowadzanie asortymentu</h1>\n" +
                "\n" +
                "     <p>Podaj dane produktu</p>\n" +
                "     <form action=\"add\" method=\"POST\">\n" +
                "       <label>Nazwa: </label><input type=\"text\" name=\"name\"><br />\n" +
                "       <label>Data produkcji: </label><input type=\"date\" name=\"prodDate\"><br />\n" +
                "       <label>Czy bezprzewodowy: </label><input type=\"checkbox\" name=\"isWireless\"><br />\n" +
                "       <label>Czestotliwosc: </label><input type=\"string\" name=\"frequency\"><br />\n" +
                "       <input type=\"submit\" value=\"Sign-up\">\n" +
                "     </form>\n" +
                "     \n" +
                "    <h6>Produkt dodany</h6>\n" +
                "   </body>\n" +
                " </html>");


    }
}