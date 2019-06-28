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
$(document).ready(function(){
	$('input[type="button"]').click(function(){
		var c = confirm('회원가입하시겠습니까?');
		if(c==true){
			$('#r_form').attr('method','POST');
			$('#r_form').attr('action','req?type=user&cmd=addimpl');
			$('#r_form').submit();
		}
	});
});

</script>
</head>
<body>
<h1>Product Add Page</h1>
<form id="r_form" action="req?type=product&cmd=addimpl" method="POST" enctype="multipart/form-data">
ID<input readonly type="text" name="id"><br>
NAME<input type="text" name="name"><br>
PRICE<input type="text" name="price"><br>
IMGNAME<input type="file" name="imgname"><br>

<input type="submit" value="REGISTER">
</form>
</body>
</html>