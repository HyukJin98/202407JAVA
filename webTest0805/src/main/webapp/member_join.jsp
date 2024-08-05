<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
MemberDAO dao = new MemberDAO();
MemberDTO dto = new MemberDTO(id, pw, name);
MemberDTO dto2 = null;
try {
    dto2 = dao.getTwo(id);
    if (dto2 != null && dto2.getId().equals(id)) {
        // 이미 있는 아이디이면 오류 표시
%>
        <script>
            alert('이미 등록된 아이디입니다.');
            history.back();
        </script>
<%          
    } else {           
        // 새로운 회원정보를 DB에 추가하는 쿼리
        dao.insertMember(dto);
%>
        <script>
            alert('가입이 완료되었습니다.');
            window.close();
        </script>
<%          

    }
} catch (Exception e) {
    e.printStackTrace();
%>
    <script>
        alert('오류가 발생했습니다: <%= e.getMessage() %>');
        history.back();
    </script>
<%
}
%>

</body>
</html>