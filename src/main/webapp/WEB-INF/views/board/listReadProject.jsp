<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 관리 시스템</title>
<link rel="stylesheet" type="text/css" href="*/../resources/css/common.css"/>
<style type="text/css">	
	table{
		width: 1000px;
		margin: 0 auto;
		border: 1px solid gray;
		border-collapse: collapse;
		text-align: center;
		margin-top: 50px;		
	}
	
	th, tr, td{
		border: 1px solid gray;
		border-collapse: collapse;
	}
	
	table th{
		width: 300px;
		text-align: center;
	}
	
	table tr>td{
		padding-left: 20px;
		text-align: left;
	}
	
	section p{
		text-align: center;
		padding-top: 50px;
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#delBtn").click(function(e) {
			e.preventDefault(); //링크막기
			var result = confirm("정말 삭제하시겠습니까?");
			if(result == true){
				$("#f1").attr("action","delete"); //post형식의 delete커맨드 호출된다.
				$("#f1").submit();
			}else{
				alert("취소하였습니다.");
			}
		});		
		
		$("#modify").click(function(e){
			e.preventDefault(); //링크막기
			$("#f1").attr("action","modify");
			$("#f1").attr("method","get");
			$("#f1").submit();
		});
		

	});
</script>

</head>
<body>
	<div id="wrapper">
		<jsp:include page="../include/header.jsp"></jsp:include>
	
		<section>
			<table>		
				<tr>
					<th>프로젝트 이름</th>
					<td>${contentView.title }</td>
				</tr>		
				<tr>
					<th>프로젝트 내용</th>
					<td>${contentView.content }</td>
				</tr>		
				<tr>
					<th>프로젝트 시작 날짜</th>
					<td><fmt:formatDate value="${contentView.startDate}" pattern="yyyy-MM-dd"/></td>
				</tr>		
				<tr>
					<th>프로젝트 종료 날짜</th>
					<td><fmt:formatDate value="${contentView.endDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<th>프로젝트 상태</th>
					<td>${contentView.state }</td>
				</tr>
			</table>
			
			<form role="form" method="post" id="f1">
				<input type="hidden" name="id" value="${contentView.id }">
			</form>
	
			<p>
				<a href="#" id="modify">[수정]</a>
				<a href="delete" id="delBtn">[삭제]</a>
				<a href="listAll" id="listAll">[목록]</a>
			</p>
		</section>	
		<jsp:include page="../include/footer.jsp"></jsp:include>				
	</div>
	
</body>
</html>