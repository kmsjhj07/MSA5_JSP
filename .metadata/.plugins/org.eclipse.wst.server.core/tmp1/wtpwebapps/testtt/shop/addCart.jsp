<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="shop.dto.Product"%>
<%@page import="shop.dao.ProductRepository"%>
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
<title>Insert title here</title>
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
</html>