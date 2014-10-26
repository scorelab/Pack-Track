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

<title>Home</title>
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
				<img src="images/home.png" class="img-responsive">
			</div>
			<div class='error'
				style='display: none; margin: 5px auto auto auto; width: 30%; text-align: center; border: 1px solid green; color: green; background: rgb(189, 248, 189);'>
				<s:property value="message" />
			</div>
			<ul class="nav nav-tabs" id="myTab">
				<%-- 				<s:property escape="false" value="tabs"></s:property> --%>
			</ul>

			<div class="tab-content">
				<div class="tab-pane active" id="home"></div>
			</div>

			<section>
			<div class="container">
				<div class="row">
					<div class="col-lg-12"></div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container --> </section>
			<s:set name="message" value="%{message}" />


			<footer>
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<p>Copyright &copy; Pack Track 2014</p>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container --> </footer>
		</div>
	</div>

	<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/plugins/metisMenu/metisMenu.min.js"></script>

	<script type="text/javascript" src="js/home.js"></script>
	<script src="js/pt-main.js"></script>

	<s:if test="%{#message!=null}">
		<script>
			$(document).ready(function() {
				$('.error').fadeIn(400).delay(3000).fadeOut(400);
			});
		</script>
	</s:if>
	<script type="text/javascript">
		$('#user_home').addClass('active');
	</script>

</body>

</html>
