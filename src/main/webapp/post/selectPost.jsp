<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/commonJsp/basicLib.jsp"%>

<style>
	ol{
		list-style : none;
	}
</style>

<script>
	$(document).ready(function(){
		$(".delCmt").on("click", function(){
			var cmtNum = $(this).prev().data("cmtnum");
			
			$("#cmtNum").val(cmtNum);

			$("#hiddenFrm").submit();
		});
	});
</script>

</head>
<body>
<% 
	HttpSession session1 = request.getSession();
	User user = (User) session1.getAttribute("S_USERVO");
	
	request.setAttribute("user", user);
%>

<form action="${cp }/deleteCmt" method="post" id="hiddenFrm">
	<input type="hidden" id="cmtNum" name="cmtNum" />
	<input type="hidden" id="boardNum" name="boardNum" value="${boardNum }" />
	<input type="hidden" id="postNum" name="postNum" value="${pvo.postNum }" />
</form>

	<!-- header -->
	<%@ include file="/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">

				<%@ include file="/commonJsp/left.jsp"%>

			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2 class="sub-header">${boardNm }</h2>
				<form id="frm" class="form-horizontal" role="form" action="${cp }/modifyPost"
					method="get" enctype="multipart/form-data">

					<div class="form-group">
						<input type="hidden" name="boardNum" value="${boardNum }"/>
						<input type="hidden" name="parentPostNum" value="${pvo.postNum }"/>
						<input type="hidden" name="gn" value="${pvo.gn }"/>
						<input type="hidden" name="postTitle" value="${pvo.postTitle }"/>
						<input type="hidden" name="userId" value="${pvo.userId }"/>
						
						<label for="postTitle" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-6">
	                    	<label class="control-label">${pvo.postTitle } </label>
						</div>
					</div>

					<div class="form-group">
						<label for="postContent" class="col-sm-2 control-label">글 내용</label>
						<div class="col-sm-8">
							<label>${pvo.postContent } </label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="attachedFile" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-6">
							<c:forEach items="${atfList }" var="atf">
								<label class="control-label"> <a href="${cp }/fileDownload?atfNum=${atf.atfNum}" download="${atf.atfNm }">${atf.atfNm }</a> </label><br>
							</c:forEach>
						</div>
					</div>
					<div class="form-group">
						<label for="attachedFile" class="col-sm-2 control-label"></label>
						<div class="col-sm-6">
							<c:if test="${user.userId == pvo.userId}">
								<input type="submit" class="btn btn-default" id="btnUpdqtePost" name="btnValue" value="수정"/>
								<input type="submit" class="btn btn-default" id="btnDelPost" name="btnValue" value="삭제"/>
							</c:if>
								<input type="submit" class="btn btn-default" id="btnAnsPost" name="btnValue" value="답글"/>
						</div>
						</div>
		
				</form>
					
				<form id="cmtFrm" class="form-horizontal" role="form" action="${cp }/insertCmt"
					method="post">
					<div class="form-group">
						<label class="col-sm-2 control-label">댓글</label>
						<div class="col-sm-6">
							<c:forEach items="${cmtList }" var="cmt">
								<span data-cmtNum="${cmt.cmtNum }">
								<c:choose>
									<c:when test="${cmt.delStatus == 'Y' }">
										삭제된 댓글입니다.
									</c:when>
									<c:otherwise>
										${cmt.cmtContent }
									</c:otherwise>
								</c:choose>
								&nbsp;&nbsp;&nbsp;[  ${cmt.userId } / <fmt:formatDate value="${cmt.cmtDate}" pattern="yyyy-MM-dd" />  ]</span>&nbsp;
								
								<c:if test="${user.userId == cmt.userId && cmt.delStatus=='N'}">
									<input id="deleteCmt" type="button" class="btn btn-default delCmt" value="삭제"/>
								</c:if>
								
								<br>
							</c:forEach>
						</div>
					</div>
				
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="col-sm-6">
								<input type="hidden" name="cmtPostNum" value="${pvo.postNum }"/>
								<input type="text" class="form-control" id="cmtContent" name="cmtContent"/>
							</div>
							<div class="col-sm-2">
								<input type="submit" class="btn btn-default" value="댓글저장"/>
							</div>
						</div>
					</div>
				</form>
					

			</div>
		</div>
	</div>
</body>
</html>