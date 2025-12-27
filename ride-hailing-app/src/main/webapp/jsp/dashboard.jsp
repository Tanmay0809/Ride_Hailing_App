<%@ page import="com.training.project.rideapp.model.User" %>
<%@ page import="com.training.project.rideapp.model.Customer" %>
<%@ page import="com.training.project.rideapp.model.Driver" %>

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

<% if (user instanceof Customer) { %>
    <p>Role: CUSTOMER</p>
    <a href="requestRide.jsp">Request Ride</a><br/>
<% } else if (user instanceof Driver) { %>
    <p>Role: DRIVER</p>
    <a href="driverRides.jsp">View Available Rides</a><br/>
<% } %>

<br/>
<a href="<%=request.getContextPath()%>/logout">Logout</a>

</body>
</html>
