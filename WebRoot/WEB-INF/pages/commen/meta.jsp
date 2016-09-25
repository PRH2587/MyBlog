<%@ page language="java" import="com.bomb.base.Constants"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
	request.setAttribute("path", path);
%>

<!-- Basic Page Needs
  ================================================== -->
<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 禁止页面缓存 -->
	    <meta http-equiv="pragram" content="no-cache">
	    <meta http-equiv="Cache-Control" content="no-cache">
	    <meta http-equiv="expires" content="0">
<title>WelcomeMyBlog</title>
<script>
	_path = "${path}";
</script>
