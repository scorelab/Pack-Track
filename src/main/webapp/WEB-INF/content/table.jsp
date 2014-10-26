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

<title>Table</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/home.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
				<li><a href="#">SLR Home</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="<s:url action="logout"/>">Logout</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<ul class="nav nav-tabs" role="tablist" id="myTab">
		<li class="active"><a href="#user" role="tab" data-toggle="tab">User</a></li>
		<li><a href="#SelectTrain" role="tab" data-toggle="tab">Select
				Train</a></li>
		<li><a href="#messages" role="tab" data-toggle="tab">Messages</a></li>
		<li><a href="#settings" role="tab" data-toggle="tab">Settings</a></li>
	</ul>

	<div class="tab-content">
		<div class="tab-pane active" id="user">
			<div class="input-group" style="width: 300px">
				<span class="input-group-addon">Filter</span> <input id="filter"
					type="text" class="form-control" placeholder="Type here...">
			</div>
			<table class="table table-striped" style="width: 300px"
				align="center">
				<thead>
					<tr>
						<th>Name</th>
						<th>userName</th>
						<th>Email</th>
						<th>Role</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody class="searchable">
					<tr>
						<td>kill</td>
						<td>killBill1</td>
						<td>kill@bill1</td>
						<td>bill1</td>
						<td>
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-pencil"></span> Change
							</button>
						</td>
						<td>
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-trash"></span> Change
							</button>
						</td>
					</tr>
					<tr>
						<td>Jill</td>
						<td>jillBill1</td>
						<td>jill@bill1</td>
						<td>bill1</td>
						<td>
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-pencil"></span> Change
							</button>
						</td>
						<td>
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-trash"></span> Change
							</button>
						</td>
					</tr>
					<tr>
						<td>nil</td>
						<td>jillnil</td>
						<td>jill@nil</td>
						<td>nill</td>
						<td>
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-pencil"></span> Change
							</button>
						</td>
						<td>
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-trash"></span> Change
							</button>
						</td>
					</tr>
					<tr>
						<td>sil</td>
						<td>silBill1</td>
						<td>sil@bill1</td>
						<td>sill</td>
						<td>
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-pencil"></span> Change
							</button>
						</td>
						<td>
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-trash"></span> Change
							</button>
						</td>
					</tr>
				</tbody>
			</table>


		</div>


		<div class="tab-pane" id="SelectTrain">
			<table class="table table-hover table-striped table-bordered"
				style="width: 300px" align="center">

				<tr>
					<th></th>
					<th>Train Name</th>
					<th>Train ID</th>
					<th>Start</th>
					<th>Finish</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<td><input type="radio" name="train" value=""></td>
					<td>Jill1</td>
					<td>jillBill1</td>
					<td>jill@bill1</td>
					<td>bill1</td>
					<td>
						<button type="button" class="btn btn-default btn-lg">
							<span class="glyphicon glyphicon-pencil"></span> Change
						</button>
					</td>
					<td>
						<button type="button" class="btn btn-default btn-lg">
							<span class="glyphicon glyphicon-trash"></span> Change
						</button>
					</td>

				</tr>
				<tr>
					<td><input type="radio" name="train" value=""></td>
					<td>Jill2</td>
					<td>jillBill2</td>
					<td>jill@bill2</td>
					<td>bill2</td>
					<td>
						<button type="button" class="btn btn-default btn-lg">
							<span class="glyphicon glyphicon-pencil"></span> Change
						</button>
					</td>
					<td>
						<button type="button" class="btn btn-default btn-lg">
							<span class="glyphicon glyphicon-trash"></span> Change
						</button>
					</td>

				</tr>
				<tr>
					<td><input type="radio" name="train" value=""></td>
					<td>Jill3</td>
					<td>jillBill3</td>
					<td>jill@bill3</td>
					<td>bill3</td>
					<td>
						<button type="button" class="btn btn-default btn-lg">
							<span class="glyphicon glyphicon-pencil"></span> Change
						</button>
					</td>
					<td>
						<button type="button" class="btn btn-default btn-lg">
							<span class="glyphicon glyphicon-trash"></span> Change
						</button>
					</td>

				</tr>
			</table>
		</div>
		<div class="tab-pane" id="messages">...</div>
		<div class="tab-pane" id="settings">...</div>
	</div>

	<script>
		$(function() {
			$('#myTab a:last').tab('show')
		})
	</script>
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
	<script src="js/table.js"></script>

</body>

</html>
