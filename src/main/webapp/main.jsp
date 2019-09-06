<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<title>Jsp</title>

<%@ include file="/commonJsp/basicLib.jsp" %>

</head>

<body>

<%@ include file="/commonJsp/header.jsp" %>

<div class="container-fluid">
      <div class="row">
         
<div class="col-sm-3 col-md-2 sidebar">
   
   <%@ include file="/commonJsp/left.jsp" %>
   
</div>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            

<div class="blog-header">
   <h1 class="blog-title">Main</h1>
   <p class="lead blog-description">Jsp / Spring.</p>
</div>

<div class="row">

   <div class="col-sm-8 blog-main">

      <div class="blog-post">
         <h2 class="blog-post-title">과제: 게시판 만들기</h2>
         <p class="blog-post-meta">
            2019.08.28 ~ 2019.09.04
         </p>
         <br>
         <h3>기능 및 화면</h3>
		 <ul>
		 	<li>로그인 화면</li>
		 	<li>게시판 관리화면 (게시판 신규 추가, 비활성화)</li>
		 	<li>게시판의 게시글 리스트 화면(페이징 기능)</li>
		 	<li>게시판의 게시글 상세화면</li>
		 	<li>게시판의 게시글 입력화면</li>
		 	<li>게시판의 게시글 수정화면</li>
		 </ul>	

         <hr>
         
         <h3>게시판 요구사항</h3>
         <ul>
            <li>로그인한 회원만 작성, 조회, 수정, 삭제가 가능한 계층형 게시판을 작성하세요</li><br>
            <li>게시판은 데이터 모델의 변경없이 새롭게 추가, 비활성화 할 수 있어야 합니다 <br/>
				(ex : 자유게시판, 공지사항, 사내 경조사 게시판)</li><br>
            <li>게시글(최신 글이 가장 위로)에 대해 답글(계층형) 및 댓글
            	(최신 댓글이 가장 밑으로 정렬 되는 순차 댓글)이 가능 해야 합니다</li><br>
            <li>게시글 내용에는 사진을 첨부할 수 있습니다</li><br>
            <li>게시글에 첨부파일을 추가할 수 있으며 최대 5개 까지 첨부 가능합니다</li><br>
            <li>게시글은 페이징 처리 하며 페이지당 보여줄 게시글 갯수는 10개 입니다</li><br>
            <li>게시글, 댓글은 삭제 가능하나 실제 테이블에서 삭제하지 않으며 삭제 구분을 저장 합니다.<br/>
				삭제된 게시글, 댓글은 [삭제된 게시글(댓글) 입니다] 라고 표기하며 상세 조회가 되지 않도록 합니다</li><br>
            <li>게시글은 작성 당사자 에게만 삭제 버튼이 보입니다.<br/>
				(삭제 가능한 경우에만 삭제 버튼을 표시합니다.)</li><br>
			<li>페이지 내비게이션의 구성은 다음과 같습니다.<br/>
				첫 페이지 이동, 이전 페이지 이동, 페이지 내비게이션 최대 10건, 다음 페이지 이동, 마지막 페이지 이동<br/>
				( [<<][<] 1 2 3 4 5 6 7 8 9 10 [>][>>] )</li><br>	
			<li>게시물 건수에 따리 페이지 내비게이션은 10건 미만일 수 있습니다.<br/>
				(ex 게시물 건수가 35건일 때 : [<<][<] 1 2 3 4 [>][>>] )</li><br>	
			<li>페이지에 따라 첫페이지, 이전 페이지, 다음 페이지, 마지막 페이지는 비활성화 시킵니다.</li><br>	
			<li>댓글은 텍스트 500자 까지만 입력이 가능하며,<br/> 
				계층형이 아닌 작성 시간 기준 내림차순으로 리스트로 표현합니다.(사진 / 파일 첨부 없음)</li><br>	
			<li>회원 정보는 수업시간에 다룬 테이블을 사용합니다.</li><br>	
			<li>회원 정보에 대한 추가 입력 / 삭제는 없으며 테이블에 입력된 정보를 조회하여 사용하기만 합니다.<br/> 
				(신규 회원가입, 회원 수정,탈퇴 없음)</li><br>	
			<li>Service, dao layer의 메소드별 단위 테스트 코드를 포함하여 제출 합니다.</li><br>	
			<li>Ajax는 사용하지 않습니다. Form 전송 혹은 링크를 통한 페이지 이동을 통해 구현 합니다.</li><br>	
			<li>로그인 화면 : 로그인 성공후 메인 페이지 이동, 실패시 로그인 페이지로 이동</li><br>	
			<li>게시판 생성 : 게시판은 신규 생성 하고, 기존 게시판을 더이상 사용하지 않도록 설정 가능</li><br>	
			<li>게시글 리스트 : 게시글은 페이지당 10개, 게시글 클릭시 상세조회 화면 이동</li><br>	
			<li>게시글 상세조회 : 수정 버튼 클릭시 수정 화면으로 이동 /<br/> 
				삭제 버튼 클릭시 삭제후 리스트 페이지로 이동<br/> 
				답글 클릭시 신규 작성 페이지로 이동</li><br>	
			<li>게시글 수정 : 수정후 해당 글의 상세 조회 페이지로 이동</li><br>	
			<li>게시글 신규 등록 : 신규 등록 후 해당글의 상세 조회 페이지로 이동한다</li><br>	
				
         </ul>
      </div>
   </div>
   <!-- /.blog-main -->
</div>   </div>
      </div>
   </div>
</body>
</html>