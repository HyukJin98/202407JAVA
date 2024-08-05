<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
            position: relative;
        }
        .form-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            position: absolute;
            z-index: 2;
        }
        .form-container form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container input[type="submit"],
        .form-container input[type="button"] {
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container input[type="submit"],
        .form-container input[type="button"] {
            background-color: #007bff;
            color: white;
            cursor: pointer;
            border: none;
        }
        .form-container input[type="submit"]:hover,
        .form-container input[type="button"]:hover {
            background-color: #0056b3;
        }
        .form-container .login-info {
            margin-bottom: 10px;
        }
        figure {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            margin: 0;
            z-index: 1;
            overflow: hidden;
        }
        figure video {
            object-fit: cover;
            width: 100%;
            height: 100%;
            opacity: 0.3;
            position: absolute;
            top: 0;
            left: 0;
        }
        figure .inner {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100%;
            position: relative;
        }
        figure .inner h1 {
            font: normal 120px/1 "arial";
            color: #fff;
            margin-bottom: 20px;
        }
        figure .inner p {
            font: 16px/1.4 "arial";
            color: #888;
            margin-bottom: 60px;
        }
        figure .inner a {
            display: block;
            width: 400px;
            height: 30px;
            border: 1px solid #bbb;
            font: bold 11px/30px "arial";
            color: #fff;
            text-align: center;
            letter-spacing: 1px;
            transition: all 0.5s;
        }
        figure .inner a:hover {
            background: #fff;
            color: #555;
        }
    </style>
</head>
<body>
<figure>
        <video src="img/visual.mp4" autoplay muted loop></video>
        <div class="inner">
        </div>
    </figure>

<%
    if ((String)session.getAttribute("userId") != null) {          
        // 로그인 상태일 때의 출력 
%>
        <div class="form-container">
            <form action="logout.jsp" method="post">  
                <div class="login-info">
                    <%=(String)session.getAttribute("userName")%>님 로그인
                </div>
                <input type="submit" value="로그아웃">
                <input type="button" value="회원정보 수정" 
                       onclick="window.open('member_update_form.jsp', 'popup', 
                                            'width=400, height=200')">
            </form>
        </div>
<%  
    } else {                       
        // 로그인되지 않은 상태일 때의 출력
%>
        <div class="form-container">
            <form action="login.jsp" method="post"> 
                아이디:   <input type="text"     name="id">&nbsp;&nbsp;
                비밀번호: <input type="password" name="pw">
                <input type="submit" value="로그인">
                <input type="button" value="회원가입" 
                       onclick="window.open('member_join_form.jsp', 'popup', 
                                            'width=400, height=200')">
            </form>
        </div>
<%
    }
%>

</body>
</html>