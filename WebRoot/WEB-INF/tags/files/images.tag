<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="styleId" type="java.lang.String" required="true" %>
<%@attribute name="preffixName" type="java.lang.String" required="true" %>
<%@attribute name="suffixName" type="java.lang.String" required="true" %>
<%@attribute name="values" type="java.util.ArrayList" %>
<%@attribute name="limit" type="java.lang.Integer" required="false" %>

<c:if test="${empty limit}">
	<c:set var="limit" value="6"/>
</c:if>
<c:if test="${limit > 6}">
	<c:set var="limit" value="6"/>
</c:if>

<div class="control-group <%=styleId%> left-align">
	<c:if test="${empty values}">
		<div class="span2 divbox picbg">
			<span class="plusText">
				<span style="color: #e02222; font-size: 12px; padding-left: 2px;">*</span>
			</span>
			<img src="${pageContext.request.contextPath}/images/upload_logo.png" style="height: 170px; width: 300px;" />
			<input type="hidden" name="<%=preffixName%>.[0].<%=suffixName%>" class="requiredInput" value=""/>
		</div>
	</c:if>
	<c:if test="${!empty values}">
		<c:forEach items="${values}" var="url" varStatus="loop">
			<c:if test="${loop.index eq 0}">
				<div class="span2 divbox picbg">
					<span class="plus">+</span>
					<span class="plusText">
						<span style="color: #e02222; font-size: 12px; padding-left: 2px;">*</span>
					</span>
					<img src="${url}" style="height: 170px; width: 300px;" />
					<input type="hidden" name="<%=preffixName%>.[0].<%=suffixName%>" id="" class="requiredInput" value="url"/>
				</div>
			</c:if>
			<c:if test="${loop.index ne 0}">
				<div class="span2 divbox picbg">
					<img src="${url}" style="height: 170px; width: 300px;position: absolute;" />
					<input type="hidden" name="<%=preffixName%>.[${loop.index}].<%=suffixName%>" value="${url}" /><span class="remove "><i class="icon-minus-sign" ></i></span>
				</div>
			</c:if>
		</c:forEach>
	</c:if>
</div>
<script type="text/javascript">
$(function(){
	$(".<%=styleId%>").on('click', '.remove', function(e) {
		$(this).parent().remove();
		e.stopPropagation();
	});
	$(".<%=styleId%>").on('click','.span2',function(){
		var obj = $(this);
		imageRepositoryUpload(obj,function() {
			var isEdit = false;
			var length = $(".<%=styleId%>").find(".span2").length;
			if (!isEdit && length < ${limit}) {
				$(obj).after('<div class="span2 divbox picbg"><span class="remove hide"><i class="icon-minus-sign" ></i></span><img src="${rc.contextPath}/res/images/upload_logo.png" style="height:170px; width:300px;"/><input type="hidden" name="<%=preffixName%>\.\['+length+'\]\.<%=suffixName%>" /></div>');
			}
		});
	});
});
</script>
