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
    <style>
  * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            color: #333;
            background-color: #f4f4f4;
        }
        a {
            text-decoration: none;
            color: #007bff;
            transition: color 0.3s, background-color 0.3s;
        }
        a:hover {
            color: #0056b3;
            text-decoration: underline;
        }

        /* header */
        header {
            background-color: #333;
            color: #fff;
            border-bottom: 1px solid #ddd;
            padding: 15px 0;
        }
        header .inner {
            width: 80%;
            max-width: 1200px;
            margin: 0 auto;
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: relative;
        }
        header .inner h1 {
            margin: 0;
        }
        header .inner h1 a {
            font-size: 24px;
            font-weight: bold;
            color: #fff;
        }
        header .inner .util {
            display: flex;
            gap: 15px;
        }
        header .inner .util a {
            font-size: 14px;
            color: #fff;
            padding: 5px 10px;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        header .inner .util a:hover {
            background-color: #444;
        }
        header .inner #gnb {
            display: flex;
            gap: 15px;
        }
        header .inner #gnb a {
            font-size: 15px;
            font-weight: bold;
            color: #fff;
            padding: 10px 20px;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        header .inner #gnb a:hover {
            background-color: #555;
        }

        /* main */
        main {
            padding: 20px 0;
        }
        main .inner {
            width: 80%;
            max-width: 1200px;
            margin: 0 auto;
        }
        main h1 {
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f4f4f4;
            font-weight: bold;
        }
        td a {
            color: #007bff;
            transition: color 0.3s;
        }
        td a:hover {
            color: #0056b3;
        }
        .actions a {
            color: #007bff;
            margin-right: 10px;
            text-decoration: none;
            font-size: 14px;
            transition: color 0.3s;
        }
        .actions a:hover {
            color: #0056b3;
        }
        .actions a:last-child {
            margin-right: 0;
        }
        .create-post {
            margin-top: 20px;
            text-align: right;
        }
        .create-post a {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border-radius: 4px;
            font-weight: bold;
            transition: background-color 0.3s;
        }
        .create-post a:hover {
            background-color: #0056b3;
        }
    </style>
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