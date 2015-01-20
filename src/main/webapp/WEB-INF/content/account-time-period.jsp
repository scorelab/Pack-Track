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

<title>Accounts-All</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="css/pt-main.css" rel="stylesheet">
<link href="css/home.css" rel="stylesheet">
<link href="css/add_user.css" rel="stylesheet">
<link href="css/morris.css" rel="stylesheet">
<link href="css/datepicker.css" rel="stylesheet">
<link href="css/morris.css" rel="stylesheet">

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
					style="width: 50%; margin: 30px 30px 30px 30px; min-width: 180px;">
					<s:form action="account-time-period">
						<table>
							<tr>
								<td><b>Select station </b></td>
								<td><b>Select start date </b></td>
								<td><b>Select end date </b></td>
							</tr>
							<tr>
								<td style="padding-right: 10px">
									<table style="width: 100%">
										<s:select cssClass='form-control' name='station'
											id='destination' list="stationList" listValue="name"
											listKey="ID"></s:select>
									</table>
								</td>
								<td style="padding-right: 10px">
									<table style="width: 100%">
										<s:textfield cssClass='form-control' name="startDate"
											id='startDate' readonly='true'
											style="background: white; cursor: text;" />
									</table>
								</td>
								<td>
									<table style="width: 100%">
										<s:textfield cssClass='form-control' name="endDate"
											id='endDate' readonly='true'
											style="background: white; cursor: text;" />
									</table>
								</td>
								<td style="padding: 5px;"><input type="submit"
									name='create' value='Go!' class="btn btn-default"></td>
							</tr>
						</table>
					</s:form>
				</div>
			</div>
			<div class='row'>
				<div class='col-lg-4 col-md-6 col-lg-offset-1 col-md-offset-1'>
					<div class="panel panel-info" id="panel">
						<div class="panel-heading">
							<h4>
								Total Income of
								<s:property escape="false" value="stName" />
								from
								<s:property escape="false" value="startDate" />
								to
								<s:property escape="false" value="endDate" />
							</h4>
						</div>
						<div class="panel-body">
							<h3>
								Rs.
								<s:property escape="false" value="income" />
							</h3>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!-- jQuery Version 1.11.0 -->
		<script src="js/jquery-1.11.0.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script src="js/plugins/metisMenu/metisMenu.min.js"></script>


		<s:if test="%{startYear==0}">
			<script type="text/javascript">
				$(document)
						.ready(
								function() {
									document.getElementById('panel').style.visibility = "hidden";
								});
			</script>
		</s:if>
		<script src="js/pt-main.js"></script>
		<script src="js/bootstrap-datepicker.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#startDate').datepicker();
				$('#endDate').datepicker();
			});
		</script>

		<script type="text/javascript" src="js/tabs.js"></script>
		<script type="text/javascript">
			$('#accounts').addClass('active');
			$('#account-time-period').addClass('active');
		</script>
</body>
</html>