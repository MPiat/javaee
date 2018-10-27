<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="router" class="mpiatek.ug.domain.Router" scope="session" />

<jsp:setProperty name="router" property="*" />

<jsp:useBean id="storage" class="mpiatek.ug.service.StorageService" scope="application" />

<%
  storage.add(router);
%>


<p>Following router has been added to storage: </p>
<p>First name: ${router.name} </p>
<p>
  <a href="index.jsp">Show all routers</a>
</p>
</body>
</html>