<%@ page import="mpiatek.app.domain.Block" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="mpiatek.app.web.NewsletterServlet" %>
<%@ page import="mpiatek.app.service.BlockService" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="blockService" class="mpiatek.app.service.BlockService" scope="application" />
<html>
<body>
Saved!
<a href="shop.jsp">Go to the shop.</a>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    String dateProd = request.getParameter("dateProd");
    Date dateProdD = format.parse(dateProd);



    Block block = new Block(request.getParameter("name"), dateProdD,Double.valueOf(request.getParameter("weight")));
    if(request.getParameter("red")!=null) {block.setRed(true);}
    if(request.getParameter("yellow")!=null) {block.setYellow(true);}
    if(request.getParameter("black")!=null) {block.setBlack(true);}
    blockService.addBlock(block);

%>
</body>
</html>