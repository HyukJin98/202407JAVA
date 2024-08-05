<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>새 게시글 작성</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <div class="inner">
            <h1><a href="#">새 게시글 작성</a></h1>
            <ul id="gnb">
                <li><a href="index.jsp">홈</a></li>
                <li><a href="board_list.jsp">게시판</a></li>
            </ul>
        </div>
    </header>

    <main>
        <div class="inner">
            <h1>새 게시글 작성</h1>
            <form action="board_create_action.jsp" method="post">
                <div>
                    <label for="title">제목:</label>
                    <input type="text" id="title" name="title" required>
                </div>
                <div>
                    <label for="content">내용:</label>
                    <textarea id="content" name="content" rows="10" required></textarea>
                </div>
                <div>
                    <label for="author">작성자:</label>
                    <input type="text" id="author" name="author" required>
                </div>
                <button type="submit">게시글 등록</button>
            </form>
        </div>
    </main>
</body>
</html>
