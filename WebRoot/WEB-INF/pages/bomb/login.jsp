<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>

<!--------------Login--------------->
<layout:Default pageId="lOGIN">
	<section class="container page-single">
		<div class="wrap-container zerogrid">
			<div class="col-2-3">
				<div id="main-content" class="wrap-col">
					<article>
						<div class="art-header">
							<h2>登陆界面</h2>
							<div class="line"></div>
						</div>
						<div class="art-content">
							<div id="contact_form">
								<label><h3 align="right">
										<a href="${pageContext.request.contextPath}/user/goregister">前往注册</a>
									</h3></label>
								<hr class="hrstyle" />
								<form:form name="form1" method="post"
									action="${pageContext.request.contextPath}/user/login" modelAttribute="userview">
									<h3>你好 !! 欢迎登陆我的博客.</h3>
									<p>[Ready to use]
										登陆我的博客可以留言，还有一些使用有趣的应用.如果有意见和建议就给我留言或联系我吧！</p>


									<label> <span>Name*:</span> <input type="text"
										placeholder="Please enter your username" name="userinfo.name" required>
									</label>
									<label> <span>Password*:</span> <input type="text"
										placeholder="Please enter your password" name="userinfo.password"
										required>
									</label>
									<input class="sendButton" type="submit" name="Submit"
										value="登陆">

								</form:form>
							</div>
						</div>
					</article>
				</div>
			</div>
			<jsp:include page="../../pages/bomb/sidebar.jsp" />
		</div>
	</section>
</layout:Default>