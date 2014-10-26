<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Pack Track login</title>
<meta name="generator" content="Bootply">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link href="css/login.css" rel="stylesheet">
</head>
<body>
	<!--login modal-->
	<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">

					<h1 class="text-center">Reset password</h1>
				</div>
				<div class="modal-body">
					<form class="form col-md-12 center-block" action="forgot-password"
						method="post">
						<div class="form-group">
							<s:textfield cssClass="form-control input-lg"
								placeholder="Email Address" name="email" />
						</div>
						<div class="form-group">
							<br />
							<button class="btn btn-primary btn-lg btn-block">Reset
								password</button>

						</div>
					</form>
				</div>
				<div class="modal-footer">
					<div class="col-md-12"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.11.0.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript"></script>

</body>
</html>