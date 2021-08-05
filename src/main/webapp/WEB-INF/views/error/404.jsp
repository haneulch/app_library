<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PASS&GO</title>
</head>
<body>
	<h1>
		404 에러 발생
	</h1>

	<div>
		<h2># 에러메시지</h2>
		<p>- URI : <c:out value="${requestScope['javax.servlet.error.request_uri']}" /></p>
		<p>- STATUS_CODE : <c:out value="${requestScope['javax.servlet.error.status_code']}" /></p>
		<p>- SERVLET_NAME : <c:out value="${requestScope['javax.servlet.error.servlet_name']}" /></p>
		<p>- EXCEPTION_TYPE : <c:out value="${requestScope['javax.servlet.error.exception_type']}" /></p>
		<p>- EXCEPTION : <c:out value="${requestScope['javax.servlet.error.exception']}" /></p>
		<p>- MESSAGE : <c:out value="${requestScope['javax.servlet.error.message']}" /></p>
		<p>- TRACE : <c:out value="${requestScope['javax.servlet.error.trace']}" /></p>
	</div>

	<h1>
		다국어처리
	</h1>

	<div>
		<p>CODE : "framework.name"</p>
		<p><spring:message code="framework.name" text="default text" /></p>
	</div>

</body>
</html>