<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 자동 로그인, 토큰 쿠키 삭제
	Cookie rememberMeCookie = new Cookie("rememberMe", "");
	rememberMeCookie.setMaxAge(0);
	response.addCookie(rememberMeCookie);
	
	Cookie tokenCookie = new Cookie("token", "");
	tokenCookie.setMaxAge(0);
	response.addCookie(tokenCookie);
	
	// 세션 무효화
	session.invalidate();

	// 쿠키 전달
	response.sendRedirect("login.jsp");
%>