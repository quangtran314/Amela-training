<%@ page import="java.util.ArrayList" %>
<%@ page import="customer.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Year of birth</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${list}" var="customer">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getBirth()}</td>
            <td>${customer.getAddress()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
