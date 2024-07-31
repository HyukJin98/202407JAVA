<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

// 폼 데이터 수집
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
String numStr = request.getParameter("num");

// 업데이트가 처리된 후 리다이렉트할지 결정하는 플래그
boolean isUpdated = false;

if (writer != null && title != null && content != null && numStr != null) {
    int num = Integer.parseInt(numStr);

    // BoardDTO 객체 생성 및 값 설정
    BoardDTO dto = new BoardDTO();
    dto.setWriter(writer);
    dto.setTitle(title);
    dto.setContent(content);
    dto.setNum(num);

    // BoardDAO 객체 생성 및 업데이트 메소드 호출
    BoardDAO dao = new BoardDAO();
    dao.updateBoard(dto);

    // 업데이트 성공 플래그 설정
    isUpdated = true;
}

if (isUpdated) {
    // 업데이트가 완료되면 목록 페이지로 리다이렉트
    response.sendRedirect("list.jsp");
    return;
} else {
    // 폼이 제출되지 않았거나 데이터가 부족할 경우 기존 게시물 데이터를 로드하여 폼에 미리 채워 넣기
    String numStrFromForm = request.getParameter("num");
    if (numStrFromForm != null) {
        int num = Integer.parseInt(numStrFromForm);

        // BoardDAO 객체 생성 및 게시물 데이터 가져오기
        BoardDAO dao = new BoardDAO();
        BoardDTO dto = dao.getOne(num);

        if (dto != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Board</title>
</head>
<body>
    <h1>게시물 수정</h1>
    <form action="updateBoard.jsp" method="post">
        <input type="hidden" name="num" value="<%= dto.getNum() %>">
        작성자: <input type="text" name="writer" value="<%= dto.getWriter() %>" required><br>
        제목: <input type="text" name="title" value="<%= dto.getTitle() %>" required><br>
        내용: <textarea name="content" required><%= dto.getContent() %></textarea><br>
        <input type="submit" value="수정">
    </form>
</body>
</html>
<%
        } else {
            out.println("존재하지 않는 게시물입니다.");
        }
    } else {
        out.println("잘못된 접근입니다.");
    }
}
%>