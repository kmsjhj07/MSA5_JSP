<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="shop.dao.UserRepository" />

<%
	String id = request.getParameter("id");
    int result = userDAO.delete(id);

    if (result > 0) {
        session.invalidate();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("rememberMe") || cookie.getName().equals("token")) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }

        response.sendRedirect("complete.jsp?msg=3");
    } else {
        response.sendRedirect("error.jsp?msg=회원 삭제 중 에러 발생");
    }
%>