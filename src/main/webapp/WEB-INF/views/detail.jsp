<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<h1>환자 관리-환자 조회</h1>
	  <table id="detail">
	    <tbody>
	      <tr>
	        <td>모델 번호 : ${detail.num}</td>
	      </tr>
	      <tr>
	        <td>모델 명: ${detail.model}</td>
	      </tr>
	      <tr>
	        <td>가 격 : ${detail.price}</td>
	      </tr>
	      <tr>
	       	<td>제조사 : 
	        	<c:if test="${detail.vcode == 10}">
	        		삼성
	        	</c:if>
	        	<c:if test="${detail.vcode == 20}">
	        		엘지
	        	</c:if>
	        	<c:if test="${detail.vcode == 30}">
	        		애플
	        	</c:if>
			</td>
	      </tr>
	    </tbody>
	  </table>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>