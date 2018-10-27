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
<%
  for (Router router : storage.getAllRouters()) {
	  out.println("<p>Name: " + router.getName() + "</br> Data produkcji: " + router.getProdDate() + "</br>");
	  out.println("Bezprzewodowy: " + router.getWireless() + "</br> Częstotliwość: " + router.getFrequency() + "</p><hr>");

  }
%>
<p><a href="getRouterData.jsp">Dodaj Router</a></p>
</body>
</html>