<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>갤러리</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
          a {
        text-decoration: none;
        color: #fff;
        background-color: white;
        padding: 0.5rem 1rem;
        border-radius: 5px;
        font-size: 1.2rem;
        transition: background-color 0.3s, box-shadow 0.3s;
    }

    a:hover {
        background-color: #c2185b;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    a:active {
        background-color: #9c0b46;
    }
        .container {
            width: 80%;
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            text-align: center;
            font-size: 2em;
            color: #333;
            margin-bottom: 20px;
        }
        .gallery {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            gap: 15px;
        }
        .gallery img {
            width: 100%;
            height: auto;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .gallery img:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
<%
    String userName = (String) session.getAttribute("userName");
    if (userName == null) {
%>
       <script>
       alert('로그인 필요!');
       window.location.href = 'login_main.jsp';
       </script>    
       <%
    }else{
       %>
<div class="container">
    <h1>갤러리</h1>
    <a href="index.jsp">홈</a>
    <div class="gallery">
    
        <img src="img/sponge.jfif" alt="patrick">
        <img src="img/patrick.jfif" alt="patrick">
        <img src="img/patrickHip.jfif" alt="patrick">
        <img src="img/maxresdefault.jpg" alt="patrick">
        <img src="img/s2q33j23pj02068k8j7v.jpg" alt="patrick">
    </div>
</div>
<%} %>
</body>
</html>
