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

<title>Add Parcel</title>
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
<script>
	function change() {
		var el1 = document.getElementById("weight");
		var el2 = document.getElementById("cost");
		el2.innerHTML = el1.value;
	}
</script>
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
							<s:form action="add_parcel">
								<div id='form'>
									<h1 class='hedinh-tag'>Parcel</h1>
									<table class='main-table'>
										<tr>
											<td><b>Sender NIC</b></td>
											<td colspan='3'>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text'
														name='senderNIC' id='senderNIC' onblur="getSender()"
														value="%{senderNIC}" />
												</table>
											</td>
										</tr>
									</table>
									<table class='main-table' id='sender'>
									</table>
									<table class='main-table'>
										<tr>
											<td><b>Receiver NIC</b></td>
											<td colspan='3'>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text'
														name='receiverNIC' id='receiverNIC' onblur="getReceiver()"
														value="%{receiverNIC}" />
												</table>
											</td>
											<td><a id='getReceiver' class='btn btn-default btn-xs'
												style='margin-left: 10px;'>get</a></td>
										</tr>
									</table>
									<table class='main-table' id='receiver'>
									</table>
									<table class='main-table'>
										<tr>
											<td><b>Start</b></td>
											<td>
												<table style="width: 100%">
													<s:select cssClass='input_class' name='start' id='start'
														list="stationList" listValue="name" listKey="ID"
														value="%{start}"></s:select>
												</table>
											</td>
										</tr>
										<tr>
											<td><b>Destination</b></td>
											<td>
												<table style="width: 100%">
													<s:select cssClass='input_class' name='destination'
														id='destination' list="stationList" listValue="name"
														listKey="ID"></s:select>
												</table>
											</td>
										</tr>
										<tr>
											<td><b>Category</b></td>
											<td>
												<table style="width: 100%">
													<s:select cssClass='input_class' name='category'
														id='category' list="categoryList" listValue="catName"
														listKey="unitCost"></s:select>
												</table>
											</td>
											<td style="padding-left: 10px;"><table
													style="width: 100%">
													<s:checkbox name='express' label="Express" />
												</table></td>
										</tr>
										<tr>
											<td><b>Weight</b></td>
											<td>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text'
														name='weight' id='weight' onkeyup="change()" />
												</table>
											</td>
										</tr>
										<tr>
											<td><b>Cost</b></td>
											<td id='cost'></td>
										</tr>
									</table>
									<br />
									<div class='wrapper'>
										<input type='submit' name='create' value='Save'>
										</td>
									</div>
									<br>
									</tr>
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
	<script type="text/javascript">
		$('#parcel').addClass('active');
		$('#add-parcel').addClass('active');
	</script>
	<s:if test="%{#message!=null}">
		<script>
			$(document).ready(function() {
				$('.error').fadeIn(400).delay(3000).fadeOut(400);
			});
		</script>
	</s:if>
	<script type="text/javascript" src="js/customer.js"></script>
</body>

</html>
