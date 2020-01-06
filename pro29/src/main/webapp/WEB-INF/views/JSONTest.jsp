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
			// 회원 정보를 JSON으로 생성합니다.
			var member = { 
				id : "park",
				name : "박지성",
				pwd : "1234",
				email : "park@test.com"
			};
			$.ajax({
				type: "post",
				// /test/info로 요청합니다.
				url: "${contextPath}/test/info",
				contentType: "application/json",
				// 회원 정보를 JSON 문자열로 변환합니다.
				data: JSON.stringify(member),
				success: function(data, textStatus){
					
				},
				error: function(data, textStatus){
					alert("에러가 발생했습니다.");
				},
				complete : function(data, textStatus){
					
				}
			}); //end ajax
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson" value="회원 정보 보내기"/><br><br>
	<div id="output"></div>
</body>
</html>