<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 80%; margin: 10px auto;">
		<s:property escape="false" value="options"></s:property>
	</div>
	<div class="input-group"
		style="width: 80%; margin: 10px auto auto auto;">
<!-- 		<form class="navbar-form"> -->
			<div class="input-group" style="width: 100%;">
				<input type="text" class="form-control" placeholder="Search">
<!-- 				<div class="input-group-btn" style="width: 5%;"> -->
					<button id="btn" style="width: 100%;">
						<i class="glyphicon glyphicon-search" style="line-height:inherit;"></i>
					</button>
<!-- 				</div> -->
			</div>
<!-- 		</form> -->
	</div>
	<div id="result"></div>
	<script type="text/javascript" src="js/tabs.js"></script>
	<script type="text/javascript" src="js/parcel.js"></script>
</body>
</html>