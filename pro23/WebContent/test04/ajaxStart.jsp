<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#click').click(function() {
		$.ajax({
			type:"get",
			async:true,
			url:"${contextPath}/ajax.do",
			success:function (data, textStatus){
				console.log(data);
				$('.content').html(data);
			}
		});		
	});
});
</script>
</head>
<body>
	<button id="click">비동기처리로 회원 모두 조회 하기</button>
	<div class="content"></div>
	
	
	
		

</body>
</html>