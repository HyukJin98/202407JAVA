<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    session.removeAttribute("userId"  );
    session.removeAttribute("userName");

    response.sendRedirect("index.jsp"); // 홈페이지로 이동
%> 