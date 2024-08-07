<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상점 페이지</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #333;
        color: #fff;
        padding: 1rem;
        text-align: center;
        font-size: 2rem;
    }

    nav {
        background-color: #444;
        overflow: hidden;
    }

    nav a {
        float: left;
        display: block;
        color: #fff;
        text-align: center;
        padding: 1rem 2rem;
        text-decoration: none;
    }

    nav a:hover {
        background-color: #555;
    }

    .container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        margin: 2rem;
    }

    .product {
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 5px;
        margin: 1rem;
        width: 250px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s;
    }

    .product:hover {
        transform: scale(1.05);
    }

    .product img {
        width: 100%;
        border-bottom: 1px solid #ddd;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
    }

    .product-info {
        padding: 1rem;
        text-align: center;
    }

    .product-info h2 {
        font-size: 1.5rem;
        margin: 0.5rem 0;
    }

    .product-info p {
        color: #555;
        font-size: 1rem;
    }

    .product-info .price {
        font-size: 1.2rem;
        color: #e91e63;
        margin: 0.5rem 0;
    }

    .product-info button {
        background-color: #e91e63;
        color: #fff;
        border: none;
        padding: 0.5rem 1rem;
        cursor: pointer;
        border-radius: 3px;
        transition: background-color 0.3s;
    }

    .product-info button:hover {
        background-color: #c2185b;
    }

    footer {
        background-color: #333;
        color: #fff;
        text-align: center;
        padding: 1rem;
        position: fixed;
        bottom: 0;
        width: 100%;
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
    <header>
        뚱이 스토어
    </header>
    <nav>
        <a href="index.jsp">홈</a>
    </nav>
    <div class="container">
        <div class="product">
            <img src="img/뚱베.jfif" alt="Product 1">
            <div class="product-info">
                <h2>뚱이 베개</h2>
                <p>레전드 뚱이 베개</p>
                <div class="price">₩50,000</div>
                <button>구매하기</button>
            </div>
        </div>
        <div class="product">
            <img src="img/뚱별.jfif" alt="Product 2">
            <div class="product-info">
                <h2>뚱이 인형</h2>
                <p>귀요미 뚱이 인형</p>
                <div class="price">₩130,000</div>
                <button>구매하기</button>
            </div>
        </div>
    </div>
    <footer>
        © 2024 상점 이름. 모든 권리 보유.
    </footer>
    <%} %>
</body>
</html>