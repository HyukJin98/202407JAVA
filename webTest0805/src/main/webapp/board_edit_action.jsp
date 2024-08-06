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

        BoardDTO dto = new BoardDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setContent(content);

        BoardDAO dao = new BoardDAO();
        dao.updateBoard(dto);

        response.sendRedirect("board_view.jsp?id=" + id); //업데이트 하면서 board_view에 id 매개변수 전달
    %>
</body>
</html>
