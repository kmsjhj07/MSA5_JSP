<%@page import="java.util.UUID"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="shop.dto.User"%>
<%@page import="shop.dao.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	UserRepository userDAO = new  UserRepository();
	User loginUser = userDAO.login(id, pw);

	String rememberId = request.getParameter("remember-id");
	Cookie cookieRememberId = new Cookie("rememberId", "");
	Cookie cookieUserId = new Cookie("userId", "");
	
	if( rememberId != null && rememberId.equals("on") ) {
		cookieRememberId.setValue( URLEncoder.encode( rememberId, "UTF-8" ) );
		cookieUserId.setValue( URLEncoder.encode( id, "UTF-8" ) );
	}
	else {
		cookieRememberId.setMaxAge(0);
		cookieUserId.setMaxAge(0);
	}
		response.addCookie(cookieRememberId);
		response.addCookie(cookieUserId);
	
	String rememberMe = request.getParameter("remember-me");
	Cookie cookieRememberMe = new Cookie("rememberMe", "");
	Cookie cookieToken = new Cookie("token", "");
	
	cookieRememberMe.setPath("/");
	cookieToken.setPath("/");
	cookieRememberMe.setMaxAge(7*60*60*24);		 
	cookieToken.setMaxAge(7*60*60*24);
	
	if (rememberId != null && rememberId.equals("on")) {
	    cookieUserId.setValue(URLEncoder.encode(id, "UTF-8"));
	    cookieUserId.setPath("/");
	    cookieUserId.setMaxAge(30 * 24 * 60 * 60); 
	    response.addCookie(cookieUserId);
	} else {
	    cookieUserId.setMaxAge(0);
	    cookieUserId.setPath("/");
	    response.addCookie(cookieUserId);
	}

	
	response.addCookie(cookieRememberMe);
	response.addCookie(cookieToken);
	
	if (loginUser != null) {
	    session.setAttribute("loginId", id);  
	    session.setAttribute("cartList", null); 

	    response.sendRedirect("complete.jsp?msg=0");  
	} else {
    	response.sendRedirect("login.jsp?error=0");  
	}

%>




