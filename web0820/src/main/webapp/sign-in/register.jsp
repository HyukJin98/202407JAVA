<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <style>
    body, h2, p {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
}

body {
    background-color: #f2f2f2;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.login-container {
    background-color: #ffffff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px;
    text-align: center;
}

h2 {
    margin-bottom: 20px;
    color: #333333;
}

.input-group {
    margin-bottom: 15px;
    text-align: left;
}

.input-group label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

.input-group input {
    width: 100%;
    padding: 8px 10px;
    border-radius: 4px;
    border: 1px solid #cccccc;
    box-sizing: border-box;
    font-size: 16px;
}

.login-btn {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    margin-top: 10px;
}

.login-btn:hover {
    background-color: #45a049;
}

.error-message {
    color: red;
    margin-top: 15px;
}

p {
    margin-top: 15px;
    font-size: 14px;
}

p a {
    color: #4CAF50;
    text-decoration: none;
}

p a:hover {
    text-decoration: underline;
}
    </style>
</head>
<body>
    <h2>회원 등록</h2>
    <form action="registerProcess" method="post">
        <div>
            <label for="id">아이디:</label>
            <input type="text" id="id" name="id" required>
        </div>
        <div>
            <label for="password">패스워드:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <button type="submit">회원가입</button>
    </form>

    <% if (request.getAttribute("errorMessage") != null) { %>
        <p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
    <% } %>

    <p>아이디가 있으신가요? <a href="login">그럼 로그인하세요</a></p>
</body>
</html>
