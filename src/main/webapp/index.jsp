<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String ctxPath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ctxPath+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%= basePath%>
	<a href="helloworld">Hello World</a>
	<a href="abc.html">abc</a>
	<a href="loginer">login</a>
	<a href="register">register</a>
	
	<a href="getSceneImgPaths">getSceneImgPaths </a>
	<h4>${sessionScope.background_images_file1 }</h4>
	<img src="${sessionScope.background_images_file1 }"  alt="" />
</body>
</html>