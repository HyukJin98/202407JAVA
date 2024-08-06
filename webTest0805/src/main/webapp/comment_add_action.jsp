<%@ page import="comment.CommentDAO" %>
<%@ page import="comment.CommentDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>댓글 추가</title>
</head>
<body>
    <%
    request.setCharacterEncoding("utf-8");
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        String content = request.getParameter("content");
        String author = (String) session.getAttribute("userName");

        CommentDTO dto = new CommentDTO();
        dto.setBoardId(boardId);
        dto.setContent(content);
        dto.setAuthor(author);

        CommentDAO dao = new CommentDAO();
        dao.insertComment(dto);

        response.sendRedirect("board_view.jsp?id=" + boardId);  
    %>
</body>
</html>
