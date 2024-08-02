<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email = request.getParameter("email");
    String rememberMe = request.getParameter("rememberMe"); 
    if ("on".equals(rememberMe)) {
        Cookie emailCookie = new Cookie("userEmail", email);
        emailCookie.setMaxAge(60 * 60 * 24 * 30); // 쿠키 유효 기간: 30일 (초 단위)
        response.addCookie(emailCookie);
        out.println("<p>이메일이 쿠키에 저장되었습니다.</p>");
    } else {
        out.println("<p>이메일이 쿠키에 저장되지 않았습니다.</p>");
    }
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