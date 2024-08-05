<%@ page import="java.util.List" %>
<%@ page import="boards.BoardDAO" %>
<%@ page import="boards.BoardDTO" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <div class="inner">
            <h1><a href="#">게시판</a></h1>
            <ul id="gnb">
                <li><a href="index.jsp">홈</a></li>
                <li><a href="board_list.jsp">게시판</a></li>
            </ul>
            <%
                String userName = (String) session.getAttribute("userName");
                if (userName != null) {
            %>
            <ul class="util">
                <li><%= userName %>님 환영합니다</li>
                <li><a href="#">도움말</a></li>
                <li><a href="logout.jsp">로그아웃</a></li>
                <li><a href="member_update_form.jsp">정보수정</a></li>
            </ul>
            <% } else { %>
            <ul class="util">
                <li><a href="login_main.jsp">로그인</a></li>
                <li><a href="member_join_form2.jsp">회원가입</a></li>
            </ul>
            <% } %>
        </div>
    </header>

    <main>
        <div class="inner">
            <h1>게시판 목록</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        BoardDAO dao = new BoardDAO();
                        List<BoardDTO> boardList = dao.getAllBoards();

                        for (BoardDTO board : boardList) {
                    %>
                    <tr>
                        <td><%= board.getId() %></td>
                        <td><a href="board_view.jsp?id=<%= board.getId() %>"><%= board.getTitle() %></a></td>
                        <td><%= board.getAuthor() %></td>
                        <td><%= board.getCreatedAt() %></td>
                        <td>
                            <% if (userName != null) { %>
                            <a href="board_edit.jsp?id=<%= board.getId() %>">수정</a> |
                            <a href="board_delete_action.jsp?id=<%= board.getId() %>" onclick="return confirm('삭제하시겠습니까?');">삭제</a>
                            <% } %>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% if (userName != null) { %>
            <a href="board_create.jsp">새 게시글 작성</a>
            <% } %>
        </div>
    </main>
</body>
</html>>