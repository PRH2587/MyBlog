<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.opensymphony.com/oscache" prefix="cache"%>

<!--------------Header--------------->
<div class="top-header">
	<div class="wrap-top zerogrid">
		<div class="row">
			<div class="top-social">
				<a href="#"><img src="${path}/resources/littleimage/wechar.png"
					title="微信" /></a> <a href="#"><img
					src="${path}/resources/littleimage/qq.png" title="QQ" /></a> <a
					href="#"><img src="${path}/resources/littleimage/google.png"
					title="google" /></a> <a href="#"><img
					src="${path}/resources/littleimage/pinterest.png" title="pinterest" /></a>
				<a href="#"><img
					src="${path}/resources/littleimage/instagram.png" title="instagram" /></a>
			</div>
			<div class="top-search">

				<form method="get" action="${pageContext.request.contextPath}/bomb/search" id="search">
					<input name="q" type="text" size="40" placeholder="Search...->Enter" />
				</form>
			</div>
		</div>
	</div>
</div>
<div class="wrap-header zerogrid">
	<div class="row">
		<div class="col-1-3">
			<div id="logo">
				<a href="#"><img src="${path}/resources/littleimage/logo.png" /></a>
			</div>
		</div>
		<div class="col-2-3">
			<nav>
				<ul class="menu">
					<li class="clock">
						<p align="center">JUMP TIME!</p>
						<div class="h shake shake-slow"></div>
						<div class="m shake shake-slow"></div>
						<div class="s shake shake-slow"></div>
					</li>
					<li><a href="${pageContext.request.contextPath}/user/gologin">欢迎${sessionScope.sessionuser.name}登陆</a></li>
					<li><a href="${pageContext.request.contextPath}/bomb/index">主页</a></li>
					<li><a href="#" class="parent">博客博文</a>
						<ul>
							<li><a href="#" class="parent">普通帖</a>
								<ul>
									<li><a href="#">普通区</a></li>
									<li><a href="#">工作区</a></li>
									<li><a href="#">灌水区</a></li>
								</ul></li>
							<li><a href="#" class="parent">经验帖</a>
								<ul>
									<li><a href="#">Java 学习之路</a></li>
									<li><a href="#">感悟</a></li>
								</ul></li>
						</ul></li>
					<li><a href="#">关于</a></li>
					<li><a href="${pageContext.request.contextPath}/bomb/contact">给博主留言</a></li>
				</ul>
			</nav>
		</div>

	</div>
</div>