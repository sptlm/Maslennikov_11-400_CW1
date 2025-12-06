<%@ page contentType="text/html; UTF-8" language="java" %>

<html>
<head>
    <title>Main page</title>
</head>
<body>
<h2>You have logged in successfully!</h2>
<%
    String sessionUser = (String) session.getAttribute("user");
    if (sessionUser == null) {
        response.sendRedirect("login.html");
    }

    String cookieUser = "";
    String sessionId = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("user".equalsIgnoreCase(c.getName())) {
                cookieUser = c.getValue();
            } else if ("jsessionid".equalsIgnoreCase(c.getName())) {
                sessionId = c.getValue();
            }
        }
    } else {
        sessionId = session.getId();
    }
%>

<h3>
    Hello, <%=sessionUser%>!
    <br>
    Session ID = <%=sessionId%>
    <br>
    Cookie user = <%=cookieUser%>
</h3>
<form method="get" action="index">
    <input type="submit" value="Main page">
</form>

</body>

</html>