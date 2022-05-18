<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>検索条件を入力してください</h1>
	<c:if test="${not empty str}">
		<p>${str}</p>
	</c:if>
	<form action="search" method="post">
		<p>
			product_name: <input type="text" name="name"
				${fn:escapeXml(param.price)}>
		</p>
		<p>
			price: <input type="text" name="price"
				value="${fn:escapeXml(param.price)}">
		</p>
		<button type="submit">検索</button>
	</form>

</body>
</html>