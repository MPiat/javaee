<%@ page import="mpiatek.app.domain.Block" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:useBean id="blockService" class="mpiatek.app.service.BlockService" scope="application" />
<jsp:useBean id="cart" class="mpiatek.app.service.ShopService" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Added to cart.</title>
</head>
<body>

<%
    cart.addToCart(blockService.getBlock(Integer.valueOf(request.getParameter("id"))));
    blockService.removeBlock(Integer.valueOf(request.getParameter("id")));
%>

<p>Added to cart.</p>
<p><%blockService.getBlock(Integer.valueOf(request.getParameter("id")));%> </p>
<p>
    <a href="shop.jsp">Back</a>
</p>
</body>
</html>