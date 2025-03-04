<%@page import="com.oreilly.servlet.CookieNotFoundException"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="shop.Service.UserServiceImpl"%>
<%@page import="shop.Service.UserService"%>
<%@page import="shop.DAO.UserDAO"%>
<%@page import="shop.DTO.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	Users user = new Users();
	user.setId(id);
	user.setPassword(password);
	
	// 로그인 요청
	UserService userService = new UserServiceImpl();
	Users loginUser = userService.login(user);
	
	// 로그인 실패
	if( loginUser == null ) {
		response.sendRedirect("login.jsp?msg=0");
		return;
	}
	
	// 아이디 저장
	String rememberId = request.getParameter("rememberId");
	Cookie cookieRememberId = new Cookie("rememberId", "");
	Cookie cookieUserId = new Cookie("userId", "");
	
	// 체크박스 체크 시, 값 : on
	if( rememberId != null && rememberId.equals("on") ) {
		// 쿠키 생성
		// UTF-8 으로 인코딩하여 값을 저장해야한다.
		cookieRememberId.setValue( URLEncoder.encode( rememberId, "UTF-8" ) );
		cookieUserId.setValue( URLEncoder.encode( id, "UTF-8" ) );
	}
	// 체크박스 미체크 시
	else {
		// 쿠키 삭제
		cookieRememberId.setMaxAge(0);
		cookieUserId.setMaxAge(0);
	}
	// 쿠키 응답에 등록
	response.addCookie(cookieRememberId);
	response.addCookie(cookieUserId);
	// 아이디 저장 (끝)
	
	// 자동 로그인
	String rememberMe = request.getParameter("rememberMe");
	Cookie cookieRememberMe = new Cookie("rememberMe", "");
	Cookie cookieToken = new Cookie("token", "");
	
	// 자동 로그인 체크 여부, 토큰 쿠키에 대한 경로 설정
	cookieRememberMe.setPath("/");
	cookieToken.setPath("/");
	// 쿠키 유효기간 설정 - 초단위 --> 7일
	cookieRememberMe.setMaxAge(7*60*60*24);		 
	cookieToken.setMaxAge(7*60*60*24);
	
	// 체크 여부에 따라 쿠키 생성 또는 삭제
	if( rememberMe != null && rememberMe.equals("on") ) {
		// 자동 로그인 체크 
		// - 토큰 발행
		String tokenValue = userService.refreshToken(id);
		// - 쿠키 생성
		cookieRememberMe.setValue( URLEncoder.encode( rememberMe, "UTF-8") );
		cookieToken.setValue( URLEncoder.encode( tokenValue, "UTF-8") );
	} else {
		// 자동 로그인 미체크
		// 쿠키 삭제
		cookieRememberMe.setMaxAge(0);
		cookieToken.setMaxAge(0);
	}
	
	// 응답에 쿠키 등록
	response.addCookie(cookieRememberMe);
	response.addCookie(cookieToken);
	// 자동 로그인 (끝)
	
	
	if( loginUser != null ) {
		// 로그인 성공
		// 세션에 아이디 등록 후, 메인 페이지로 이동
		session.setAttribute("loginId", loginUser.getId());
		response.sendRedirect("index.jsp");
	}
	else {
		// 로그인 실패
		response.sendRedirect("login.jsp?msg=0");
	}
	
	
	

%>




