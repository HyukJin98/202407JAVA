<%@page import="java.util.List"%>
<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
MemberDAO dao = new MemberDAO();
MemberDTO dto = new MemberDTO(id,pw,name);
dao.getOne(id,pw);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기업형 웹 페이지</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
<style>
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
}
ul,
ol {
	list-style: none;
}
a {
	text-decoration: none;
}

/* header */
header {
	width: 100%;
	border-bottom: 1px solid #ddd;
}
header .inner {
	width: 1180px;
	height: 120px;
	margin: 0px auto;
	position: relative; /*자식 absolute 요소의 기준점 설정*/
}
header .inner h1 {
	position: absolute;
	left: 0px;
	bottom: 15px;
}
header .inner h1 a {
	font: bold 24px/1 "arial";
	color: #444;
}
header .inner .util {
	position: absolute;
	top: 20px;
	right: 30px;
}
header .inner .util li {
	float: left;
}
header .inner .util li a {
	display: block;
	font: 12px/1 "arial";
	color: #999;
	padding: 0px 10px;
}
header .inner #gnb {
	position: absolute;
	bottom: 0px;
	right: 0px;
}
header .inner #gnb li {
	float: left;
}
header .inner #gnb li a {
	display: block; /*인라인 요소는 block설정하여 크기를 조절가능*/
	font: bold 15px/1 "arial";
	color: #555;
	padding: 20px 40px;
	transition: all 0.5s;
}
header .inner #gnb li a:hover {
	background: #555;
	color: #fff;
}
figure {
	width: 100%;
	height: calc(100vh - 120px); /*전체 브라우저 높이에서 120px만큼 빼줌*/
	background: #000;
	position: relative;
	overflow: hidden;
	padding-top: 250px;
}
figure video {
	object-fit: cover; /*영상을 figure안쪽에 꽉 차도록 설정*/
	width: 100%;
	height: 100%;
	opacity: 0.3;
	position: absolute;
	top: 0px;
	left: 0px;
}
figure .inner {
	width: 1180px;
	margin: 0px auto;
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
/* news */
section {
	width: 100%;
	padding: 200px 0px;
}
section .inner {
	width: 1180px;
	margin: 0px auto;
}
section .inner h1 {
	font: bold 24px/1 "arial";
	color: #555;
	text-align: center;
	margin-bottom: 50px;
}
section .inner .wrap {
	width: 100%;
}
section .inner .wrap::after {
	/*자식 요소인 article의 float해제*/
	content: "";
	display: block;
	clear: both;
}
section .inner .wrap article {
	width: 280px;
	float: left;
	margin-right: 20px;
}
section .inner .wrap article:last-child {
	/*제일 오른쪽 마지막 요소만 여백제거*/
	margin-right: 0px;
}
section .inner .wrap article h2 {
	margin-bottom: 10px;
}
section .inner .wrap article h2 a {
	font: bold 16px/1 "arial";
	color: #555;
}
section .inner .wrap article p {
	font: 14px/1.4 "arial";
	color: #777;
}
section .inner .wrap article .pic {
	width: 100%;
	height: 120px;
	background: #333;
	margin-bottom: 15px;
	position: relative;
	overflow: hidden;
}
section .inner .wrap article .pic img {
	object-fit: cover; /*pic프레임안에 이미지 꽉 채움*/
	width: 100%;
	height: 100%;
}
/* footer */
footer {
	width: 100%;
	background: #333;
	padding: 100px 0px;
	border-top: 1px solid #888;
}
footer .inner {
	width: 1180px;
	margin: 0px auto;
}
footer .inner .upper {
	width: 100%;
	border-bottom: 1px solid #777;
	padding-bottom: 20px;
}
footer .inner .upper::after {
	/*상단 영역 float해제*/
	content: "";
	display: block;
	clear: both;
}
footer .inner .upper h1 {
	float: left;
	font: bold 24px/1 "arial";
	color: #666;
}
footer .inner .upper ul {
	float: right;
}
footer .inner .upper ul li {
	float: left;
	margin-left: 20px;
}
footer .inner .upper ul li a {
	font: bold 14px/1 "arial";
	color: #666;
}
footer .inner .lower {
	width: 100%;
	padding-top: 20px;
}
footer .inner .lower address {
	width: 100%;
	font: 12px/1.3 "arial";
	color: #777;
	margin-bottom: 20px;
}
footer .inner .lower p {
	width: 100%;
	font: 12px/1 "arial";
	color: #777;
}
</style>
</head>

<body>

    <header>
        <div class="inner">
            <h1><a href="#">Patrick Store</a></h1>
            <ul id="gnb">
                <li><a href="index.jsp">home</a></li>
                <li><a href="shop.jsp">shop</a>
                <li><a href="gallery.jsp">gallery</a>
                <li><a href="board_list.jsp">community</a></li>
            </ul>
            <%
                String userName = (String)session.getAttribute("userName");
                if (userName != null) {          
            %>
            <ul class="util">
                <li><%=userName %>님 환영합니다</li>
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

    <figure>
        <video src="img/ddong.mp4" autoplay muted loop></video>
        <div class="inner">
            <h1>Hello everyone</h1>
            <p>welcome to the patrick Store and gallery
            <br>Receive 100 points upon signing up<br> now sign up!!!
               </p>
            <a href="shop.jsp">view shop</a>
        </div>
    </figure>

    <section>
        <div class="inner">
            <h1>Patrick Worlds</h1>
            <div class="wrap">
                <article>
                    <div class="pic">
                        <img src="img/뚱별.jfif" alt="1번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="shop.jsp">now purchase it!</a></h2>
                    <p></p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/뚱베.jfif" alt="2번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="shop.jsp">now purchase it!</a></h2>
                    <p></p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/patrick.jfif" alt="3번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="gallery.jsp">so cute patrick</a></h2>
                    <p>zz</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/sponge.jfif" alt="4번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="gallery.jsp">Look at this.</a></h2>
                    <p>patrick is so big</p>
                </article>
            </div>
        </div>
    </section>
 

    <footer>
        <div class="inner">
            <div class="upper">
                <h1>Patrick</h1>
                <ul>
                    <li><a href="#">Policy</a></li>
                    <li><a href="#">Terms</a></li>
                    <li><a href="#">Family Site</a></li>
                    <li><a href="#">Sitemap</a></li>
                </ul>
            </div>

            <div class="lower">
                <address>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas, facere.<br>
                    TEL : 031-111-1234 C.P : 010-1234-5678
                </address>
                <p>
                    2020 DOCDELAB &copy; copyright all right reserved.
                </p>
            </div>
        </div>
    </footer>




</body>

</html>