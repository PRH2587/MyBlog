<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="filed" tagdir="/WEB-INF/tags/files"%>

<!--------------single--------------->
<layout:Default pageId="Write">
	<section class="container page-single">
		<div class="wrap-container zerogrid">
			<div class="col-2-3">
				<div id="main-content" class="wrap-col">
					<form:form
						action="${pageContext.request.contextPath}/bomb/addWrite"
						method="post" modelAttribute="view">
						<article>
							<span>选择你的照片</span>
							<filed:images suffixName="imageFullPath" styleId="bloginfo"
								preffixName="view" limit="1"></filed:images>
							<input type="hidden" name="bloginfo.imageFullPath">
							<table width="100%">
								<td height="50px"><input type="text"
									placeholder="输入您的标题..." name="bloginfo.title" required></td>
								<tr>
								</tr>
								<tr>
									<td height="500px"><textarea name="bloginfo.content"
											placeholder="输入您的内容..." style="height: 100%;"></textarea></td>
								</tr>
							</table>
							<div class="tag">
								<span>选择标签 : </span>
								<ul>
									<li><a href="#"><font color="white">Java</font></a></li>
									<li><a href="#"><font color="white">C#</font></a></li>
									<li><a href="#"><font color="white">Python</font></a></li>
								</ul>
							</div>
						</article>
						<input class="sendButton" type="button" value="提交文章"
							onclick="saveInfo()">
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
	</section>http://localhost:8080/MyBlog/bomb/index
	<script>
		function saveInfo() {
			var _imageFullPath = $
			{
				"input [name='view.[1].imageFullPath']"
			}
			;
			alert(_imageFullPath);
			_imageFullPath.attr("name", "bloginfo.imageFullPath");
			/* document.forms[1].action = "${pageContext.request.contextPath}/bomb/addWrite"; */
			document.forms[1].submit();
		}
	</script>
</layout:Default>