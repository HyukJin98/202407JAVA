<%@page import="comment.CommentDTO"%>
<%@page import="comment.CommentDAO"%>
<%@ page import="boards.BoardDAO" %>
<%@ page import="boards.BoardDTO" %>
<%@ page import="comment.CommentDAO" %>
<%@ page import="comment.CommentDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 상세</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <div class="inner">
            <h1><a href="#">게시글 상세</a></h1>
            <ul id="gnb">
                <li><a href="index.jsp">홈</a></li>
                <li><a href="board_list.jsp">게시판</a></li>
            </ul>
        </div>
    </header>

    <main>
        <div class="inner">
            <% 
                int boardId = Integer.parseInt(request.getParameter("id"));
                BoardDAO boardDAO = new BoardDAO();
                BoardDTO board = boardDAO.getBoardById(boardId);

                if (board != null) {
            %>
            <h1><%= board.getTitle() %></h1>
            <p>작성자: <%= board.getAuthor() %></p>
            <p>작성일: <%= board.getCreatedAt() %></p>
            <div>
                <p><%= board.getContent() %></p>
            </div>
            <% 
                String userName = (String) session.getAttribute("userName");
                if (userName != null && board.getAuthor().equals(userName)) { 
            %>
            <a href="board_edit.jsp?id=<%= board.getId() %>">수정</a> |
            <a href="board_delete_action.jsp?id=<%= board.getId() %>" onclick="return confirm('삭제하시겠습니까?');">삭제</a>
            <% } %>
            <hr>
            <h2>댓글</h2>
            <form action="comment_add_action.jsp" method="post">
                <input type="hidden" name="boardId" value="<%= boardId %>">
                <textarea name="content" rows="4" cols="50" placeholder="댓글을 입력하세요..."></textarea>
                <button type="submit">댓글 추가</button>
            </form>
            <ul>
                <% 
                    CommentDAO commentDAO = new CommentDAO();
                    List<CommentDTO> comments = commentDAO.getCommentsByBoardId(boardId);

                    for (CommentDTO comment : comments) {
                %>
                <li>
                    <strong><%= comment.getAuthor() %>:</strong>
                    <p><%= comment.getContent() %></p>
                    <p><small><%= comment.getCreatedAt() %></small></p>
                </li>
                <% 
                    } 
                %>
            </ul>
            <% 
                } else {
            %>
            <p>해당 게시글을 찾을 수 없습니다.</p>
            <% 
                } 
            %>
        </div>
    </main>
</body>
</html>