<%@page import="shop.Service.BoardServiceImpl"%>
<%@page import="shop.DTO.Board"%>
<%@page import="shop.Service.BoardService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>	
	<%
		BoardService boardService = new BoardServiceImpl();
		int no = Integer.parseInt( request.getParameter("no") );
		Board board = boardService.select(no);
		
	%>
	<h1>게시글 수정</h1>
	<% if( board != null && board.getNo() > 0 ) { %>
	<form id="form" action="<%= request.getContextPath() %>/board/update_pro.jsp" method="post">
		<input type="hidden" id="no" name="no" value="<%= board.getNo() %>" />
		<table border="1">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" value="<%= board.getTitle() %>" />
				</td>
			</tr>	
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="userId" value="<%= board.getUserId() %>" />
				</td>
			</tr>	
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="40" name="content">
						<%= board.getContent() %>
					</textarea>
				</td>
			</tr>	
		</table>
		<input type="submit" value="수정" />
		<button type="button" onclick="deletePro()">삭제</button>
 	</form>
	<% } else { %>
		<h3>조회된 게시글이 없습니다.</h3>
	<% } %>
	
	<div>
		<a href="<%= request.getContextPath() %>/board/list.jsp">
			목록
		</a>
		<a href="<%= request.getContextPath() %>/board/update.jsp?no=<%= board.getNo() %>">
			수정
		</a>
	</div>
	<script>
	
		// 삭제 요청
		function deletePro() {
			const form = document.getElementById('form')
			const no = document.getElementById('no').value
			
			// action 속성을 삭제요청 경로로 변경
			form.action = 'delete.jsp?no=' + no
			// 입력양식 폼 제출
			form.submit()
			
		}
	</script>
</body>
</html>
