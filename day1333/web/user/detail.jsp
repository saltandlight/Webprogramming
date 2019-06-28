<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	$('button:eq(0)').click(function(){
		var c = confirm('삭제 하시겠습니까?');
		if(c==true){
			location.href='req?type=user&cmd=delete&id=${ud.id}';
			
		}
	});
	$('button:eq(1)').click(function(){
		var c = confirm('변경 하시겠습니까?');
		if(c==true){
	     	/* location.href='user/update.jsp';   */
			location.href='req?type=user&cmd=update&id=${ud.id}';  
			
		}
	});
});
</script>
<body>
<button>DELETE</button>
<button>UPDATE</button>
<h1>User Detail Page</h1>
<img src="img/${ud.id }.jpg">
<h5>${ud.id }</h5>
<h5>${ud.pwd }</h5>
<h5>${ud.name }</h5>
</body>
</html>