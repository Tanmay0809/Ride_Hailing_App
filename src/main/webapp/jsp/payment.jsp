<html>
<head>
    <title>Payment</title>
</head>
<body>
<h2>Payment</h2>

<form action="<%=request.getContextPath()%>/payment" method="post">
    Payment Method:
    <select name="method">
        <option value="CASH">Cash</option>
        <option value="CARD">Card</option>
        <option value="UPI">UPI</option>
    </select><br/><br/>

    <button type="submit">Pay</button>
</form>
</body>
</html>
