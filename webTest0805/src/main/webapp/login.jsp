<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   

<%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    
    MemberDAO dao = new MemberDAO();
    MemberDTO dto = dao.getOne(id,pw);
    try{
    if(dto.getId().equals(id)&&dto.getPw().equals(pw)){
    session.setAttribute("userId",   dto.getId());
    session.setAttribute("userName", dto.getName());
    response.sendRedirect("index.jsp"); 
    return;
    }
    } catch(Exception e) {
        e.printStackTrace();
    }
    
    
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>


 
</body>
</html>