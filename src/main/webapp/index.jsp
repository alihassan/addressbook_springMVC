<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<%
String site = "dashboard";
response.setStatus(response.SC_MOVED_TEMPORARILY);
response.sendRedirect(site);
%>
<br/>
</body>
</html>