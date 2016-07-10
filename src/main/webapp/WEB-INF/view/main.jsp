<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%request.setCharacterEncoding("utf-8");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>전화번호부(DB사용)</h2>

	<form method="post" action="input.do">
		이름 : <input type="text" name="name" /><br> 
		메일 : <input type="text" name="mail" /><br> 
		번호 : <input type="password"name="number" /><br> 
		<input type="submit" value="번호등록" />
	</form>
	
	<form method="post" action="memberList.do">
		<input type="submit" value="목록확인" />
	</form>

</body>
</html>