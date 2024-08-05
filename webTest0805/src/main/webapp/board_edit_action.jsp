<%@ page import="boards.BoardDAO" %>
<%@ page import="boards.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 수정 완료</title>
</head>
<body>
    <%
    request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardDTO board = new BoardDTO();
        board.setId(id);
        board.setTitle(title);
        board.setContent(content);

        BoardDAO dao = new BoardDAO();
        dao.updateBoard(board);

        response.sendRedirect("board_view.jsp?id=" + id);
    %>
</body>
</html>
