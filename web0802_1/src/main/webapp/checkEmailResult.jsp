<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = request.getParameter("email");
String rememberMe = request.getParameter("rememberMe");
// System.out.println(rememberMe); //on 또는 null 생성
if("on".equals(rememberMe)){
	response.addCookie(
			Cookies.createCookie("email",email,"/",-1) // 쿠키 생성
			);
}else{
	response.addCookie(
			Cookies.createCookie("email","","/",0) // 삭제
			);
}
response.sendRedirect("checkEmail.jsp");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>