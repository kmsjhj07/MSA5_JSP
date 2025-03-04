<%@page import="shop.dto.User"%>
<%@page import="shop.dao.UserRepository"%>
<%@page import="java.util.List"%>
<%@page import="shop.dto.Order"%>
<%@page import="shop.dao.OrderRepository"%>
<%@page import="shop.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
    <jsp:include page="/layout/meta.jsp" /> 
    <jsp:include page="/layout/link.jsp" />
</head>
<body>   
    <%
        String root = request.getContextPath();
        String loginId = (String) session.getAttribute("loginId");
        boolean login = loginId != null && !loginId.isEmpty();
        UserRepository userDAO = new UserRepository();
        User loginUser = userDAO.getUserById(loginId);
    %>
    
    <jsp:include page="/layout/header.jsp" />
    
    <div class="row m-0 mypage">
        <div class="sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary">
            <div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary">
                <ul class="nav nav-pills flex-column mb-auto">
                    <% if (login) { %>
                        <li class="nav-item">
                            <a href="<%= root %>/user/index.jsp" class="nav-link link-body-emphasis">
                                마이 페이지
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="<%= root %>/user/update.jsp" class="nav-link link-body-emphasis">
                                회원정보 수정
                            </a>
                        </li>
                    <% } %>
                    <li>
                        <a href="#" class="nav-link active" aria-current="page" >
                            주문내역
                        </a>
                    </li>
                </ul>
                <hr>
            </div>
        </div>
        
        <div class="col-md-9 ms-sm-auto col-lg-10 p-0 m-0">
            <div class="px-4 py-3 my-3 text-center">
                <h1 class="display-5 fw-bold text-body-emphasis">주문 내역</h1>
                <div class="col-lg-6 mx-auto">
                    <% if (!login) { %>    
                        <p class="lead mb-4">비회원 주문하신 경우, 전화번호와 주문 비밀번호를 입력해주세요.</p>
                    <% } %>
                </div>
            </div>
            
            <div class="container shop m-auto mb-5">
                <form action="<%= root %>/user/order_pro.jsp" method="post">
                    <% if (!login) { %>
                        <div class="mb-5">
                            <table class="table">
                                <tr>
                                    <td>전화번호 :</td>
                                    <td>
                                        <input type="text" class="form-control" name="phone" placeholder="- 생략하고 숫자만 입력해주세요.">
                                    </td>
                                </tr>
                                <tr>
                                    <td>주문 비밀번호 :</td>
                                    <td>
                                        <input type="password" class="form-control" name="orderPw" placeholder="주문 비밀번호를 입력해주세요.">
                                    </td>
                                </tr>
                            </table>
                            <div class="btn-box d-grid gap-2">
                                <button type="submit" class="btn btn-outline-primary btn-lg px-4 gap-3">조회</button>
                            </div>
                        </div>
                    <% } %>
                </form>
                <% 
                    String orderPhone = (String) session.getAttribute("orderPhone");
                    String orderPw = (String) session.getAttribute("orderPw");
                %>
                <% if (login || (orderPhone != null && !orderPhone.isEmpty())) { %>
                    <table class="table table-striped table-hover table-bordered text-center align-middle">
                        <thead>
                            <tr class="table-primary">
                                <th>주문번호</th>
                                <th>상품</th>
                                <th>가격</th>
                                <th>수량</th>
                                <th>소계</th>
                                <th>비고</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%  
                                OrderRepository orderDao = new OrderRepository();
                                List<Product> orderList = login ? orderDao.list(loginId) : orderDao.list(orderPhone, orderPw);
                                int sum = 0;
                                for (Product product : orderList) {
                                    int total = product.getUnitPrice() * product.getQuantity();
                                    sum += total;
                            %>
                            <tr>
                                <td><%= product.getOrderNo() %></td>         
                                <td><%= product.getName() %></td>         
                                <td><%= product.getUnitPrice() %></td>         
                                <td><%= product.getQuantity() %></td>         
                                <td><%= total %></td>         
                                <td></td>         
                            </tr>
                            <% } %>
                        </tbody>
                        <tfoot>
                            <% if (orderList.isEmpty()) { %>
                                <tr>
                                    <td colspan="6">추가된 상품이 없습니다.</td>    
                                </tr>
                            <% } else { %>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>총액</td>
                                    <td id="cart-sum"><%= sum %></td>
                                    <td></td>
                                </tr>
                            <% } %>
                        </tfoot>
                    </table>
                <% } %>
            </div>
            <jsp:include page="/layout/footer.jsp" />
        </div>
    </div>
    <jsp:include page="/layout/script.jsp" />
</body>
</html>
