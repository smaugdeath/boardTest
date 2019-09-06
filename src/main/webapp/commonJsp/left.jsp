<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.service.BoardService"%>
<%@page import="kr.or.ddit.board.service.IBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	IBoardService boardService = BoardService.getInstance();
	List<BoardVo> boardList = boardService.getBoardList();
	request.setAttribute("boardList", boardList);

%>

	<ul class="nav nav-sidebar">
   	  <!-- a tag: get method  -->
      <li class="active"><a href="${cp }/boardList">게시판 생성 <span class="sr-only">(current)</span></a></li>
      
      <c:forEach items="${boardList }" var="board">
      	<c:if test ="${board.useStatus == 'Y' }">
      		<li class="active"><a href="${cp }/postList?boardNum=${board.boardNum}&boardNm=${board.boardNm}">${board.boardNm} <span class="sr-only">(current)</span></a></li>
      	</c:if>
      </c:forEach>
      
   </ul>
   
   