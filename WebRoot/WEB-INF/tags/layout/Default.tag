<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="pageId" required="true" type="java.lang.String"%>

<!DOCTYPE html>
<head>
<jsp:include page="../../pages/commen/meta.jsp" />
<jsp:include page="../../pages/commen/resources.jsp" />
</head>
<body>
	<div id="dotmove">
		<header>
			<jsp:include page="../../pages/commen/header.jsp" />
		</header>
		<div id="<%=pageId%>">
			<jsp:doBody />
		</div>
		<footer>
			<jsp:include page="../../pages/commen/footer.jsp" />
		</footer>

	</div>
	<!-- <script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/navigation.js"></script> -->
</body>
</html>