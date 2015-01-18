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
			
			<div class="row">
				<div class="col-lg-6">
                    <div class="panel panel-default" style="margin-top:30px;">
                        <div class="panel-heading">
                            <h3 style="color:rgb(119, 119, 119)">Personnel Info</h3>
                        </div>
                        <div class="panel-body">
                            <p>
                            <b>Name : </b><s:property value="%{session.user.userDetail.name}" /></br>
                            <b>NIC : </b><s:property value="%{session.user.nicNumber}" /></br>
                            <b>Role : </b><s:property value="%{session.user.role}" /></br>
                            <b>Shed : </b><s:property value="%{session.user.shed}" /></br>
                            <b>Sub Dept. : </b><s:property value="%{session.user.subDept}" /></br>
                            <b>Email : </b><s:property value="%{session.user.userDetail.email}" /></br>
                            <b>Station : </b><s:property value="%{session.user.userDetail.station.name}" /></br>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="panel panel-default" style="margin-top:30px;">
                        <div class="panel-heading">
                            <h3 style="color:rgb(119, 119, 119)">In <s:property value="%{session.user.userDetail.station.name}" /> today</h3>
                        </div>
                        <div class="panel-body">
                            <p>
                            <font size="4">Parcels to be handled :   </font><font size="9"><s:property value="toHandle" /></font></br>
                            <font size="4">Parcels received :   </font><font size="9"><s:property value="recieved" /></font></br>
                            </p>
                        </div>
                    </div>
                </div>
			</div>
		</div>
		<s:set name="message" value="%{message}" />
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
