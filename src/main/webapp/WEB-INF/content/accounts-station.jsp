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
					<s:form action="accounts-station">
						<table>
							<tr>
								<td><b>Select station </b></td>
								<td><b>Select date </b></td>
							</tr>
							<tr>
								<td style="padding-right: 10px">
									<table style="width: 100%">
										<s:select cssClass='form-control' name='station'
											id='destination' list="stationList" listValue="name"
											listKey="ID"></s:select>
									</table>
								</td>
								<td>
									<table style="width: 100%">
										<s:textfield cssClass='form-control' name="date" id='date'
											readonly='true' style="background: white; cursor: text;" />
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
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>Income of day</h4>
						</div>
						<div class="panel-body">
							<h3>
								Rs.
								<s:property escape="false" value="dayIncome[2]"></s:property>
							</h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>Income of month</h4>
						</div>
						<div class="panel-body">
							<h3>
								Rs.
								<s:property escape="false" value="dayIncome[1]"></s:property>
							</h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>Income of year</h4>
						</div>
						<div class="panel-body">
							<h3>
								Rs.
								<s:property escape="false" value="dayIncome[0]"></s:property>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="row" id='graph'>
				<div col-lg-12>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3>
								Income Chart of
								<s:property value="stName" />
								for year
								<s:property value="year" />
							</h3>
						</div>
						<div class="panel-body">
							<div id="morris-line-chart"></div>
						</div>
					</div>
					<!-- /.panel -->
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

	<!-- Morris Charts JavaScript -->
	<script src="js/raphael-min.js"></script>
	<script src="js/morris.min.js"></script>
	<script type="text/javascript">
		new Morris.Line({
			element : 'morris-line-chart',
			data : [ {
				month : 'Jan',
				value : <s:property escape="false" value="incomeMonth[0]"/>
			}, {
				month : 'Feb',
				value : <s:property escape="false" value="incomeMonth[1]"/>
			}, {
				month : 'Mar',
				value : <s:property escape="false" value="incomeMonth[2]"/>
			}, {
				month : 'Apr',
				value : <s:property escape="false" value="incomeMonth[3]"/>
			}, {
				month : 'May',
				value : <s:property escape="false" value="incomeMonth[4]"/>
			}, {
				month : 'Jun',
				value : <s:property escape="false" value="incomeMonth[5]"/>
			}, {
				month : 'Jul',
				value : <s:property escape="false" value="incomeMonth[6]"/>
			}, {
				month : 'Aug',
				value : <s:property escape="false" value="incomeMonth[7]"/>
			}, {
				month : 'Sep',
				value : <s:property escape="false" value="incomeMonth[8]"/>
			}, {
				month : 'Oct',
				value : <s:property escape="false" value="incomeMonth[9]"/>
			}, {
				month : 'Nov',
				value : <s:property escape="false" value="incomeMonth[10]"/>
			}, {
				month : 'Dec',
				value : <s:property escape="false" value="incomeMonth[11]"/>
			}, ],
			parseTime : false,
			xkey : 'month',
			resize : true,
			ykeys : [ 'value' ],
			labels : [ 'Value' ],
			xLabelAngle : 35,
		});
	</script>
	<s:if test="%{year==0}">
	<script type="text/javascript">
	$(document).ready(
	function (){
		document.getElementById('graph').style.visibility = "hidden";
	});
	</script>
	</s:if>
	<script src="js/pt-main.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#date').datepicker();
		});
	</script>

	<script type="text/javascript" src="js/tabs.js"></script>
	<script type="text/javascript">
		$('#accounts').addClass('active');
		$('#accounts-station').addClass('active');
	</script>
</body>
</html>