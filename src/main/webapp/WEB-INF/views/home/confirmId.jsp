<%@page import="com.project.stuckyi.service.JoinService"%>
<%@page import="com.project.stuckyi.domain.AjaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
</head>
<body>

	<c:choose>
	<c:when test="${empty list  || fn:length(list) == 0}">
		<div style="text-align: center;">사용가능한 id입니다.</div>
	</c:when>
	<c:otherwise>
		
		<div style="text-align: center;">사용중인 id입니다.</div>
	</c:otherwise>
	</c:choose>

	
</body>
</html>