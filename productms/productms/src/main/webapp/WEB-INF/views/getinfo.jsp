<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<body>

<a href="/"> GoBack to Home page  </a>


<h1> Get Product Information</h1>

<form  method="get" action="/fetchinfo" >

<div>
<label> Product Id</label>

 <input name="productid" type="number"  />

</div>


<input type="submit" value="Get Info"  />


</form>



</body>
</html>