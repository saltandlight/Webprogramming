<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>
<script>

</script>
</head>
<body> 
<h1>Product Update Page</h1>
<form id="p_form" action="req?type=product&cmd=updateimpl" method="POST" enctype="multipart/form-data">
 ID:${pp.id }<br>
<input type="hidden" name="id" value="${pp.id }">
NAME<input  value="${pp.name }" type="text" name="name"><br>
PRICE<input value="${pp.price }" type="text" name="price"><br>
IMGNAME<input type="file" value ="newimgname" name="newimgname"><br>
<input value="${pp.imgname }" type="hidden" name="imgname"><br>

<input type="submit" value="UPDATE"><br>
</form>
</body>
</html>