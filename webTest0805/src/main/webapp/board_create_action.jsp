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

        BoardDTO board = new BoardDTO();
        board.setTitle(title);
        board.setContent(content);
        board.setAuthor(author);

        BoardDAO dao = new BoardDAO();
        dao.addBoard(board);

        response.sendRedirect("board_list.jsp");
    %>
</body>
</html>
