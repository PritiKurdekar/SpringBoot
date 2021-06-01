<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<a href="/"> GoBack to Home page  </a>

<h1>Product Details </h1>

Id is <c:out value="${product.id}"  />
<br/>
Name is <c:out value="${product.name}"  />
<br/>
Price is <c:out value="${product.salary}"  />
</body>
</html>