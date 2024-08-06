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