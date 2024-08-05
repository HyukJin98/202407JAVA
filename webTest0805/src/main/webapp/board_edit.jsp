<%@ page import="boards.BoardDAO" %>
<%@ page import="boards.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 수정</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <div class="inner">
            <h1><a href="#">게시글 수정</a></h1>
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
                BoardDAO dao = new BoardDAO();
                BoardDTO board = dao.getBoardById(boardId);

                if (board != null) {
            %>
            <h1>게시글 수정</h1>
            <form action="board_edit_action.jsp" method="post">
                <input type="hidden" name="id" value="<%= board.getId() %>">
                <div>
                    <label for="title">제목:</label>
                    <input type="text" id="title" name="title" value="<%= board.getTitle() %>" required>
                </div>
                <div>
                    <label for="content">내용:</label>
                    <textarea id="content" name="content" rows="10" required><%= board.getContent() %></textarea>
                </div>
                <button type="submit">게시글 수정</button>
            </form>
            <% } else { %>
            <p>게시글을 찾을 수 없습니다.</p>
            <% } %>
        </div>
    </main>
</body>
</html>
