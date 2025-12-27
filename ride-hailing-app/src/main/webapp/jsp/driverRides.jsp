<html>
<head>
    <title>Driver Actions</title>
</head>
<body>
<h2>Driver Ride Actions</h2>

<form action="<%=request.getContextPath()%>/ride" method="post">
    <input type="hidden" name="action" value="ACCEPT" />
    <button type="submit">Accept Ride</button>
</form>

<form action="<%=request.getContextPath()%>/ride" method="post">
    <input type="hidden" name="action" value="COMPLETE" />
    <button type="submit">Complete Ride</button>
</form>

<a href="dashboard.jsp">Back</a>
</body>
</html>
