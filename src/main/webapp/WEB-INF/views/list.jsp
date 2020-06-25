<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
							htmlTxt += '<tr><td><a href="/patient/detail?pno='+value.pno+'">'+value.pno+'</a></td><td>'+value.name+'</td><td>'+value.age+'</td><td>'+value.ccode+'</td><td><input type="checkbox" id="del"></td></tr>';
						});
						htmlTxt+='</table>'
						$('#list').html(htmlTxt);
					}
		     });
	 }//목록보기
     
	  $(document).ready(function(){
		  listPrint(); 	
		  
		     $('#bt_del').click(function(){  
		      	$.ajax({
		  			type:'DELETE',
		  			url:'/ssafy/api/patient/'+$('input:checkbox[id="del"]').val(),		
		  			success:function(data){
		  				listPrint();
		  			}
		  		  });	
		      });//삭제요청
	  }); //ready
  </script>
<title>Insert title here</title>
</head>
<body>
  <div id="form">
	  <div id="list"></div> 
	  <input type="button" value="삭제" id="bt_del">
  </div>
	  	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>