<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- booststrap -->
<script src="<%= request.getContextPath() %>/static/js/bootstrap.bundle.min.js" ></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- js -->
<%-- <script src="<%= request.getContextPath() %>/static/js/modal.js"></script> <!-- JavaScript 파일 참조 --> --%>
<script src="<%= request.getContextPath() %>/static/js/script.js"></script>

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
		
		// 모달 내 취소하기 버튼 클릭
		$('#cancel').on('click', function() {
			$('#myModal').hide()
		})
		
		// 모달 내 수량(+, -) 버튼 클릭
		$('#detail-plus').on('click', function() {
        let count = parseInt($('#detail-count').val());
        count++;
        $('#detail-count').val(count);
        let price = parseFloat($('#product-detail-price').text());
        $('#product-detail-price').text(price + parseFloat(price / (count - 1)));
       });
   
       $('#detail-minus').on('click', function() {
           let count = parseInt($('#detail-count').val());
           if (count > 0) {
               count--;
               $('#detail-count').val(count);
               let price = parseFloat($('#product-detail-price').text());
               $('#product-detail-price').text(price - parseFloat(price / (count + 1)));
           }
       });

		
		// 모달 바깥 클릭 
		$('.closeBtn').on('click', function() {
			$('#myModal').hide()
		})
		
		// 모달 내 추가하기 버튼 클릭
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