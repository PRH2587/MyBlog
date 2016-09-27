<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag import="com.bomb.base.page.Page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="page" required="true"
	type="com.bomb.base.page.Page"%>
<%@ attribute name="isView" required="false" type="java.lang.Boolean"%>

<input type="hidden" name="page.pageNo" value="${page.pageNo}"
	id="pageNo" />
<input type="hidden" name="page.pageSize" value="${page.pageSize}" />
<c:if test="${isView == null}">
	<c:set var="_isView" value="true" />
</c:if>
<c:if test="${isView != null}">
	<c:set var="_isView" value="${isView}" />
</c:if>

<c:if test="${_isView}">
<div id="pagination" class="clearfix">
	<ul>
		<c:if test="${page.pageNo eq 1}">
			<li ><a  class="current" href="#">&laquo;</a></li>
		</c:if>
		<c:if test="${page.pageNo ne 1}">
			<li><a  class="current" href="#" onclick="page(${page.pageNo-1})">&laquo;</a></li>
		</c:if>
		<c:forEach begin="1" end="${page.totalPage}" varStatus="loop">
			<li><a  class="current" href="#" onclick="page(${loop.index})">${loop.index}</a></li>
		</c:forEach>
		<c:if test="${page.pageNo eq page.totalPage}">
			<li ><a  class="current" href="#">&raquo;</a></li>
		</c:if>
		<c:if test="${page.pageNo ne page.totalPage}">
			<li><a class="current" href="#" onclick="page(${page.pageNo+1})">&raquo;</a></li>
		</c:if>
	</ul>
	</div>
</c:if>