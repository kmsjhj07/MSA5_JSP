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
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  border: 1px solid #888;
  width: 40%;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
  -webkit-animation-name: animatetop;
  -webkit-animation-duration: 0.4s;
  animation-name: animatetop;
  animation-duration: 0.4s
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
.close {
  color: white;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.modal-header {
  padding: 2px 16px;
  background-color: black;
  color: white;
}

.modal-body {
	padding: 2px 16px;
}

.room_img {
	margin: auto;
	display: block;
}

.modal-footer {
  text-align: center;
  padding: 2px 16px;
  background-color: black;
  color: white;
}
.pop-btn {
	display: inline-block;
	width: 40%;
}
.pop-btn confirm{                 //확인버튼
  border-right:1px solid #FFFFFF; //오른쪽 줄
  background-color: gray; 
}
img {
	width: 400px;
	height: 400px;
}
.room_img {
	width: 70%;
	height: 70%;
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
      <h2>상세페이지</h2>
    </div>
    <div class="modal-body">
<!--     <template> -->
    <div class="menu"></div>
<!--     </template> -->
<!--      <v-for="(a, i) in oneroom" :key="i"> -->
     <c:forEach var="product" items="<%= productList %>">
            <img src="<%= request.getContextPath() %>${ product.filePath }" alt="food_img1" class="room_img">
            <button type="submit">-</button>
            <button type="submit">+</button>
            <h4>${ product.name }</h4>
      </c:forEach>
<!--         </v-for> -->
    </div>
    <div class="modal-footer">
      <span class="pop-btn confirm" id="cancel">취소하기</span>
      <span class="pop-btn confirm" id="confirm">추가하기</span>
    </div>
  </div>

</div>

<script>
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("openModalBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("closeBtn")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

//모달 팝업 내 추가하기 버튼을 누를 때
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
</script>

</body>
</html>