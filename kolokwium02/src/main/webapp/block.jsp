<jsp:useBean id="blockService" class="mpiatek.app.service.BlockService" scope="application" />
<html><body>
<form action="saveBlock.jsp" method="post">
Production Date:<br>
<input type="date" name="dateProd"><br><br>
<!-- Dla radio name ten sam dla wszystkich. -->
Weight:<br>
<input type="number" name="weight"><br><br>
<p>Type:</p>
<p>Tough<input type="radio" id="tough" name="name" value="tough"
></p>
<p>Rocky:<input type="radio" id="rocky" name="name" value="rocky"
></p>
<p>Gravel:<input type="radio" id="gravel" name="name" value="gravel"
></p>
Color<br>
red: <input type="checkbox" id="red" name="red">
black: <input type="checkbox" id="black" name="black">
yellow: <input type="checkbox" id="yellow" name="yellow">
<input type="submit" value="Save">
</form>
</body></html>