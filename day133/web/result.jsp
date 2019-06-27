<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tbody>
			<c:forEach var="c" items="${chs }">
				<tr>
				<%-- <td>${c.}</td> --%>
				<%-- <td>${it.price }</td> --%>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>
