<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="DTO.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>주문 화면</title>
    
    
    <jsp:include page="/layout/link.jsp" />
    <!-- 이정용 : style.css 파일에 모달화면 css를 홍콩반점과 같이 꾸며주세요. -->
    <link rel="stylesheet" href="static/css/style.css"> 
</head>
<body>
<%
	List<Product> productList = new ArrayList<Product>();

	Product product1 = new Product("P0001", "물냉", 8000, 1, "/img/물냉.jpg");
	Product product2 = new Product("P0002", "비냉", 9000, 1, "/img/비냉.jpg");
	Product product3 = new Product("P0003", "평냉", 10000, 1, "/img/평냉.jpg");
	Product product4 = new Product("P0004", "공깃밥", 1000, 1, "/img/공깃밥.jpg");
	
	productList.add(product1);
	productList.add(product2);
	productList.add(product3);
	productList.add(product4);
	
%>

<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
    display: none; /* 처음에는 숨겨져 있음 */
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0,0,0,0.4); /* 반투명 검은색 배경 */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: 15% auto; /* 화면 중앙에 위치 */
    border: 1px solid #888;
    width: 30%; /* 내용 너비는 전체의 80% */
}

/* Add Animation */
@-webkit-keyframes animatetop {
  from {top:-300px; opacity:0} 
  to {top:0; opacity:1}
}

@keyframes animatetop {
  from {top:-300px; opacity:0}
  to {top:0; opacity:1}
}

/* The Close Button */
.closeBtn {
    color: #aaaaaa;
    float: right; /* 오른쪽 상단에 위치 */
    font-size: 28px; /* 크기 조정 */
    font-weight: bold;
}

.closeBtn:hover,
.closeBtn:focus {
    color: #000; /* 마우스 오버 시 색상 변경 */
    text-decoration: none;
    cursor: pointer; /* 마우스 커서를 포인터로 변경 */
}

.modal-header {
  padding: 2px 16px;
  /* background-color: black; */
  color: white;
}

.modal-body {
	/* padding: 2px 16px; */
}

.room_img {
	margin: auto;
	display: block;
}

.modal-footer {
  text-align: center;
  padding: 2px 16px;
  background-color: gray;
  color: white;
}
.pop-btn {
	display: inline-block;
	width: 45%;
}

img {
	text-align: center;
	width: 300px;
	height: 300px;
}
#detail-img-box {
	text-align: center;
}
#detail-count {
	width: 15%;
	background-color: white;
	color: black;
}
.room_img {
	width: 70%;
	height: 70%;
}
#product-detail-name {
	margin: 15px;
	text-align: center;
}
#product-detail-price {
	text-align: right;
}

#detail-plus {
	background-color: black;
	color: white;
}

#detail-minus {
	background-color: white;
	color: black;
}


</style>
</head>
<body>


<!-- 모달을 여는 버튼 -->
<div id="openModalBtn">
   <!-- 데이터베이스에서 사진 URL을 불러와 표현해야 함. -->
   <!-- 나중에 해야할 것 -->
   <!-- 음식 사진을 아무거나 넣고 진행해주세요. -->
	<c:forEach var="product" items="<%= productList %>">
		<div class="product-item" id="${ product.productId }">
			<input type="hidden" name="count" value="${ product.count }" />
	   		<img src="<%= request.getContextPath() %>${ product.filePath }" alt="food_img1">
			<h4>${ product.name }</h4>
			<h3>${ product.price }</h4>
		</div>
   	</c:forEach>
<%--    <img src="<%= request.getContextPath() %>/img/물냉.jpg" alt="food_img1"> --%>
<!--    <h4>물냉</h4> -->
<%--    <img src="<%= request.getContextPath() %>/img/비냉.jpg" alt="food_img1"> --%>
<!--    <h4>비냉</h4> -->
<%--    <img src="<%= request.getContextPath() %>/img/평냉.jpg" alt="food_img1"> --%>
<!--    <h4>평냉</h4> -->
<%--    <img src="<%= request.getContextPath() %>/img/공깃밥.jpg" alt="food_img1"> --%>
<!--    <h4>공깃밥</h4> -->
   
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
	    		
	    	</div>
<%--             <img src="<%= request.getContextPath() %>${ product.filePath }" alt="food_img1" class="room_img"> --%>

            <h4 id="product-detail-name"></h4>
            <h4 id="product-detail-price"></h4>
            <button type="button" id="detail-minus">-</button>
            <input type="number" name="" value="0" id="detail-count" />
            <button type="button" id="detail-plus">+</button>
	    </div>
	    </div>
	    <div class="modal-footer">
    <div class="pop-btn confirm" id="cancel">취소하기</div>
    <div class="pop-btn confirm" id="confirm">추가하기</div>
</div>
	  </div>
	
	</div>

	<jsp:include page="/layout/script.jsp" />
	<script>
		
		// 목록에서 상품 아이템 클릭 
		$('.product-item').on('click', function() {
			$('#myModal').show()
			
			let item = $(this)
			let count = item.children()[0].value
			let img = $( item.children()[1] ).clone()
			let productName = item.children()[2].textContent
			let price = item.children('h3').text()
			console.log( count )
			console.log( img )
			console.log( productName )
			console.log( price )
			
			$('#detail-img-box').html( img )
			$('#product-detail-name').text( productName )
			$('#detail-count').val( count )
			$('#product-detail-price').text(price)
			
		})
		
		$('#detail-plus').on('click', function() {
    let count = parseInt($('#detail-count').val());
    count++;
    $('#detail-count').val(count);
    let price = parseFloat($('#product-detail-price').text());
    if (count > 1) { // 최소 수량 이상인 경우에만 가격을 업데이트
        $('#product-detail-price').text(price + (price / (count - 1)));
    } else {
        $('#product-detail-price').text(price); // 최소 수량이 1인 경우 가격을 그대로 유지
    }
});

$('#detail-minus').on('click', function() {
    let count = parseInt($('#detail-count').val());
    if (count > 1) { // 최소 수량을 1로 설정
        count--;
        $('#detail-count').val(count);
        let price = parseFloat($('#product-detail-price').text());
        $('#product-detail-price').text(price - (price / count));
    } else { // 최소 수량인 경우 가격을 그대로 유지
        $('#detail-count').val(1);
        let price = parseFloat($('#product-detail-price').text());
        $('#product-detail-price').text(price);
    }
});
		
		// 모달 바깥 클릭 
		$('.closeBtn').on('click', function() {
			$('#myModal').hide()
		})
		
		document.getElementById('confirm').onclick = function(event) {
	    event.preventDefault(); // 폼의 기본 제출 동작을 방지
	   
	    //var dataInput = document.getElementById('dataInput').value;
	
	    //var xhr = new XMLHttpRequest();
	    //xhr.open("POST", "AddDataServlet", true);
	    //xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    //xhr.onreadystatechange = function() {
	        //if (this.readyState == 4 && this.status == 200) {
	            // 요청이 성공적으로 완료되었을 때의 동작
	           // console.log(this.responseText);
	            // 모달 닫기, 성공 메시지 표시 등
	        //}
	    //};
	   // xhr.send("data=" + encodeURIComponent(dataInput));
	   alert('추가가 완료되었습니다.');
		};
		
		$('#cancel').on('click', function() {
			$('#myModal').hide()
		})
		
		$('#confirm').on('click', function() {
		    let productName = $('#product-detail-name').text();
		    let productPrice = parseFloat($('#product-detail-price').text());
		    let productCount = parseInt($('#detail-count').val());
		    
		    // 쿼리 문자열을 사용하여 데이터를 전달
		    window.location.href = 'cart.jsp?productName=' + encodeURIComponent(productName) + '&productPrice=' + productPrice + '&productCount=' + productCount;
		});
			
	</script>
	
</body>
</html>











