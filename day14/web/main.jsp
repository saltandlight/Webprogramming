<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
	color: black;
}

header, nav, section, footer {
	margin: 0 auto;
}

header {
	width: 900px;
	height: 150px;
	background: pink;
}

nav {
	width: 900px;
	height: 30px;
	background: orange;
}

section {
	width: 900px;
	height: 600px;
	background: gray;
}

footer {
	width: 900px;
	height: 50px;
	background: lightblue;
}

.center_page {
	margin: 0 auto;
	width: 880px;
	height: 580px;
	background: white;
}
</style>
</head>
<body>
	<header>
		<h3>
			<c:choose>
				<c:when test="${loginuser != null }">
					<a href="">${loginuser.id }</a>
					<!-- GET방식으로 날아감(아무것도 안 해주고 이렇게 요청하면~) -->
					<a href="login.do">LOGOUT</a>
					<a href="main.do?view=aboutus">ABOUT US</a>
				</c:when>

				<c:otherwise>
					<a href="main.do?view=login">LOGIN</a>
					<a href="main.do?view=register">REGISTER</a>
					<a href="main.do?view=aboutus">ABOUT US</a>
				</c:otherwise>
			</c:choose>
		</h3>
		<h1>
			<!-- 	user에 관한 작업은 userservlet에서 해라 -->
			<a href="user.do?view=useradd">USERADD</a> <a
				href="user.do?cmd=userlist">USERLIST</a> <a
				href="product.do?view=productadd">PRODUCTADD</a> <a
				href="product.do?view=productlist">PRODUCTLIST</a>
		</h1>
	</header>
	<nav>
		<c:choose>
			<c:when test="${navi == null}">
				<a href="main.do">HOME</a>
			</c:when>
			<c:otherwise>
		${navi }
	</c:otherwise>
		</c:choose>

	</nav>
	<section>
		<c:choose>
			<c:when test="${center == null }">
				<jsp:include page="center.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="${center }.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>

	</section>
	<footer></footer>
</body>
</html>



