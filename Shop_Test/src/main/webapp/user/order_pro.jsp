<%@page import="shop.dto.Order"%>
<%@page import="shop.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="shop.dao.OrderRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	// 비회원 주문 내역 세션에 등록 처리
	String root = request.getContextPath();

  	String phone = request.getParameter("phone");
    String orderPw = request.getParameter("orderPw");
    OrderRepository orderDao = new OrderRepository();
    
    session.setAttribute("orderPhone", phone);
 	session.setAttribute("orderPw", orderPw);
    
    List<Product> orders = orderDao.list(phone, orderPw);

    if(orders != null && !orders.isEmpty()) {
        session.setAttribute("orderPhone", phone);
     	session.setAttribute("orderPw", orderPw);
        response.sendRedirect(root + "/user/order.jsp");
    } else {
	    response.sendRedirect(root + "/user/order.jsp");
    }

%>