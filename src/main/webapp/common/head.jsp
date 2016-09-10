<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!-- jstl标签库引入有问题待解决 -->
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%
    	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
    						request.getServletContext().getContextPath() + "/";
    %>
 
 	<link rel="stylesheet" href='<%=basePath %>/component/index/css/style.css' type="text/css"/>
 	<link rel="stylesheet" href='<%=basePath %>/component/recommend/css/style.css' type="text/css"/>
	
	<script src='<%=basePath %>/component/easyui/jquery.min.js'></script>
	<script src='<%=basePath %>/component/jquery-validation/jquery.validate.js'></script>
	<script src='<%=basePath %>/component/jquery-validation/localization/messages_zh.js'></script>
	<script src='<%=basePath %>/component/index/js/main.js'></script>

	
