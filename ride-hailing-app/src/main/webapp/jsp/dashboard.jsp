<%@ page import="com.training.project.rideapp.model.User" %>
<%
    User user = (User) session.getAttribute("loggedInUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h2>Welcome, <%= user.getFullName() %></h2>
<p>Role: <%= user.getRole() %></p>

<% if ("CUSTOMER".equals(user.getRole())) { %>
    <a href="requestRide.jsp">Request Ride</a><br/>
<% } else { %>
    <a href="driverRides.jsp">View Available Rides</a><br/>
<% } %>

<br/>
<a href="<%=request.getContextPath()%>/logout">Logout</a>
</body>
</html>
