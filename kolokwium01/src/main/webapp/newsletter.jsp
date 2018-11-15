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
<form action="http://localhost:8080/zad03/newsletter" method="POST">
    Data początkowa <input type="text" name="dateBeg" value=""><br>
    Data końcowa <input type="text" name="dateEnd" value=""><br>
    Częstotliwość:
    <input type="radio" name=radiobtn value="daily"> Codziennie
    <input type="radio" name=radiobtn value="weekly"> Tygodniowo
    <input type="radio" name=radiobtn value="monthly"> Miesięcznie
    <br>Tematyka:
    <input type="checkbox" name=checkboxbtn value="wireless"> Routery bezprzewodowe
    <input type="checkbox" name=checkboxbtn value="wired"> Routery przewodowe
    <input type="checkbox" name=checkboxbtn value="isps"> Dostawcy usług internetowych.

    <input type="submit" value="OK">
</form>


  <a href="/shop">Do strony głównej.</a>
</p>
</body>
</html>