<%@ page import="boards.BoardDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 삭제</title>
</head>
<body>
    <%
    request.setCharacterEncoding("utf-8");
        int boardId = Integer.parseInt(request.getParameter("id"));
        BoardDAO dao = new BoardDAO();
        dao.deleteBoard(boardId); //보드 아이디로 게시글 삭제하기

        response.sendRedirect("board_list.jsp");
    %>
</body>
</html>
