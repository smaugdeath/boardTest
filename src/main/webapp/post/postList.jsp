<%@page import="kr.or.ddit.post.service.PostService"%>
<%@page import="kr.or.ddit.post.model.PostVo"%>
<%@page import="kr.or.ddit.post.service.IPostService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>

<%@ include file="/commonJsp/basicLib.jsp" %>




<script>
/* 

   $(document).ready(function(){
      //사용자 정보 클릭시 이벤트 핸들러
      $(".postTr").on("click", function(){
         console.log("postTr click");

		 var dataValue = $(this).data("boardNum");
      	 console.log("dataValue : " + dataValue);

         //input 태그에 값 설정
         $("#boardNum").val(dataValue);
         
         //form 태그이용 전송
//          $("#frm").serialize();
         console.log("serialize() :" + $("#frm").serialize());
         
         $("#frm").submit();
      });
   });
   
  */
  

	$(document).ready(function(){
		
		if("${res }"){
			alert("${res }");
		}
		
		$(".postTr").on("click", function(){
			var postNum = $(this).data("postnum");
			$("#postNum").val(postNum);
			$("#frm").submit();
		});
	});
 
</script>


</head>

<body>
<form id="frm" action="${cp }/selectPost" method="get">
   <input type="hidden" id="postNum" name="postNum"/>
   <input type="hidden" id="boardNum" name="boardNum" value="${boardNum }"/>
   <input type="hidden" id="boardNm" name="boardNm" value="${boardNm }"/>
</form>


<%@ include file="/commonJsp/header.jsp" %>




<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	
	<%@ include file="/commonJsp/left.jsp" %>

</div>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">${param.boardNm }</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>게시글 번호</th>
					<th>제 목</th>
					<th>작성자 아이디</th>
					<th>작성일시</th>
				</tr>
				
				
				<c:forEach items="${postList }" var="post">
						<c:choose>
							<c:when test="${post.delStatus=='N' }">
								<tr class="postTr" data-postNum="${post.postNum }">
							</c:when>
							<c:otherwise>
								<tr class="postTr" data-postNum="삭제">
							</c:otherwise>
						</c:choose>	

						<td>${post.postNum }</td>
						<td>
						<c:forEach begin="0" end="${(post.level-1)*2 }" var="i">
							&nbsp;
						</c:forEach>
						<c:if test="${(post.level-1)*2 != 0 }">
							└─[답글]
						</c:if>
						
						<c:choose>
							<c:when test="${post.delStatus == 'Y' }">
								삭제된 게시글입니다.
							</c:when>
							<c:otherwise>
								${post.postTitle }
							</c:otherwise>										
						</c:choose>
						</td>
						
						<td>${post.userId }</td>
						<td><fmt:formatDate value="${post.postDate}" pattern="yyyy-MM-dd" /></td>
					</tr>	
				</c:forEach>

			</table>
		</div>
		<a href="${cp }/writePost?boardNum=${boardNum}" class="btn btn-default pull-right">새글 등록</a>
                

		<div class="text-center">
			<ul class="pagination">
				
				<!--이전 페이지 가기 : 지금 있는 페이지에서 한 페이지 전으로  
                   	단 1페이지인 경우는 li 태그에 class="disabled"를 추가를 하고
                   	이동 경로는 차단
                -->
				<c:choose>
					<c:when test="${page == 1 }">
						<li class="disabled">
							<span aria-label="Previous">&laquo;</span>
					</c:when>
					<c:otherwise>
						<li>
						<a href="${cp }/postList?boardNum=${param.boardNum }&boardNm=${param.boardNm }&page=${1}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
						</li>
					</c:otherwise>
				</c:choose>
						</li>
						
				<c:choose>
					<c:when test="${page == 1 }">
						<li class="disabled">
							<span aria-label="Previous">&lt;</span>
					</c:when>
					<c:otherwise>
						<li>
						<a href="${cp }/postList?boardNum=${param.boardNum }&boardNm=${param.boardNm }&page=${page-1}" aria-label="Previous">
							<span aria-hidden="true">&lt;</span>
						</a>
						</li>
					</c:otherwise>
				</c:choose>
						</li>		
								
				<c:forEach begin="1" end="${paginationSize }" var="i">
					<c:choose>
						<c:when test="${i == page }">
							<li class=active><span>${i }</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="${cp }/postList?boardNum=${param.boardNum }&boardNm=${param.boardNm }&page=${i }">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:choose>
					<c:when test="${page == paginationSize }">
						<li class="disabled">
							<span aria-label="Previous">&gt;</span>
					</c:when>
					<c:otherwise>
						<li>
						<a href="${cp }/postList?boardNum=${param.boardNum }&boardNm=${param.boardNm }&page=${page+1}" aria-label="Next">
							<span aria-hidden="true">&gt;</span>
						</a>
						</li>
					</c:otherwise>
				</c:choose>
						</li>
								
				<c:choose>
					<c:when test="${page == paginationSize }">
						<li class="disabled">
							<span aria-label="Previous">&raquo;</span>
					</c:when>
					<c:otherwise>
						<li>
						<a href="${cp }/postList?boardNum=${param.boardNum }&boardNm=${param.boardNm }&page=${paginationSize}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
						</li>
					</c:otherwise>
				</c:choose>
						</li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
