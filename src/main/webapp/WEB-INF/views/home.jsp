<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Application</title>
<!-- CSS StyleSheets -->
<%-- <link
	href="${pageContext.request.contextPath}/resources/static/css/lib/JQuery/all.css"
	rel="stylesheet" type="text/css" /> --%>
<!-- Scripts -->

<script
	src="${pageContext.request.contextPath}/resources/static/js/lib/angular.min.js"
	type="text/javascript"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/js/lib/angular-route.min.js"
	type="text/javascript"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/js/lib/angular-ui-router.js"
	type="text/javascript"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/js/helper/RestHelper.js"
	type="text/javascript"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/js/application/app.js"
	type="text/javascript"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/js/application/AppService.js"
	type="text/javascript"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/js/application/AppController.js"
	type="text/javascript"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/js/application/AppConfig.js"
	type="text/javascript"></script>

</head>
<body ng-app="rootApplication" ng-controller="rootController">
	<br>
	<a href="#/index" style="color: red;">Index</a>
	<br>
	<a href="#/results" style="color: red;">Results</a>
	<div>
		<ng-view></ng-view>
	</div>
</body>
</html>
