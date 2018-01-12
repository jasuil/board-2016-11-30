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
<script  src="../resources/jquery/jquery-3.1.0.min.js"></script>
<script>
function listGo(){
	window.location='board/listAll';
}

function json(){
	alert('1');
 $.ajax({
 	   type: "PATCH", 	
	   url: "do",	   
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "PATCH"
		},
	   data :JSON.stringify({'id': "peak",'content':'안녕'}), //test_proc.jsp로 groupNm 파라미터값 보내줌 test_proc.jsp이동
	   success: function(o){
		
		   //여기서 값을 jason array로 불러와서 json object로 파싱한 다음에 그래프에 저장한다.
			         alert(o);
	            	$('#text').html(o); 
	            
           	
	   },
    error: function(o){
		   $('#text').text("값이 없거나 잘못된 숫자가 입력되었습니다.");
	    		   }
           
    
  });
}

function json2(){
	alert('2');
$.ajax({
    url : "user",
    dataType : "json",
    type : "post",
    data : $('#formId').serializeArray(),
    success: function(data) {
        alert("성공:"+data.KEY);
    },
    error:function(request,status,error){
        alert("code:"+request.status+"\n"+"error:"+error);
    }
 
}); 
}

function repl(data){
$.ajax({
	type : 'post',
	url : 'replies',
	headers : {
		"Content-Type" : "application/json",
		"X-HTTP-Method-Override" : "POST"
	},
	dataType : 'text',
	data : JSON.stringify({
		bno : 1,
		content : 'replyer',
		'writer' : "replytext"
	}),
	success : function(result) {

		if (result == 'success') {

			alert("등록 되었습니다."); 
			$('#text').append(result);//JSONcontroller에서 문자열 받음

		}
	},
	  error: function(o){
		   $('#text').text("값이 없거나 잘못된 숫자가 입력되었습니다.");
	   }
});
}

  
var re = /(?:\d{3}|\(\d{3}\))([-\/\.])\d{3}\1\d{4}/;  
function testInfo(phoneInput){  
  var OK = re.exec(phoneInput.value);  
  if (!OK)  
    window.alert(phoneInput.value + " isn't a phone number with area code!");  
  else
    window.alert("Thanks, your phone number is " + OK[0]);  
}  
  
</script>

	<title>json</title>
	
</head>
<body>
<h1>
	안녕 성일 !  
</h1>

<P id='text'>  The time on the server is ${serverTime}. </P>
<button id='goList' onclick='listGo()'>목록으로 가기</button>
<button id='goList' onclick='json()'>json</button>
<button id='goList' onclick='json2()'>json2</button>
<button id='goList' onclick='repl()'>repl</button>

 <form action="you" method='get'>  
 <input type='hidden' name='yyy' value='ok'>
      <input id="phone" name='p'><button onclick="testInfo(document.getElementById('phone'));">Check</button>
    </form>  
</body>
</html>
