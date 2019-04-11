<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="./bootstrap/bootstrap.js"></script>
<link rel="stylesheet" href="./bootstrap/bootstrap.css">
<link rel="stylesheet" href="./bootstrap/bootstrap-theme.css">
<link rel="stylesheet" href="./css/paging.css">
<script type="text/javascript" src="./js/paging.js"></script>
</head>
<body>
	<div class="container">
		<div id="select">
		<span>
			<select class="btn btn-primary" id="listCount" name="listCount" onchange="listCnt()">
				<option>선택</option>
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
			</select>
		</span>
		</div>
	
		<form action="./paging.do" method="post" id="formPaging">
			<table class="table table-bordered">
				<tr>
					<th>제목</th><th>작성일</th>
				</tr>
				<c:forEach var="dto" items="${lists}">
					<tr>
						<td>${dto.title}</td>
						<td>${dto.regdate}</td>
					</tr>
				</c:forEach>
			</table> 
		<!--  페이징 처리  -->
		${paging}
		<!-- 출력할 페이지 번호, 출력할 페이지 시작번호, 출력할 리스트 개수 -->
		<input type="hidden" name="index" id="index" value="${paging.index}">
		<input type="hidden" name="pageStartNum" id="pageStartNum" value="${paging.pageStartNum}">
		<input type="hidden" name="listCnt" id="listCnt" value="${paging.listCnt}">
	
		<div class="center">
			<ul class="pagination">
				<!-- 맨 첫 페이지 이동 -->
				<li><a href="#" onclick="pagePre(${paging.pageCnt+1},${paging.pageCnt})">&laquo;</a></li>
				<!-- 이전 페이지 이동 -->
				<li><a href="#" onclick="pagePre(${paging.pageStartNum},${paging.pageCnt})">&lsaquo;</a></li>
				
				<!-- 페이지 번호 -->
				<c:forEach var="i" begin="${paging.pageStartNum}" end="${paging.pageLastNum}" step="1">
					<li><a href="#" onclick="pageIndex(${i})">${i}</a></li>
				</c:forEach>
				
				<!-- 다음 페이지 이동 -->
				<li><a href="#" onclick="pageNext(${paging.pageStartNum},${paging.total},${paging.listCnt},${paging.pageCnt})">&rsaquo;</a></li>
				<!-- 마지막 페이지 이동 -->
				<li><a href="#" onclick="pageLast(${paging.pageStartNum},${paging.total},${paging.listCnt},${paging.pageCnt})">&raquo;</a></li>
			
			</ul>
		
		</div>
		
		
		<!-- 기타 기능 -->
		<div><a href="./remove.do">모두삭제</a></div>
		<div><a href="./list.do?num=1">리스트 1개 추가</a></div>
		<div><a href="./list.do?num=3">리스트 3개 추가</a></div>
		<div><a href="./list.do?num=5">리스트 5개 추가</a></div>
		<div><a href="./list.do?num=10">리스트 10개 추가</a></div>
		<div><a href="./list.do?num=50">리스트 50개 추가</a></div>
		
		</form>
	
		
	
	</div>

</body>
</html>
