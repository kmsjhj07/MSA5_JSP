<!-- 2024-04-03 : 박은서
메인 메뉴 화면 및 메뉴 클릭 시 모달 팝업 -->
<%@ page import="java.sql.*" %>
<%@ page import="store.DAO.ProductDAO" %>
<%@ page import="store.DTO.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashSet"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<%@ include file="layout/footer.jsp" %>
<%@ include file="layout/footer2.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <style>
     /* 외부 컨테이너에 대한 패딩 */
    .product-container {
	    max-height: 500px; /* 최대 높이 설정 */
	    overflow-y: auto; /* 내용이 넘칠 경우 스크롤 바 생성 */
	    padding: 20px;
	}

    /* 각 제품 항목의 스타일 */
    .product-item {
        display: inline-block;
        width: calc(33.33% - 20px); /* 3개씩 나열되도록 너비 지정 */
        margin: 10px;
        padding: 20px; /* 내부 패딩 추가 */
        border: 1px solid #ccc;
        text-align: center;
    }

	.product-item img {
	    width: 100%; /* 이미지의 너비를 부모 요소에 맞춤 */
	    height: auto; /* 이미지의 높이를 자동으로 조절하여 비율 유지 */
	    max-height: 200px; /* 최대 높이 제한 */
	}
	
    .product-item h4 {
        margin-top: 5px;
    }
	</style>
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>주문 화면</title>
    <!-- 이정용 : style.css 파일에 모달화면 css를 홍콩반점과 같이 꾸며주세요. -->
    <link rel="stylesheet" href="static/css/style.css"> 
</head>
<body>
<%
	//  사용자로부터 받은 tableNum 파라미터 값을 읽어옵니다.
    String tableNumStr9 = request.getParameter("tableNum");
    if (tableNumStr9 != null) {
        int tableNum9 = Integer.parseInt(tableNumStr9);
        session.setAttribute("tableNum", tableNum9);
    }
	
	ArrayList<Product> productList = new ArrayList<>();
	String category = "메인";
	
	ProductDAO productDao = new ProductDAO(); // ProductDAO 인스턴스 생성
	try {
	    productList = productDao.getAllProducts(category); // 모든 제품 정보를 조회
	} catch(Exception e) {
	    e.printStackTrace();
	}
%>
<!-- 모달을 여는 버튼 -->
<div>
	<c:forEach var="product" items="<%= productList %>">
		<div class="product-item" id="${ product.productId }" 
			data-description="${product.description}" data-price="${ product.price }">
			<input type="hidden" name="count" value="${ product.count }" />
	   		<img src="<%= request.getContextPath() %>${ product.imagePath }" alt="food_img1">
			<h4>${ product.name }</h4>
			<h4>${ product.price } 원</h4>
		</div>
   	</c:forEach>
</div>

<!-- The Modal -->
	<div id="myModal" class="modal">
	
	  <!-- Modal content -->
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="closeBtn">&times;</span>
	    </div>
	    <div class="modal-body">
	    <div class="menu">
	    	<div id="detail-img-box">
	    		<!-- 주석 처리 해도 이미지 나옴 -->
	    		<!--  <img src="< % = request.getContextPath() %>${ product.imagePath }" alt="food_img1" class="room_img">-->
	    	</div>
            <h4 id="product-detail-name"></h4>
            <h4 id="product-detail-price"></h4>
            <h6 id="product-dsecription"></h6>
            <button type="button" id="detail-minus">-</button>
            <input type="text" name="" value="1" id="detail-count" onkeydown="return false;">
            <button type="button" id="detail-plus">+</button>
            
	    </div>
	    </div>
	    	<div class="modal-footer">
			<div class="pop-btn confirm" id="cancel">취소하기</div>
			<div class="pop-btn confirm" id="confirm">추가하기</div>
			</div>
	  </div>
	</div>
<jsp:include page="/static/js/script.jsp" />

</body>
</html>
    