<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>



<layout:Default>
	<!--------------Index--------------->
	<section class="container page-home">
		<div id="main-content" class="wrap-container zerogrid">
			<form:form action="${pageContext.request.contextPath}/bomb/update"
				method="post" modelAttribute="view">
				<input type="hidden" name="bloginfo.id" id="Blogid" />
				<c:if test="${!empty view.list}">
					<c:forEach items="${view.list}" var="list" varStatus="loop">
						<article>
							<div class="col-1-2 right">
								<input type="hidden" value="${list.id}"
									name="list[${loop.index}].id"> <img
									src="${list.imageFullPath}" />
							</div>
							<div class="col-1-2 left">
								<a class="art-category left" href="#">Design</a>
								<div class="clear"></div>
								<div class="art-content">
									<h2>${list.title}</h2>
									<div class="info">
										By 用户名 on ${list.createtime}<a href="#">-->评论</a>
									</div>
									<div class="line"></div>
									<p class="contect">${list.content}</p>
									<a href="#" class="more" onclick="getId('${list.id}')">Read
										More</a>
								</div>
							</div>
						</article>
					</c:forEach>
				</c:if>
				<c:if test="${empty view.list}">
					<article>
						<div class="col-1-2 right">
							<img src="images/img01.jpg" />
						</div>
						<div class="col-1-2 left">
							<a class="art-category left" href="#">Design</a>
							<div class="clear"></div>
							<div class="art-content">
								<h2>没有文章或者页面显示错误！</h2>
								<div class="info">页面显示错误</div>
								<div class="line"></div>
								<p>页面显示错误</p>

							</div>
						</div>
					</article>
				</c:if>
			</form:form>
		</div>

		<div id="pagination" class="clearfix">
			<ul>
				<li><a class="current" href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">next</a></li>
			</ul>
		</div>

	</section>
	<script>
		function getId(blogId) {
			document.forms[1].action = "${pageContext.request.contextPath}/bomb/single";
			document.forms[1].Blogid.value = blogId;
			document.forms[1].submit();
		}
	</script>
</layout:Default>