<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>

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
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
</head>
<body>

<figure>
        <video src="img/visual.mp4" autoplay muted loop></video>
        <div class="inner">
        </div>
    </figure>

<%
    request.setCharacterEncoding("utf-8");
    String userId = (String) session.getAttribute("userId");
    MemberDAO dao = new MemberDAO();
    MemberDTO dto = dao.getTwo(userId);
    
    if(dto != null){
%>
<div class="form-container">
        <form action="member_update.jsp" method="post">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="id" readonly
                               value="<%=dto.getId()%>"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="pw" 
                               value="<%=dto.getPw()%>"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" 
                               value="<%=dto.getName()%>"></td>
                </tr>
            </table>    
            <input type="submit" value="저장"> 
        </form>
       </div>
<%
    }
    else{
    	out.println("사용자 정보를 찾을수 없습니다");
    }
%>
        


    
</body>
</html>