<%@ page import="mpiatek.app.domain.Settings" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="settingsService" class="mpiatek.app.service.SettingsService" scope="application" />
<!-- Pobieranie danych z sesji. -->
<jsp:useBean id="sett" class="mpiatek.app.domain.Settings" scope="session" />

<html>
<body>
My Settings:
<%
        out.print("<p>" + sett + "</p>");
%>
All Settings:
<%

    for(Settings settings : settingsService.getSettings()) {
        %>
<form action="deleteNews.jsp" method="post">
    <% int idNum = settings.getId();            
    out.print("<input type='hidden' name='id' value='"+ idNum + "'><br>");    %>
        <input type="submit" value="Usun z settings"></form>
        <%

        out.print("<p>" + settings + "</p>");
    }
%>
</body>
</html>