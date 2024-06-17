<%@page import="shop.dao.UserRepository"%>
<%@page import="shop.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String pw_confirm = request.getParameter("pw_confirm");
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
    String email = request.getParameter("email1") + "@" + request.getParameter("email2");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");
    
    String passwordRegex = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>\\/?])[A-Za-z0-9!@#$%^&*()_+\\-=\\[\\]{};':\",.<>\\/?]*$";

    char firstId = id.charAt(0);
    if (!((firstId >= 'a' && firstId <= 'z') || (firstId >= 'A' && firstId <= 'Z') || (firstId >= '가' && firstId <= '힣'))) {
        out.println("<script>alert('아이디는 영문 또는 한글로 시작해야 합니다.'); history.back();</script>");
        return;
    }
    if (!(pw.length() >= 6)) {
        out.println("<script>alert('비밀번호를 6자 이상 입력해주세요.'); history.back();</script>");
        return;
    }
    if (!pw.matches(passwordRegex)) {
        out.println("<script>alert('비밀번호는 영문자, 숫자, 특수기호만 입력 가능하고, 특수 문자는 반드시 1개 이상 포함해주세요.'); history.back();</script>");
        return;
    }
    if (!pw.equals(pw_confirm)) {
        out.println("<script>alert('비밀번호가 일치하지 않습니다.'); history.back();</script>");
        return;
    }
    for (int i = 0; i < name.length(); i++) {
        char ch = name.charAt(i);
        if (ch < '가' || ch > '힣') {
            out.println("<script>alert('이름은 한글만 입력 가능합니다.'); history.back();</script>");
            return;
        }
    }

    User user = new User();
    user.setId(id);
    user.setPassword(pw);
    user.setName(name);
    user.setGender(gender);
    user.setBirth(year + "-" + month + "-" + day);
    user.setMail(email);
    user.setPhone(phone);
    user.setAddress(address);

    UserRepository userDAO = new UserRepository();
    int result = userDAO.insert(user);

    if (result > 0) {
        response.sendRedirect("complete.jsp?msg=1");
    } else {
        out.println("<script>alert('회원 가입 실패. 다시 시도해 주세요.'); history.back();</script>");
    }
%>
    

    
    
    
    
    
    