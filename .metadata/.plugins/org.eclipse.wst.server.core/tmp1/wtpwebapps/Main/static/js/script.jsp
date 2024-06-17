<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<!-- booststrap -->
<!-- <script src="< %= request.getContextPath() %>/static/js/bootstrap.bundle.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- js -->
<!-- <script src="< % = request.getContextPath() %>/static/js/modal.js"></script> JavaScript 파일 참조 -->
<script src="<%= request.getContextPath() %>/static/js/script.jsp"></script>
</head>
<body>
<script>
		
		// 목록에서 상품 아이템 클릭 
		$('.product-item').on('click', function() {
			$('#myModal').show()
			
			let item = $(this)
			let productId = item.attr("id")
			let count = 1;
			// let count = item.children()[0].value
			let img = $( item.children()[1] ).clone()
			let productName = item.children()[2].textContent
			let price = item.data('price');
		    let description = item.data('description'); // data-description 속성에서 description 정보를 가져옵니다.

			console.log( productId )
			console.log( count )
			console.log( img )
			console.log( productName )
			console.log( price )
			console.log(description);
			
			$('#detail-product-id').text( productId )
			$('#detail-img-box').html( img )
			$('#product-detail-name').text( productName )
			$('#detail-count').val( count )
			$('#product-detail-price').text(price)
		    $('#product-dsecription').text( description ); // 모달에 description 정보를 추가합니다.

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
            if (count > 1) {
                count--;
                $('#detail-count').val(count);
                let price = parseFloat($('#product-detail-price').text());
                $('#product-detail-price').text(price - parseFloat(price / (count + 1)));
            } else {
                // 수량 1보다 작아지면 1로 만듦
                $('#detail-count').val(1);
            }
         });
       
        function updateTotalPrice(count) {
            let price = parseFloat($('#product-detail-price').attr('data-price')); // 상품 1개당 가격
            let totalPrice = price * count;
            $('#product-detail-price').text(totalPrice.toFixed(2));
        }

		
		// 모달 바깥 클릭 
		$('.closeBtn').on('click', function() {
			$('#myModal').hide()
		})
		
		<%-- 세션에서 tableNum 값을 가져옵니다. --%>
		<%
			Integer tableNum = (Integer) session.getAttribute("tableNum");
			if (tableNum == null) {
			    // 세션에 tableNum 값이 없을 경우, 새로운 값을 파라미터에서 읽어와서 세션에 저장
			    String tableNumStr = request.getParameter("tableNum");
			    if (tableNumStr != null) {
			        tableNum = Integer.parseInt(tableNumStr);
			        session.setAttribute("tableNum", tableNum);
			    }
			}
		%>
		
		// 모달 내에서 추가하기 버튼 클릭
		$(document).ready(function() {
	    	$('#confirm').click(function(event) {
		        event.preventDefault();
		        // tableNo는 application으로 등록.
       			let tableNo = <%= tableNum %>;
		        let productId = $('#detail-product-id').text();
		        let productName = $('#product-detail-name').text();
		        let count = $('#detail-count').val();
		        let price = $('#product-detail-price').text();
		        let data = {
		        	tableNo: tableNo,
		            productId: productId,
		            productName: productName,
		            count: count,
		            price: price
		        };

		        $.ajax({
		            type: "POST",
		            url: "addToCartServlet.jsp", // 장바구니에 추가하는 서블릿 URL
		            data: data,
		            success: function(response) {
		                alert('추가가 완료되었습니다.');
		                
		                $('#myModal').hide();
		                window.location.reload("/layout/footer2.jsp");
		            },
		            error: function(xhr, status, error) {
		                alert('추가 중 오류가 발생했습니다.');
		                console.error(xhr.status);
		                console.error(xhr.responseText);
		            }
		        });
    		});
		});
		// 웹소켓 객체 생성
		var socket = new WebSocket("ws://localhost:8080/Chat/chatting");
		
		// 웹소켓 연결 시 호출 메소드
		socket.onopen = function() {
			console.log("WebSocket 연결 성공.");
		};
		
		// 메시지 수신 시 호출 메소드
		socket.onmessage = function(event) {
			console.log("메시지 수신: " + event.data);
			// 서버로부터 수신된 메시지 처리
			// 예를 들어, 수신된 메시지를 채팅 영역에 표시
			var chatArea = document.getElementById("chatArea");
			chatArea.innerHTML += "<div>" + event.data + "</div>";
			// 채팅 영역 스크롤 맨 아래로 이동
			chatArea.scrollTop = chatArea.scrollHeight;
		};
		
		socket.onclose = function() {
			console.log("WebSocket 연결 종료.");
		};
		
		// 메시지를 서버로 전송하기 위한 함수
		function sendMessage() {
			var messageInput = document.getElementById("messageInput");
			var message = messageInput.value;
			var name = document.getElementById("name").value;
			
			if( name == '' ) {
				alert('이름을 입력해주세요')
				return
			}
			// 메시지 전송 요청 함수 호출
			socket.send(name + " : " + message);
			
			// 메시지를 전송한 후 입력 필드를 지움
			messageInput.value = "";
			// 채팅 영역 스크롤 맨 아래로 이동
			var chatArea = document.getElementById("chatArea");
			chatArea.scrollTop = chatArea.scrollHeight;
			
			// 엔터 키 누를 때 sendMessage 함수 호출
			function handleKeyPress(event) {
				if (event.keyCode === 13) {
					sendMessage();
				}
			}
		}
	</script>
</body>
