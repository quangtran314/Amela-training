<%@ page import="java.util.ArrayList" %>
<%@ page import="customer.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Customers</title>
  </head>
  <body>
  <form action="/list" method="post">
    <label>List customers</label> <input type = "submit" id = "submit" value = "list"/>
  </form>
  </body>
</html>
