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
		<a href="<s:url action="add-station-input"/>" class="btn btn-default btn-s"><span class='glyphicon glyphicon-plus-sign'></span> Add new station </a>
	</div>
	<div class="input-group"
		style="width: 80%; margin: 10px auto auto auto;">
		<span class="input-group-addon">Filter</span> <input id="filter"
			type="text" class="form-control" placeholder="Type here...">
	</div>
	<table class="table table-striped" style="width: 80%;" align="center">
		<thead>
			<tr>
				<th style="width: 45%;">Name</th>
				<th style="width: 15%;">Contact number</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody class="searchable">

			<s:property escape="false" value="tableRows"></s:property>
		</tbody>
	</table>


	</div>
	<script type="text/javascript" src="js/tabs.js"></script>

</body>
</html>