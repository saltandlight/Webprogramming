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
<h1>User Add Page</h1>
<form id="r_form">
ID<input type="text" name="id"><br>
PWD<input type="text" name="pwd"><br>
NAME<input type="text" name="name"><br>
<input type="button" value="REGISTER"><br>
</form>
</body>
</html>