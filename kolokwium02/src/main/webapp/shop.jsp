<%@ page import="mpiatek.app.service.BlockService" %>
<%@ page import="mpiatek.app.service.ShopService" %>
<%@ page import="mpiatek.app.domain.Block" %>
<%@ page import="java.util.Map" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="blockService" class="mpiatek.app.service.BlockService" scope="application" />
<jsp:useBean id="cart" class="mpiatek.app.service.ShopService" scope="session" />
<%
    if(session.getAttribute("rodo")==null) {
        response.sendRedirect("errorRodo.jsp");
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shop</title>
</head>
<body>
<h1>Shop</h1>
<%
    if(session.getAttribute("newsletter")!=null) {
        out.print("<p>Newsletter permitted.</p>");
    }
%>
<a href="block.jsp">Add a block.</a>

<h4>Block</h4>
    <%
        for(Map.Entry<Integer, Block> entry : blockService.getMap().entrySet()) {
    %>
        <form action="addToCart.jsp" method="post">
        <p><%out.println(entry.getValue());%>
        <input type="hidden" name="id" value="<%out.print(entry.getKey());%>">
        <input type="submit" value="Dodaj do koszyka"></p></form>
    <%
    }
%>
<!-- 
All Settings:
<%

    for(Settings settings : settingsService.getSettings()) {
        %>
<form action="addToCart.jsp" method="post">
    <% int idNum = settings.getId();            
    out.print("<input type='hidden' name='id' value='"+ idNum + "'><br>");    %>
        <input type="submit" value="Usun z settings"></form>
        <%

        out.print("<p>" + settings + "</p>");
    }
%> -->
<h3>Koszyk</h3>
<%
    if (cart!=null)
    for(Router r : cart.getCart()){ %><p><%out.println(r);}%></p><%
%>

</body>
</html>