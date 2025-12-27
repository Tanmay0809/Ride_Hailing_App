<html>
<head>
    <title>Request Ride</title>
</head>
<body>
<h2>Request a Ride</h2>

<form action="<%=request.getContextPath()%>/ride" method="post">
    <input type="hidden" name="action" value="REQUEST" />

    Pickup Location: <input type="text" name="pickup" required /><br/><br/>
    Drop Location: <input type="text" name="drop" required /><br/><br/>
    Distance (km): <input type="number" step="0.1" name="distance" required /><br/><br/>

    <button type="submit">Request Ride</button>
</form>

<a href="dashboard.jsp">Back</a>
</body>
</html>
