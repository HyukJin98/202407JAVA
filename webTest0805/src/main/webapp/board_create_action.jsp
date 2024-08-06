<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boards.BoardDAO" %>
<%@ page import="boards.BoardDTO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 등록 완료</title>
</head>
<body>
    <%
    request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = request.getParameter("author");

        BoardDTO dto = new BoardDTO();
        dto.setTitle(title);
        dto.setContent(content);
        dto.setAuthor(author);

        BoardDAO dao = new BoardDAO();
        dao.insertBoard(dto); 

        response.sendRedirect("board_list.jsp");
    %>
</body>
</html>
