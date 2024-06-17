<%@page import="java.util.ArrayList"%>
<%@page import="shop.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="shop.dao.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<jsp:include page="/layout/meta.jsp" /> <jsp:include page="/layout/link.jsp" />
</head>
<%
    String root = request.getContextPath(); 
    String productId = request.getParameter("productId");
    
    if (productId != null) {
        ProductRepository productDao = new ProductRepository();
        Product product = productDao.getProductById(productId);
        
        if (product != null) {
            List<Product> cartList = (List<Product>) session.getAttribute("cartList");
            
            if (cartList == null) {
                cartList = new ArrayList<>();
                session.setAttribute("cartList", cartList);
            }
            
            boolean duplicate = false;
            for (Product item : cartList) {
                if (item.getProductId().equals(productId)) {
                    duplicate = true;
                    item.setQuantity(item.getQuantity() + 1);
                    break;
                }
            }
            
            if (!duplicate) {
                product.setQuantity(1);
                cartList.add(product);
            }
            
            response.sendRedirect("products.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
%>
<body>   
    <jsp:include page="/layout/header.jsp" />
    <div class="px-4 py-5 my-5 text-center">
        <h1 class="display-5 fw-bold text-body-emphasis">장바구니</h1>
        <div class="col-lg-6 mx-auto">
            <p class="lead mb-4">장바구니 목록 입니다.</p>
            <div class="container mt-5">
                <table class="table table-striped table-hover table-bordered text-center align-middle">
                    <thead class="table-primary">
                        <tr>
                            <th>상품</th>
                            <th>가격</th>
                            <th>수량</th>
                            <th>소계</th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        List<Product> cartList = (List<Product>) session.getAttribute("cartList");
                        if (cartList != null && !cartList.isEmpty()) {
                            int sum = 0;
                            for (Product product : cartList) {
                                int unitPrice = product.getUnitPrice() == null ? 0 : product.getUnitPrice();
                                int total = unitPrice * product.getQuantity();
                                sum += total;
                        %>
                        <tr>
                            <td><%= product.getName() %></td>
                            <td><%= product.getUnitPrice() %></td>
                            <td><%= product.getQuantity() %></td>
                            <td><%= total %></td>
                            <td>
                                <form action="<%= root %>/shop/deleteCart.jsp" method="post">
                                    <input type="hidden" name="productId" value="<%= product.getProductId() %>" />
                                    <button type="submit" class="btn btn-danger">삭제</button>
                                </form>
                            </td>
                        </tr>
                        <% }
                        %>
                        <tr>
                            <td colspan="3">총액</td>
                            <td><%= sum %></td>
                            <td></td>
                        </tr>
                        <% } else { %>
                        <tr>
                            <td colspan="5">장바구니에 담긴 상품이 없습니다.</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
            <div class="row justify-content-between">
                <div class="col-auto">
                    <a href="<%= root %>/shop/deleteCart.jsp" class="btn btn-danger btn-lg">전체삭제</a>
                </div>
                <div class="col-auto">
                    <form action="<%= root %>/shop/ship.jsp" onsubmit="return checkCart()" method="post">
                        <button type="submit" class="btn btn-primary btn-lg">주문하기</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        function checkCart() {
            var isCartEmpty = <%= cartList == null || cartList.isEmpty() %>;
            if (isCartEmpty) {
                alert('장바구니에 담긴 상품이 없습니다.');
                return false;
            }
            return true;
        }
    </script>
    <jsp:include page="/layout/footer.jsp" />
    <jsp:include page="/layout/script.jsp" />
</body>
</html>
