<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Select Train</title>
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
				<div class='error'
					style='display: none; margin: 5px auto auto auto; width: 30%; text-align: center; border: 1px solid green; color: green; background: rgb(189, 248, 189);'>
					<s:property value="message" />
				</div>
				<div class="modal-dialog" style="min-width: 450px;">
					<div class="modal-content">
						<div id="container" class="modal-body">
							<s:form action="add_user">
								<div id='form'>
									<h1 class='hedinh-tag'>Select Train</h1>
									<table class='main-table'>
										<tr>
											<td><b>Station</b></td>
											<td colspan='3'><s:property value="myStation" /></td>
										</tr>
										<tr>
											<td><b>Train</b></td>
											<td>
												<table style="width: 100%">
													<tr errorfor="train">
														<td align="center" valign="top" colspan="2"
															style="display: none;" id='errorMsg'><span
															class="errorMessage">No parcels selected</span></td>
													</tr>
													<s:select cssClass='input_class' name='train' id='train'
														list="trainList"
														listValue="train_name+'-'+train_direction+'-'+train_run"
														listKey="train_num"></s:select>
												</table>
											</td>
										</tr>
									</table>

									<div class="input-group"
										style="width: 80%; margin: 30px auto 30px auto;">
										<span class="input-group-addon">Filter</span> <input
											id="filter" type="text" class="form-control"
											placeholder="Type here...">
									</div>
									<div>
										<table class="table table-striped" style="width: 80%;"
											align="center">
											<thead>
												<tr>
													<th style="width: 10%;"></th>
													<th style="width: 25%;">ID</th>
													<th style="width: 40%;">Destination</th>
													<th style="width: 25%;">Express</th>
												</tr>
											</thead>
											<tbody class="searchable">
												<s:property escape="false" value="pList"></s:property>
											</tbody>
										</table>
									</div>
									<br />
									<div class='wrapper'>
										<input class="btn btn-default" type='button' id='select'
											value='Confirm selection'>
										</td>
									</div>
							</s:form>
						</div>
					</div>
				</div>


				<footer>
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<p>Copyright &copy; Pack Track 2014</p>
						</div>
					</div>
					<!-- /.row -->
				</div>
				</footer>
			</div>
		</div>
	</div>

	<s:set name="message" value="%{message}" />

	<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/plugins/metisMenu/metisMenu.min.js"></script>

	<script src="js/pt-main.js"></script>

	<script type="text/javascript" src="js/tabs.js"></script>
	<script type="text/javascript" src="js/select-train.js"></script>
	<script type="text/javascript">
		$('#parcel').addClass('active');
		$('#select-train').addClass('active');
	</script>
	<s:if test="%{#message!=null}">
		<script>
			$(document).ready(function() {
				$('.error').fadeIn(400).delay(3000).fadeOut(400);
			});
		</script>
	</s:if>
</body>

</html>
