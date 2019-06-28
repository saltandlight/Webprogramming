<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<style>
img {
	float: left
}

div {
	margin-left: 40px; display : inline;
	float: left;
	display: inline;
}

/* h5{
 display:inline;
} */
</style>
<script>
	$(document).ready(function() {
		$('button:eq(0)').click(function() {
			var c = confirm('삭제 하시겠습니까?');
			if (c == true) {
				location.href = 'req?type=product&cmd=delete&id=${pd.id}';

			}
		});
		$('button:eq(1)').click(function() {
			var c = confirm('변경 하시겠습니까?');
			if (c == true) {
				/* location.href='user/update.jsp';   */
				location.href = 'req?type=product&cmd=update&id=${pd.id}';

			}
		});
	});
</script>
<body>
	<button>DELETE</button>
	<button>UPDATE</button>
	<h1>Product Detail Page</h1>
	<img src="img/${pd.imgname }" width="300px" height="300px">
	<div>
		<h5>id: ${pd.id }</h5>
		<h5>name: ${pd.name }</h5>
		<h5>price: ${pd.price }</h5>
		<h5>date: ${pd.regdate }</h5>
		<h5>img: ${pd.imgname }</h5>
	</div>
</body>
</html>