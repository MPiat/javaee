<%@page import="mpiatek.ug.domain.Router"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sklep z Routerami</title>
</head>
<body>
<h1>Sklep z Routerami</h1>
<jsp:useBean id="storage" class="mpiatek.ug.service.StorageService" scope="application" />
<p><a href="showCart.jsp">Koszyk</a></p>
<%
  for (Router router : storage.getAllRouters()) {
	  out.println("<p>Name: " + router.getName() + "</br> Data produkcji: " + router.getProd() + "</br>");
	  out.println("Bezprzewodowy: " + router.getWireless() + "</br> Częstotliwość: " + router.getFrequency() + "</p><hr>");
      out.println("<form action='addCart.jsp' method='post'>");

        out.println("<input type='hidden' name='name' value="+router.getName()+" /><br />");
        out.println("<input type='hidden'  name='prod' value="+router.getProd()+" /><br />");
        out.println("<input type='hidden'  name='wireless' value="+router.getWireless()+" /><br />");
        out.println("<input type='hidden'  name='frequency' value="+router.getFrequency()+" /><br />");

        out.println("<input type='submit' value='Kup'>");

      out.println("</form>");
  }
%>
<p><a href="getRouterData.jsp">Dodaj Router</a></p>

</body>
</html>