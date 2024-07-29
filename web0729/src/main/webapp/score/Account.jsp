<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
//데이터베이스 접속
String sql = "";
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
//임시 저장 변수들
String id2 = "";
String name2 = "";
String ssn2 = "";
String tel2 = "";
String balance2 = "";
String sqlTmp = "";
// 매개변수들
request.setCharacterEncoding("UTF-8");      //한글 안깨지도록 처리
String find =request.getParameter("find");  //update하기 전 학번을 클릭하면 넘어오는 매개변수
String id = request.getParameter("id");   //null이면 오류
String name = request.getParameter("name"); 
String ssn = request.getParameter("ssn");
String tel = request.getParameter("tel");
String balance = request.getParameter("balance");
String delete = request.getParameter("delete");

if(delete != null){
	sqlTmp = "delete from account where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, delete);
	int ret = pstmt.executeUpdate();
}
//업데이트 하기전에 학번을 클릭하면
if (find != null) {
	sqlTmp = "select * from account where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, find);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		id2 = rs.getString("id");
		name2 = rs.getString("name");
		ssn2 = rs.getString("ssn");
		tel2 = rs.getString("tel");
		balance2 = rs.getString("balance");
	}
}
// 학번이 null이 아니면 이미 입력된 학번인지 조회
if (id != null) {
	out.println("id는 null이 아닙니다.");
	sqlTmp = "select count(*) from account where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int cnt = rs.getInt(1);  // 0: insert, 1: update
	if (!name.equals("") && !ssn.equals("") && !tel.equals("") && !balance.equals("")) {
		if (cnt == 1) { // 정보 수정
			sqlTmp = "update account set name = ?, ssn = ?, tel = ?, balance = ? where id = ?";
			pstmt = conn.prepareStatement(sqlTmp);
			pstmt.setString(1, name);
			pstmt.setString(2, ssn);
			pstmt.setString(3, tel);
			pstmt.setString(4, balance);
			pstmt.setString(5, id);
			int ret = pstmt.executeUpdate();
		} else { //정보 입력
			sqlTmp = "insert into account(name, ssn, tel, balance) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sqlTmp);
			pstmt.setString(1, name);
			pstmt.setString(2, ssn);
			pstmt.setString(3, tel);
			pstmt.setString(4, balance);
			int ret = pstmt.executeUpdate();
		}
	} else {
		out.println("입력 또는 수정을 할 수 없습니다.");
	}
	
} else {
	out.println("id는 null입니다.");
}

	



%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
       .table-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* Viewport Height: 화면의 전체 높이 */
        position: relative;
    }

    /* 테이블을 감싸는 div의 높이를 제한하고 스크롤을 추가합니다. */
    .table-wrapper {
        width: 100%; /* 원하는 너비 설정 */
        max-width: 800px; /* 테이블 최대 너비 설정 */
        height: 400px; /* 고정된 높이 설정 */
        overflow-y: auto; /* 세로 스크롤 추가 */
        border: 1px solid #ddd; /* 테두리 설정 */
        border-radius: 8px; /* 모서리 둥글게 */
        transform: translateY(-50%)
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left; /* 좌측 정렬 */
    }

    th {
        background-color: yellow;
    }
        form {
               
            display: grid;
            grid-template-columns: 1fr 2fr; /* 두 열을 설정 */
            gap: 10px; /* 열과 행 간의 간격 */
            max-width: 600px; /* 최대 너비 설정 */
            margin: 0 auto;   /* 중앙 정렬 */
            padding: 20px;
            background-color: lime;
            border: 1px solid #ddd;
            border-radius: 8px;
        }
        label {
            justify-self: end; /* 라벨을 오른쪽으로 정렬 */
            font-weight: bold;
            margin-right: 10px;
        }
        input[type="text"] {
            width: 100%; /* 너비를 100%로 설정 */
            padding: 10px; /* 여백 설정 */
            border: 1px solid #ccc; /* 테두리 설정 */
            border-radius: 4px; /* 모서리 둥글게 */
            box-sizing: border-box; /* padding과 border를 포함한 너비 계산 */
            background-color: aqua;
        }
        input[type="text"]:focus {
            border-color: #4CAF50; /* 포커스 시 테두리 색상 변경 */
            outline: none; /* 기본 포커스 아웃라인 제거 */
        }
        input[type="submit"] {
            background-color: aqua;
            color: black;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }
        
        
        
    
        
        
</style>
</head>
<body>
<form>
id: <input type = "text" name="id" value="<%=id2%>"><br>
이름: <input type = "text" name="name" value="<%=name2%>"><br>
주민번호 앞 6자리: <input type = "text" name="ssn" value="<%=ssn2%>"><br>
전화번호: <input type = "text" name="tel" value="<%=tel2%>"><br>
잔고: <input type = "text" name="balance" value="<%=balance2%>"><br>
<input type = "submit" value = "입력or수정" >
</form>
<div class = "table-container">
<div class = "table-wrapper">
<table>
        <th>id</th>
        <th>이름</th>
        <th>주민번호 앞 6자리</th>
        <th>전화번호</th>
        <th>잔고</th>
        <th>삭제</th>
<%
sqlTmp = "select * from account";
pstmt = conn.prepareStatement(sqlTmp);
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
	id2 = rs.getString("id");
	name2 = rs.getString("name");
	ssn2 = rs.getString("ssn");
	tel2 = rs.getString("tel");
	balance2 = rs.getString("balance");
	
	

	
%>
    <tr>
    <td><a href="?find=<%=id2 %>"><%=id2 %></td>
    <td><%=name2 %></td>
    <td><%=ssn2 %></td>
    <td><%=tel2 %></td>
    <td><%=balance2 %></td>
    <td><button type="button" onclick="location.href='?delete=<%=id2%>' ">삭제</button></td>
    </tr>
<%
}
%>
</table>
</div>
</div>


</body>
</html>