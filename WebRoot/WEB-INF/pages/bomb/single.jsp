﻿<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>

<!--------------single--------------->
<layout:Default>
	<section class="container page-single">
		<div class="wrap-container zerogrid">
			<div class="col-2-3">
				<div id="main-content" class="wrap-col">
					<form:form action="" method="post" modelAttribute="view">
						<form:hidden path="bloginfo.id" />
						<article>
							<img src=" ${view.bloginfo.imageFullPath}" />
							<div class="art-header">
								<h2>${view.bloginfo.title}</h2>
								<div class="info">
									By Admin on ${view.bloginfo.createtime} with <a href="#">01
										Commnets</a>
								</div>
								<div class="line"></div>
							</div>
							<div class="art-content">
								<p>${view.bloginfo.content}</p>

							</div>
							<div class="tag">
								<span>标签 : </span>
								<ul>
									<li><a href="#"><font color="white">Java</font></a></li>
									<li><a href="#"><font color="white">C#</font></a></li>
									<li><a href="#"><font color="white">Python</font></a></li>
								</ul>
							</div>
						</article>
						<div class="art-related">
							<span>文章评论列表：</span>
							<div class="row">
								<div class="blogr">评论用户信息</div>
								<div class="blogl">
								    <div class="blogl-up">时间状态</div>
								    <div class="blogl-down">评论内容</div>
								</div>
							</div>
						</div>
					</form:form>
					<div class="art-related">
						<span>更多博文</span>
						<div class="row">
						
						
							<div class="col-1-3">
								<div class="wrap-col">
									<a href="#"><img src="${path}/images/img02.jpg"></a> <a
										href="#"><h4>The title on the article</h4></a>
								</div>
							</div>
							
						</div>
					</div>

				</div>
			</div>
			<jsp:include page="../../pages/bomb/sidebar.jsp" />
		</div>
	</section>
</layout:Default>