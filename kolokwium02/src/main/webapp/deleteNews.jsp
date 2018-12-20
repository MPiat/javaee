<%@ page import="mpiatek.app.domain.Settings" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="settingsService" class="mpiatek.app.service.SettingsService" scope="application" />
<jsp:useBean id="sett" class="mpiatek.app.domain.Settings" scope="session" />

<html>
<body>
My settings:
<%
    settingsService.deleteSetting(Integer.valueOf(request.getParameter("id"))-1);
    out.print("<p>" + "Deleted" + "</p>");
%>
</body>
</html>