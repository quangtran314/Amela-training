<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/11/2021
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Discount calculator</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form action="/discount" method="post">
  <label>Product Description: </label> <input type="text" name="desciption"/><br/>
  <label>List Price: </label> <input type="text" name="list_price"/><br/>
  <label>Discount Percent: </label> <input type="text" name="discount_percent"/><br/>
  <input type = "submit" id = "submit" value = "discount"/>
</form>
</body>
</html>
