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

<h4>Available Blocks</h4>
    <%
        for(Map.Entry<Integer, Block> entry : blockService.getMap().entrySet()) {
    %>
        <form action="addToCart.jsp" method="post">
        <p><%out.println(entry.getValue());%>
        <input type="hidden" name="id" value="<%out.print(entry.getKey());%>">
        <br>
        <input type="submit" value="Add to cart"></p></form>
    <%
    }
%>
<h3>Cart</h3>
<%
    if (cart!=null)
    for(Block r : cart.getCart()){ %><p><%out.println(r);}%></p><%
%>

</body>
</html>