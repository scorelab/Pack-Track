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

<title>Add User</title>
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
									<h1 class='hedinh-tag'>Add User</h1>
									<table class='main-table'>
										<tr>
											<td><b>Name</b> <span style="color:red;"> *</span> </td>
											<td colspan='3'>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text' name='name'
														id='name'/>
														
												
												</table>
											</td>
										</tr>
										<tr>
											<td><b>UserName</b><span style="color:red;"> *</span></td>
											<td colspan='3'>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text'
														name='userName' id='userName' />
												</table>
											</td>
										</tr>
										<tr>
											<td><b>Email</b><span style="color:red;"> *</span></td>
											<td colspan='3'>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text'
														name='email' id='email' style="*" />
												</table>
											</td>
										</tr>
										<tr>
											<td><b>NIC</b><span style="color:red;"> *</span></td>
											<td>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text' name='nic'
														id='nic' />
												</table>
											</td>
											<td style="padding: 5px;"><b>Phone</b></td>
											<td>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text'
														name='phone' id='phone' />
												</table>
												
											</td>
										</tr>
										<tr>
											<td><b>Designation</b></td>
											<td>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text'
														name='designation' id='designation' />
												</table>
											</td>
											<td style="padding: 5px;"><b>Role</b></td>
											<td>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text' name='role'
														id='role' />
												</table>
											</td>
										</tr>
										<tr>
											<td><b>Shed</b></td>
											<td>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text' name='shed'
														id='shed' />
												</table>
											</td>
											<td style="padding: 5px;"><b>Sub Dept.</b></td>
											<td>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text'
														name='sub_dept' id='sub_dept' />
												</table>
											</td>
										</tr>
										<tr>
											<td><b>Station</b></td>
											<td>
												<table style="width: 100%">
													<s:select cssClass='input_class' name='station'
														id='station' list="stationList" listValue="name+'-'+code"
														listKey="ID"></s:select>
												</table>
											</td>
										</tr>
									</table>
									<br />
									<p>
										<b>User Privileges</b>
									</p>
									<table style="margin-left: 10px;">
										<tr>
											<td><table style="width: 100%">
													<s:checkbox name="add_user" label="Add user" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='remove_user' label="Add/Remove user" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='add_train' label="Add train" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='remove_train' label=" Add/Remove train" />
												</table></td>
										</tr>
										<tr>
											<td><table style="width: 100%">
													<s:checkbox name='add_station' label=" Add station" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='remove_station'
														label=" Add/Remove station" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='add_category' label="Add category" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='remove_category'
														label="Add/Remove category" />
												</table></td>
										</tr>
										<tr>
											<td><table style="width: 100%">
													<s:checkbox name='add_device' label="Add device" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='remove_device' label="Add/Remove device" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='edit_customer' label="Edit customers" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='add_parcel' label="Add parcel" />
												</table></td>
										</tr>
										<tr>
											<td><table style="width: 100%">
													<s:checkbox name='release_parcel' label="Release parcel" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='confirm_arrival' label="Confirm arrival" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='check_upcoming'
														label="Check upcoming parcels" />
												</table></td>
											<td><table style="width: 100%">
													<s:checkbox name='select_train' label="Select train" />
												</table></td>
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
		$('#users').addClass('active');
		$('#add_user').addClass('active');
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
