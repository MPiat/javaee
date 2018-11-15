<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Newsletter</title>
</head>
<body>
<h4>Newsletter</h4>
<form action="addNewsletter.jsp" method="POST">
    Data początkowa <input type="text" name="dateBeg" value=""><br>
    Data końcowa <input type="text" name="dateEnd" value=""><br>
    Częstotliwość:
    <input type="radio" name="daily" value=""> Codziennie
    <input type="radio" name="weekly" value=""> Tygodniowo
    <input type="radio" name="monthly" value=""> Miesięcznie
    <br>Tematyka:
    <input type="checkbox" name="wireless" value=""> Routery bezprzewodowe
    <input type="checkbox" name="wired" value=""> Routery przewodowe
    <input type="checkbox" name="isps" value=""> Dostawcy usług internetowych.

    <input type="submit" value="OK">
</form>


  <a href="/shop">Do strony głównej.</a>
</p>
</body>
</html>