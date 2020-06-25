<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
	#result{
		display: none;
	}
</style>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script>
	  function listPrint(){
		     $.ajax({
					type:'GET',
					url:'/ssafy/api/patient/all',
					dataType:'json',
					success:function(data){
						var htmlTxt='<table>';
						$.each(data,function(index,value){
							htmlTxt += '<tr><td>'+value.pno+'</td><td>'+value.name+'</td><td>'+value.age+'</td><td>'+value.ccode+'</td></tr>';
						});
						htmlTxt+='</table>'
						$('#list').html(htmlTxt);
					}
		     });
	 }//목록보기



  $(document).ready(function(){
 	$('#showList').click(function(){
 		listPrint();
 	});//목록보기
 	
     $('#showForm').click(function(){
 		$('#upform').hide();
 		$('#form').show(500);
 	});//입력폼보기
 	
	  $('#regist').click(function(){           
	      $.ajax({
	        type:'POST',
	        url:'/ssafy/api/patient',
	        contentType: 'application/json',
	        data:  JSON.stringify({
	           pno: $("#registForm input[name=pno]").val(),
	           name: $("#registForm input[name=name]").val(),
	           age: $("#registForm input[name=age]").val(),
	           ccode: $("#registForm option:selected ").val()              
	             },
	        ),
	        success:function(data){    
				alert($("#registForm input[name=name]").val());
	        }
	     });
	    });//입력요청
	    
  	
  }); //ready
  </script>
<title>SSAFY</title>
</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	  <div id="list"></div>  
	<form id="registForm">
		<label for="pno" class="inputtitle">환자 번호</label>
		<input type="text" name="pno" id="pno">
		<br>
		<label for="name" class="inputtitle">환자명</label>
		<input type="text" name="name" id="name">
		<br>
		<label for="age" class="inputtitle">나이</label>
		<input type="number" name="age" id="age">
		<br>
		<label for="ccode" class="inputtitle">국적</label>
		<select id="ccode" name="ccode">
			<option value="kr">대한민국
			<option value="us">미국
			<option value="cn">중국
		</select>
		<br>
	</form>
	<button id="regist">환자 등록</button>
	<button id="reset">초기화</button>
	<fieldset id="result">
		<legend>등록 오류</legend>
		<div></div>
	</fieldset>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
<script>

</script>
</html>