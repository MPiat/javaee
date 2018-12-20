<%@ page import="mpiatek.app.domain.Settings" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="mpiatek.app.web.NewsletterServlet" %>
<%@ page import="mpiatek.app.service.SettingsService" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="settingsService" class="mpiatek.app.service.SettingsService" scope="application" />
<html>
<body>
Saved!
<a href="allnewsletters.jsp">Show all settings.</a>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    String dateFrom = request.getParameter("dateFrom");
    Date  dateFromD = format.parse ( dateFrom);

    String dateTo = request.getParameter("dateTo");
    Date  dateToD = format.parse ( dateTo);


    Settings settings = new Settings(SettingsService.counter+1,request.getParameter("freq"), dateFromD,dateToD);
    if(request.getParameter("wireless")!=null) {settings.setWireless(true);}
    if(request.getParameter("wired")!=null) {settings.setWired(true);}
    if(request.getParameter("isps")!=null) {settings.setIsps(true);}
    request.getSession().setAttribute("sett",settings);
    settingsService.addToSettings(settings);

%>
</body>
</html>