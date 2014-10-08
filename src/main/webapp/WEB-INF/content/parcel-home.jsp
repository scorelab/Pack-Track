<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Search Parcel</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery-ui.min.css" rel="stylesheet">
<link href="css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="css/pt-main.css" rel="stylesheet">
<link href="css/home.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0"> <s:action name="navbar" flush="true"
			executeResult="true" namespace="/" /> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="input-group"
					style="width: 90%; margin: 30px auto 30px auto;">
					<div class="input-group" style="width: 100%;">
						<input type="text" class="form-control" placeholder="Search"
							id="searchText">
						<div class="input-group-btn" style="width: 5%;">
							<button id="btn" class="btn btn-default" style="width: 100%;">
								<i class="glyphicon glyphicon-search"
									style="line-height: inherit;"></i>
							</button>
						</div>
					</div>
				</div>
				<div id="result">
					<table class="table table-striped" style="width: 90%;"
						align="center">
						<thead>
							<tr>
								<th style="width: 10%;">ID</th>
								<th style="width: 15%;">Start</th>
								<th style="width: 15%;">Destination</th>
								<th style="width: 15%;">Receiver NIC</th>
								<th style="width: 15%;">Sender NIC</th>
								<th style="width: 15%;">Current Station</th>
								<th style="width: 10%;">Released</th>
							</tr>
						</thead>
						<tbody class="searchable">
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/plugins/metisMenu/metisMenu.min.js"></script>

	<script src="js/pt-main.js"></script>

	<script type="text/javascript" src="js/tabs.js"></script>
	<script type="text/javascript">
		$('#parcel').addClass('active');
		$('#parcel-home').addClass('active');
	</script>
	<script type="text/javascript" src="js/parcel.js"></script>
</body>
</html>