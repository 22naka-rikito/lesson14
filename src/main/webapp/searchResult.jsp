<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>検索結果</h1>
	<c:if test="${not empty list}">
		<table>
			<tr>
				<th>product_id</th>
				<th>product_Name</th>
				<th>price</th>
			</tr>
			<c:forEach var="product" items="${list}">
				<tr>
					<td>${product.getProductId()}</td>
					<td>${product.getProductName()}</td>
					<td>${product.getPrice()}</td>
				</tr>

			</c:forEach>
		</table>
<%-- 		${test} --%>
	</c:if>
	<a href="top.jsp">戻る</a>
</body>
</html>