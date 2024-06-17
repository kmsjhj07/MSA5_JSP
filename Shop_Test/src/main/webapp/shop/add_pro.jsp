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
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	String bookID = request.getParameter("bookID");
	String bookName = request.getParameter("bookName");
	String unitPrice = request.getParameter("unitPrice");
	String description = request.getParameter("description");
	String author = request.getParameter("author");
	String publisher = request.getParameter("publisher");
	String category = request.getParameter("category");
	String unitsInStock = request.getParameter("unitsInStock");
	String condition = request.getParameter("condition");

	Integer price;

	if (unitPrice.isEmpty())
		price = 0;
	else
		//문자로 들어오는 것을 숫자로 바꾸어라.
		price = Integer.valueOf(unitPrice);

	long stock;

	if (unitsInStock.isEmpty())
		stock = 0;
	else
		stock = Long.valueOf(unitsInStock);
	
	Product = Product.getInstance();
	
	Product product = new Product();
	new Product.setproduct_id(product_id);
	new Product.setname(name);
	new Product.setUnitPrice(UnitPrice);
	new Product.setDescription(description);
	new Product.setManufacturer(Manufacturer);
	new Product.setCategory(category);
	new Product.setUnitsInStock(UnitsInStock);
	new Product.setCondition(condition);
	new Product.setFile(file);
	
	addProduct(new Product);
	
	//페이지 이동
	response.sendRedirect("products.jsp");
	
%>
</body>
</html>