<jsp:useBean id="settingsService" class="mpiatek.app.service.SettingsService" scope="application" />
<html><body>
<form action="saved.jsp" method="post">
Date from:<br>
<input type="date" name="dateFrom"><br>
Date to:<br>
<input type="date" name="dateTo">
<!-- Dla radio name ten sam dla wszystkich. -->
<p>Every Day<input type="radio" id="day" name="freq" value="day"
></p>
<p>Every Month<input type="radio" id="month" name="freq" value="month"
></p>
<p>Every Year<input type="radio" id="year" name="freq" value="year"
></p>
Subject
Wireless: <input type="checkbox" id="wireless" name="wireless">
Wired: <input type="checkbox" id="wired" name="wired">
Isps: <input type="checkbox" id="isps" name="isps">
<input type="submit" value="Save">
</form>
</body></html>