<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<html>
<head>
<style>
div#tab{

margin: 0 auto;

}
table.table table-boarderd{
backgroud-color: grb(236,100,179);
color: rgb(255,255,255);
margin: auto;
   	 	border-left: 3px solid blue;
   	 	border-bottom: 1px solid blue;
   	 	border-collapse: collapse;
   	 	width: 600px;
   	 	text-align: center;
   	 	}
   	 	tr:hover{background-color:black; color: white;}   	 
	    tr:nth-child(even){background-color: lightgreen;}
   	 	tr:nth-child(even):hover{background-color: red; color: white;}
   	 	tr:nth-child(odd):hover{background-color: lightblue; color: white;}
   	 	th {
   	 	
    	background-color: #4CAF50;
    	color: white;
		}		
		th, td{
		padding: 15px;  	 
		}
fieldset{
width: 80px;		
}
</style>
<script  src="../resources/jquery/jquery-3.1.0.min.js"></script>
<title>목록조회</title>
</head>
</html>


<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
				
	
	<select name='searchType'>
	<option value='none'
	<c:out value='${cri.searchType == null? "selected" : "" }'/>>			
	---</option>			
	<option value="title"
		<c:out value="${cri.searchType eq 'title'?'selected':''}"/>>
							Title</option>
						<option value="content"
							<c:out value="${cri.searchType eq 'content'?'selected':''}"/>>
							Content</option>
						<option value="writer"
							<c:out value="${cri.searchType eq 'writer'?'selected':''}"/>>
							Writer</option>
								<option value="title_writer"
							<c:out value="${cri.searchType eq 'title_writer'?'selected':''}"/>>
							Title OR Writer</option>
						<option value="title_content"
							<c:out value="${cri.searchType eq 'title_content'?'selected':''}"/>>
							Title OR Content</option>
						<option value="content_writer"
							<c:out value="${cri.searchType eq 'content_writer'?'selected':''}"/>>
							Content OR Writer</option>
						<option value="title_content_writer"
							<c:out value="${cri.searchType eq 'title_content_writer'?'selected':''}"/>>
							Title OR Content OR Writer</option>	
	</select>								
	<input type="text" name='keyword' id="keywordInput"
						value='${cri.keyword }'>
					<button id='searchBtn'>Search</button>
					<button id='newBtn'>New Board</button>
<div id='tab'>					
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
		<th style="width: 40px">삭제</th>
	</tr>


<c:forEach items="${list}" var="boardVO">

	<tr>
		<td>${boardVO.bno}</td>
		<td><a href='read?bno=${boardVO.bno}'>${boardVO.title}</a></td> <!-- 읽기위해 링크로 연결 (linked to read) -->
		<td>${boardVO.writer}</td>
		<td>${boardVO.regdate}</td>
		<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
		
		<form role='form' method='post' ACTION='delete'>		
		<!-- <input type='number' value='${boardVO.bno}' />  -->
		<td><button id='del'  value='${boardVO.bno}' name='bno' title='${boardVO.bno}'>${boardVO.bno}</button></td>
		</form>		
	</tr>

</c:forEach>

</table>
</div>
 			<!-- 페이지 번호메기기  -->
			<div class="text-center">
						<ul class="pagination">
						<em>
							<c:if test="${pageMaker.prev}">
								<a href="listAll${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a>
							</c:if>
						</em>
							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<em
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="listAll${pageMaker.makeSearch(idx)}">${idx}</a>
									
								</em>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<em><a
									href="listAll${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></em>
							</c:if>

						</ul>
					</div>


<fieldset>
<legend>modify</legend>
<button onclick='document.location="register"'>insert</button>
</fieldset>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
    
    var result = '${msg}';
    
    if(result == 'SUCCESS'){
    	alert("처리가 완료되었습니다.");
    }
    
	$(document).ready(
			function() {

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "listAll"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {

					self.location = "register";

				});

			});
    </script>


