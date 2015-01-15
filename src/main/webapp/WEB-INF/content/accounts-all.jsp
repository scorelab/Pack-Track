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

<title>Check Upcoming</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery-ui.min.css" rel="stylesheet">
<link href="css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="css/pt-main.css" rel="stylesheet">
<link href="css/home.css" rel="stylesheet">
<link href="css/add_user.css" rel="stylesheet">

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
					style="width: 30%; margin: 30px 30px 30px 30px; min-width: 180px;">
					<s:form action="accounts-all">
						<table>
							<tr>
								<b>Enter a year </b>
							</tr>
							<tr>

								<td>
									<table style="width: 100%">
										<s:textfield cssClass='form-control' type='text' name='year'
											id='year' />
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
			<div class='col-lg-offset-1 col-md-offset-1' style="padding-bottom: 20px;">
			<h2>Total income : Rs. <s:property escape="false" value="total"></s:property></h2>
			</div>
			</div>
			<div class='row'>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>January</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[0]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>February</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[1]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>March</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[2]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>April</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[3]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>May</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[4]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>June</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[5]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>July</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[6]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>Augast</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[7]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>September</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[8]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>October</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[9]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>November</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[10]"></s:property></h3>
						</div>
					</div>
				</div>
				<div class='col-lg-4 col-md-6'>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4>December</h4>
						</div>
						<div class="panel-body">
							<h3>Rs. <s:property escape="false" value="incomeMonth[11]"></s:property></h3>
						</div>
					</div>
				</div>
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
		$('#accounts').addClass('active');
		$('#accounts-all').addClass('active');
	</script>
</body>
</html>