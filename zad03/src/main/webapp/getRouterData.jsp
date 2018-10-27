<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="storage" class="mpiatek.ug.service.StorageService" scope="application" />
<jsp:useBean id="router" class="mpiatek.ug.domain.Router" scope="session" />

<form action="addRouter.jsp">

  Nazwa:<input type="text" name="name" value="${router.name}" /><br />
  Data produkcji:<input type="date"  name="prodDate" value="${router.prodDate}" /><br />
  Bezprzewodowy?:<input type="checkbox"  name="wireless" value="${router.wireless}" /><br />
  Czestotliwosc:<input type="number"  name="frequency" value="${router.frequency}" /><br />

  <input type="submit" value=" OK ">

</form>

</body>
</html>