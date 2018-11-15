<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RODO</title>
</head>
<body>
<h1>RODO</h1>

<form action="gdprCheck.jsp" method="POST">
    Czy akceptujesz?
    <input type="checkbox" name="gdpr" id="" value=""><br>
    Czy chcesz otrzymywać newsletter?
    <input type="checkbox" name="newsletter" id="" value="">
    <input type="submit" value="OK">
</form>
<%
String pg = "http://127.0.0.1:8080/zad03/shop";
String pg2 = "http://127.0.0.1:8080/zad03";
if(session.getAttribute("gdprStatus") != null){
  response.sendRedirect(pg);
}
%>

</body>
</html>