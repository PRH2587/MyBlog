<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="filed" tagdir="/WEB-INF/tags/files"%>

<!--------------single--------------->
<layout:Default pageId="Single">
	<section class="container page-single">
		<div class="wrap-container zerogrid">
			<div class="col-2-3">
				<div id="main-content" class="wrap-col">
					<form:form action="${pageContext.request.contextPath}/bomb/deletinfo" method="post" modelAttribute="view">
						<form:hidden path="bloginfo.id" />
						<article>
						   <filed:images suffixName="imageFullPath" styleId="bloginfo"
								preffixName="view" limit="1"/>
							<div class="art-header">
								<h2><form:input path="bloginfo.title" name="bloginfo.title"/></h2>
								<div class="info">
									由 后台管理员 在 <form:input path="bloginfo.createtime" name="bloginfo.createtime"/> 創建 
								</div>
								<div class="line"></div>
							</div>
							<div class="art-content">
								<p><form:textarea path="bloginfo.content" style="height:300px;"/></p>

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
						<input class="sendButton" type="submit" value="刪除">
						<h1><a onclick="Update()">更新</a></h1>
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
			<jsp:include page="../../pages/bomb/messages.jsp" />
		</div>
	</section>
	
	<script>
       function Update() {
    	 $("input[name='view.[0].imageFullPath']").attr("name","bloginfo.imageFullPath");
		 document.forms[1].action = "${pageContext.request.contextPath}/bomb/updateinfo";
		 document.forms[1].submit();
		}
	</script>
</layout:Default>