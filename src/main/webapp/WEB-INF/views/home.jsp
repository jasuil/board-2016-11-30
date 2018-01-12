<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<style>
p#text{
color: rgb(100,200,300);
}
button#goList{
background-color: red;

height: 20px;
}
</style>
<script type="text/javascript" charset="utf-8" src="resources/jquery/jquery-3.1.0.min.js"></script>
<script>
function listGo(){
	window.location='board/listAll';
}

function json(){
	alert('2');
 $.ajax({
 	   type: "post",
	   url: "test/replies",	   
	   dataType:'JSON',
	   headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		dataType:'text',
	   data : JSON.stringify({"id" : 'ruleNm', regdate : 'date', 'writer' : "peak"}), //test_proc.jsp로 groupNm 파라미터값 보내줌 test_proc.jsp이동
	   
	   success: function(o){
		
		   //여기서 값을 jason array로 불러와서 json object로 파싱한 다음에 그래프에 저장한다.
			         for(var i=0;i<= o.length;i++)
	            	$('#text').append(o.you+i); 
	            
           	
	   },
    error: function(o){
	    			   $('#text').text("값이 없거나 잘못된 숫자가 입력되었습니다.");
	    		   }
           
    
  });
}
</script>

	<title>Home</title>
	
</head>
<body>
<h1>
	안녕 성일 !  
</h1>

<P id='text'>  The time on the server is ${serverTime}. </P>
<button id='goList' onclick='listGo()'>목록으로 가기</button>
<button id='goList' onclick='json()'>json</button>
<button id='goList' onclick='json()'>json2</button>
</body>
</html>
