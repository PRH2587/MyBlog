<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="filed" tagdir="/WEB-INF/tags/files"%>


<!--------------Contact--------------->
<layout:Default pageId="Register">
	<section class="container page-single">
		<div class="wrap-container zerogrid">
			<div class="col-2-3">
				<div id="main-content" class="wrap-col">
					<article>
						<div class="art-header">
							<h2>注册界面</h2>
							<div class="line"></div>
						</div>
						<div class="art-content">
							<div id="contact_form">
								<form:form name="form1" id="ff" method="post"
									action="${pageContext.request.contextPath}/user/register" modelAttribute="userview">
									<h3>你好 !! 欢迎注册我的博客.</h3>
									<p>[Ready to use] 谢谢注册我的博客，此网站不涉及经济和私人信息，仅供交流娱乐！多提宝贵意见！</p>

									<label> <span>名称:</span> <input type="text"
										placeholder="Please enter your username" name="userinfo.name" required>
									</label>
									<label> <span>昵称:</span> <input type="text"
										placeholder="Please enter your nickname" name="userinfo.nickname"
										required>
									</label>
									<label> <span>密码:</span> <input type="text"
										placeholder="Please enter your password" name="userinfo.password"
										required>
										<input type="hidden"
										 name="userinfo.userId" value="999"
										>
									</label>
									<label> <span>选择你的图片:</span> <filed:images
											suffixName="userInfo" styleId="salt" preffixName="salt" limit="1"></filed:images>
									</label>
									<input class="sendButton" type="submit" value="注册">

								</form:form>
							</div>
						</div>
					</article>
				</div>
			</div>
			<jsp:include page="../../pages/bomb/sidebar.jsp" />
		</div>
	</section>
	<script>
	function(){
		var _salt=$("input[name='slat.[0].slat']");
		alert(_salt);
	}
	</script>
</layout:Default>