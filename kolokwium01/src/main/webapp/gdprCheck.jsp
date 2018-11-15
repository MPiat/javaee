<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GDPR</title>
</head>
<body>
  <%
    String gdpr = request.getParameter( "gdpr" );
    session.setAttribute( "gdprStatus", gdpr );
    String newsletter = request.getParameter( "newsletter" );
    session.setAttribute( "newsletterStatus", newsletter );
    String pg = "http://127.0.0.1:8080/zad03/shop";
    String pg2 = "http://127.0.0.1:8080/zad03";
    if(session.getAttribute("gdprStatus") != null){
      response.sendRedirect(pg);
    }else{
      response.sendRedirect(pg2);
    }
%>
  <a href="/shop">Do strony głównej.</a>
</p>
</body>
</html>