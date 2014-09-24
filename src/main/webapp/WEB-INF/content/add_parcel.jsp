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
<link href="css/home.css" rel="stylesheet">
<link href="css/add_user.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script>
function change(){
    var el1 = document.getElementById("weight");
    var el2 = document.getElementById("cost");
    el2.innerHTML = el1.value;
}
</script>
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Hi <s:property
					value="#session['userName']" />
			</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="<s:url action="home"/>">Home</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="<s:url action="logout"/>">Logout</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<div>
		<img src="images/home.png" class="img-responsive">
	</div>



	<div class="modal-dialog" style="min-width: 450px;">
		<div class="modal-content">
			<div id="container" class="modal-body">
				<s:form action="add_train">
					<div id='form'>
						<h1 class='hedinh-tag'>Train</h1>
						<table class='main-table'>
							<tr>
								<td><b>Sender NIC</b></td>
								<td colspan='3'>
									<table style="width: 100%">
										<s:textfield cssClass='input_class' type='text' name='senderNIC'
											id='senderNIC' />
									</table>
								</td>
								<td>
								<a id='getSender' class='btn btn-default btn-xs' style='margin-left: 10px;'>get</a>
								</td>
							</tr>
							<tr>
								<td><b>Receiver NIC</b></td>
								<td colspan='3'>
									<table style="width: 100%">
										<s:textfield cssClass='input_class' type='text' name='receiverNIC'
											id='receiverNIC' />
									</table>
								</td>
								<td>
								<a id='getReceiver' class='btn btn-default btn-xs' style='margin-left: 10px;'>get</a>
								</td>
							</tr>
							<tr id='receiver'>
							</tr>
							<tr>
								<td><b>Start</b></td>
								<td>
									<table style="width: 100%">
										<s:select cssClass='input_class' name='start' id='start'
											list="stationList" listValue="name" listKey="ID" value="%{start}"></s:select>
									</table>
								</td>
							</tr>
							<tr>
								<td><b>Destination</b></td>
								<td>
									<table style="width: 100%">
										<s:select cssClass='input_class' name='destination' id='destination'
											list="stationList" listValue="name" listKey="ID"></s:select>
									</table>
								</td>
							</tr>
							<tr>
								<td><b>Category</b></td>
								<td>
									<table style="width: 100%">
										<s:select cssClass='input_class' name='end' id='end'
											list="categoryList" listValue="catName" listKey="ID"></s:select>
									</table>
								</td>
								<td style="padding-left:10px;"><table style="width:100%"><s:checkbox name='express' label="Express"/></table></td>
							</tr>
							<tr>
								<td><b>Weight</b></td>
								<td>
									<table style="width: 100%">
										<s:textfield cssClass='input_class' type='text' name='weight'
											id='weight' onkeyup="change()"/>
									</table>
								</td>
							</tr>
							<tr>
								<td><b>Cost</b></td>
								<td id='cost' >
								</td>
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
		<!-- /.row -->
	</div>
	<!-- /.container --> </footer>

	<script src="js/jquery-1.11.0.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/home.js"></script>
	<script type="text/javascript" src="js/customer.js"></script>

</body>

</html>
