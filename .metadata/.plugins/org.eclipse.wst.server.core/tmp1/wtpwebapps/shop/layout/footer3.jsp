<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer Example</title>
    <style>
        /* 푸터 스타일 */
        .footer {
		    position: fixed;
		    bottom: 0;
		    left: 0;
		    background: #fff;
		    width: 100%;
		    z-index: 999;
		    border-top: 1px solid #eee;
		    box-shadow: 0px -1px 5px 2px rgba(238,238,238,0.5);
		}

		/* 푸터 이너 */
		.inner {
		    position: relative;
		    width: 100%;
		    max-width: 720px;
		    min-width: 300px;
		    margin: 0 auto;
		    text-align: center;
		    box-sizing: border-box;
		}
		
		/* 푸드 오더 섹션 */
		.f_order_section {
		    padding: 5px 0;
		    display: table;
		    width: 100%;
		}
		
		/* 푸드 오더 */
		.f_order {
		    display: table-cell;
		    width: 50%;
		    padding: 5px 10px;
		    vertical-align: bottom;
		}
		
		/* 푸드 오더 버튼 */
		.f_order_btn {
		    color: #fff;
		    width: 100%;
		    min-height: 100%;
		    height: auto;
		}
		
		.f_nav_section {
		    background: #eee;
		    width: 100%;
		}
		
		.f_nav {
		    display: table;
		    width: 100%;
		    padding: 10px 0;
		}
		
        /* 주문 정보 스타일 */
        .order-info {
            height: 100%;
            padding: 30px 10px 30px 30px;
            box-sizing: border-box;
        }

        /* 주문하기 버튼 스타일 */
        .order-button {
            flex: 1 1 50%;
            text-align: right;
            margin-bottom: 20px;
        }

        /* 사진 스타일 */
        .footer-image-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            margin-top: 20px; /* 사진과 주문 정보 사이에 여백 추가 */
        }

        .footer-image {
            display: table;
            width: 100px;
            padding: 10px 0;    
        }
    </style>
</head>
<body>
    <footer>
    
    	<div class="footer">
    		<p>asdasff</p>
    	</div>
    	
    	<div class="f_nav">
    		<p> ㅁㄴㅇㅁㄹㄻ </p>
    	</div>
    	
        <!-- 주문 정보 -->
        <div class="order-info">
            <p>주문</p>
            <p>금액</p>
        </div>

        <!-- 주문하기 버튼 -->
        <div class="order-button">
            <button onclick="window.location.href='다른페이지주소'">주문하기</button>
        </div>

        <!-- 사진 -->
        <div class="footer-image-container">
            <img class="footer-image" src="사진1주소" alt="사진1 설명">
            <img class="footer-image" src="사진2주소" alt="사진2 설명">
            <img class="footer-image" src="사진3주소" alt="사진3 설명">
        </div>
    </footer>
</body>
</html>

