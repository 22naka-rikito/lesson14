<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>検索条件を入力してください</h1>
	<c:if test="${not empty str}">
      <h3>アプリの実行結果</h3>
      <p>${str}</p>
  	</c:if>
	<form action="search" method="post">
		<p>
			product_id: <input type="text" name="id">
		</p>
		<button type="submit">検索</button>
	</form>

</body>
</html>