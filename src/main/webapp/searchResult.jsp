<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>検索結果</h1>
	<c:if test="${not empty product}">
		<h3>${str}</h3>
		<p>product_id:${product.getProductId()}</p>
		<p>product_Name:${product.getProductName()}</p>
		<p>price:${product.getprice()}</p>
	</c:if>
	<a href="top.jsp">戻る</a>
</body>
</html>