<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<body>

<a href="/"> GoBack to Home page  </a>


<h1> Get Hotel Information</h1>

<form  method="get" action="/fetchinfo" >

<div>
<label> Hotel Id</label>

 <input name="hotelid" type="number"  />

</div>


<input type="submit" value="Get Info"  />


</form>



</body>
</html>