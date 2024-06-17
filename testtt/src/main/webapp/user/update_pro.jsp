<%@page import="shop.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="shop.dao.UserRepository" />
<%

	// 회원 정보 수정 처리
	User user = new User();
	user.setId(request.getParameter("id"));
	user.setPassword(request.getParameter("pw"));
	user.setGender(request.getParameter("gender"));
	user.setBirth(request.getParameter("year") + "-" + request.getParameter("month") + "-" + request.getParameter("day"));
	user.setMail(request.getParameter("email1") + "@" + request.getParameter("email2"));
	user.setPhone(request.getParameter("phone"));
	user.setAddress(request.getParameter("address"));
	
	int result = userDAO.update(user);
	if (result > 0 ){
	    response.sendRedirect("complete.jsp?msg=2");
	} else {
	    response.sendRedirect("update.jsp");
	}

%>