<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>새 게시글 작성</title>
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
         input[type="text"], textarea {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
            transition: border-color 0.3s, box-shadow 0.3s;
        }
        input[type="text"]:focus, textarea:focus {
            border-color: #007bff;
            box-shadow: 0 0 8px rgba(0, 123, 255, 0.2);
            outline: none;
        }
</style>
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
