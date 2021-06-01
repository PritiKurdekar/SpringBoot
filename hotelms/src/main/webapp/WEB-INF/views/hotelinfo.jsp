<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<a href="/"> GoBack to Home page  </a>

<h1>Hotel Details </h1>

Id is <c:out value="${hotel.id}"  />
<br/>
Name is <c:out value="${hotel.hotelName}"  />
<br/>
Address is <c:out value="${hotel.address}"  />
</body>
</html>