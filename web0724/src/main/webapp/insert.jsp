<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
  color : brown;

}

</style>
<meta charset="UTF-8">
<title>dept 테이블 인서트</title>
</head>
<body>
<h1>dept 테이블 인서트</h1>
<form action="/web0724/insert">
부서번호:<input type="text" name="deptno">
부서명:<input type="text" name="dname">
부서지역:<input type="text" name="loc">
<input type="submit">



</form>
</body>
</html>