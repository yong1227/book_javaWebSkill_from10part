<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSONTest</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		$("#checkJson").click(function(){
			// 새글 정보를 JSON으로 생성합니다
			var article = {articleNO : "114",
				writer : "박지성", 
				title : "안녕하세요",
				content: "상품 소개 글입니다."
			};
			
			$.ajax({
				// 새 글 등록은 POST 방식으로 요청합니다.
				//type: "POST",
				// 새 글을 등록하는 메서드를 호출합니다.
				//url : "${contextPath}/boards",
				// 글 번호 114번에 대해 수정을 요청합니다.
				//type: "PUT",
				type: "DELETE",
				url : "${contextPath}/boards/1227",
				contentType: "application/json",
				//  글 정보를 JSON 형식으로 전송합니다.
				data: JSON.stringify(article),
				success: function (data, textStatus){
					alert(data);
				},
				error: function(data, textStatus){
					alert("에러가 발생했습니다.");
				},
				complete: function(data, textStatus){
				}
			});
		});
	});
</script>
</head>
<body>
	여기는 JSONTest2 페이지 입니다.
	<input type="button" id="checkJson" value="삭제하기"/><br><br>
	<div id="output"></div>
</body>
</html>