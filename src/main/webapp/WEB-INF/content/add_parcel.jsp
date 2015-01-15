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
<!-- <link href='css/styles.css' rel='stylesheet'> -->
<!-- <link href='css/receipt.css' rel='stylesheet'> -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script>
	function change() {
		var weight= document.getElementById("weight").value;
		var start= document.getElementById("start").value;
		var finish= document.getElementById("destination").value;
		var category= document.getElementById("categoryq").value;
		var express= document.getElementById("express").value;
		if(isNaN(parseFloat(weight))){   
			$("#cost").html("input error");
			return true;  
		} 
		if(weight===""){
			el2.html("0.0")
			return true;  
		}
		$.post("calculate-cost",
	    	    {
	    	      weight:weight,
	    	      start:start,
	    	      finish:finish,
	    	      category:category,
	    	      express:express
	    	    },
	    	    function(data){
	    	     	$("#cost").html(data.cost);
	  });
	}
</script>
</head>

<body>

	<div id="wrapper">
<input type="text" name="start" id='start' value='<s:property value="%{session.user.userDetail.station.ID}"/>' style="display:none;"/>
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
						<div id="container1" class="modal-body">
							<s:form action="add_parcel">
								<div id='form'>
									<h1 class='hedinh-tag'>Parcel</h1>
									<table class='main-table'>
										<tr>
											<td><b>Sender NIC</b><span style="color:red;"> *</span></td>
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
											<td><b>Receiver NIC</b><span style="color:red;"> *</span></td>
											<td colspan='3'>
												<table style="width: 100%">
													<s:textfield cssClass='input_class' type='text'
														name='receiverNIC' id='receiverNIC' onblur="getReceiver()"
														value="%{receiverNIC}" />
												</table>
											</td>
										</tr>
									</table>
									<table class='main-table' id='receiver'>
									</table>
									<table class='main-table'>
										<tr>
											<td><b>Start</b></td>
											<td>
												<table style="width: 100%">
													<s:property value="%{session.user.userDetail.station.name}" />
												</table>
											</td>
										</tr>
										<tr>
											<td><b>Destination</b></td>
											<td>
												<table style="width: 100%">
													<s:select cssClass='input_class' name='destination'
														id='destination' list="stationList" listValue="name"
														listKey="ID" onchange="change()"></s:select>
												</table>
											</td>
										</tr>
										<tr>
											<td><b>Category</b></td>
											<td>
												<table style="width: 100%">
													<s:select cssClass='input_class' name='category'
														id='categoryq' list="categoryList" listValue="catName"
														listKey="unitCost" onchange="change()"></s:select>
												</table>
											</td>
											<td style="padding-left: 10px;"><table
													style="width: 100%">
													<s:checkbox name='express' label="Express" id='express' onchange="change()"/>
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
	<s:set name="reciept" value="%{reciept}" />

	<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/plugins/metisMenu/metisMenu.min.js"></script>

	<script src="js/jquery.qrcode-0.10.1.min.js"></script>
	<script src="js/ff-range.js"></script>
	<script src="js/scripts.js"></script>

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
	<s:if test="%{#reciept!=null}">
		<script>
			$(document)
					.ready(
							function() {
								document.getElementById("container_1").innerHTML = document
										.getElementById("container").outerHTML;
								document.getElementById("container_2").innerHTML = document
										.getElementById("container").outerHTML;
								var divToPrint = document
										.getElementById("print");
								newWin = window.open("", 'NewWin',
										'toolbar=no,status=no');
								newWin.document.write(divToPrint.innerHTML);
								newWin.focus();
								newWin.print();
								newWin.close();
							});
		</script>
	</s:if>
	<script type="text/javascript" src="js/customer.js"></script>

	<script>
		function writeMessage() {

		}
	</script>
	<script>
		function printData() {

		}
	</script>

	<form name="parcel_form" onload="date1()" style="display: none">
		<input type='text' id='text'
			value='<s:property value="%{reciept.url}" />'></input>
	</form>

	<div id="print" style="display: none">

		<table cellpadding="3" id="printTable">
			<tbody>
				<tr>
					<td rowspan="2" width="400" height="600"
						style="border-right-style: dotted">
						<h2 align='center'>Sri Lanka Railway</h2>
						<h2 align='center'>Freight Service</h2>
						<p align='center'>
							Name :
							<s:property value="%{reciept.senderName}" />
						</p>
						<p align='center'>
							Parcel ID :
							<s:property value="%{reciept.id}" />
						</p>
						<p align='center'>
							From :
							<s:property value="%{session.user.userDetail.station.name}" />
						</p>
						<p align='center'>
							Destination :
							<s:property value="%{reciept.destination}" />
						</p>
						<p align='center' id="date"></p> <script>
							var today = new Date();
							var dd = today.getDate();
							var mm = today.getMonth() + 1; //January is 0!
							var yyyy = today.getFullYear();
							if (dd < 10) {
								dd = '0' + dd
							}
							if (mm < 10) {
								mm = '0' + mm
							}
							today = dd + ' / ' + mm + ' / ' + yyyy;
							document.getElementById("date").innerHTML = 'Date : '
									+ today;
							//document.getElementById("date").innerHTML = Date();
						</script>

						<p align='center'>
							Weight:
							<s:property value="%{reciept.weight}" />
							kg &nbsp &nbsp Fee :
							<s:property value="%{reciept.fee}" />
							LKR
						</p>
						<div id="container" align="center"></div>
					</td>
					<td width="300">
						<div id="container_1" align="center"></div>
						<p align='center'>
							Parcel ID :
							<s:property value="%{reciept.id}" />
						</p>
						<p align='center'>
							Destination :
							<s:property value="%{reciept.destination}" />
						</p>
					</td>
				</tr>
				<tr>
					<td style="border-top-style: dotted">
						<div id="container_2" align="center"></div>
						<p align='center'>
							Parcel ID :
							<s:property value="%{reciept.id}" />
						</p>
						<p align='center'>
							Destination :
							<s:property value="%{reciept.destination}" />
						</p>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="control left" style="display: none">
		<a id="banner" href="http://larsjung.de/qrcode/">jQuery.qrcode
			0.10.1</a>
		<hr />
		<label for="render">RENDER MODE</label> <select id="render">
			<option value="canvas">Canvas</option>
			<option value="image" selected="selected">Image</option>
			<option value="div">DIV</option>
		</select>
		<hr />
		<label for="size">SIZE:</label> <input id="size" type="range"
			value="200" min="100" max="1000" step="50" /> <label for="fill">FILL</label>
		<input id="fill" type="color" value="#000000" /> <label
			for="background">BACKGROUND</label> <input id="background"
			type="color" value="#ffffff" /> <label for="text">CONTENT</label>
		<!--<textarea id="text">Parcel ID: 987456</textarea>-->
		<hr />
		<label for="minversion">MIN VERSION:</label> <input id="minversion"
			type="range" value="6" min="1" max="10" step="1" /> <label
			for="eclevel">ERROR CORRECTION LEVEL</label> <select id="eclevel">
			<option value="L">L - Low (7%)</option>
			<option value="M">M - Medium (15%)</option>
			<option value="Q">Q - Quartile (25%)</option>
			<option value="H" selected="selected">H - High (30%)</option>
		</select> <label for="quiet">QUIET ZONE:</label> <input id="quiet" type="range"
			value="1" min="0" max="4" step="1" /> <label for="radius">CORNER
			RADIUS (not in Opera):</label> <input id="radius" type="range" value="0"
			min="0" max="50" step="10" />
	</div>

	<div class="control right" style="display: none">
		<label for="mode">MODE</label> <select id="mode">
			<option value="0" selected="selected">0 - Normal</option>
			<option value="1">1 - Label-Strip</option>
			<option value="2">2 - Label-Box</option>
			<option value="3">3 - Image-Strip</option>
			<option value="4">4 - Image-Box</option>
		</select>
		<hr />
		<label for="msize">SIZE:</label> <input id="msize" type="range"
			value="11" min="0" max="40" step="1" /> <label for="mposx">POS
			X:</label> <input id="mposx" type="range" value="50" min="0" max="100"
			step="1" /> <label for="mposy">POS Y:</label> <input id="mposy"
			type="range" value="50" min="0" max="100" step="1" />
		<hr />
		<label for="label">LABEL</label> <input id="label" type="text"
			value="jQuery.qrcode" /> <label for="font">FONT NAME</label> <input
			id="font" type="text" value="Ubuntu" /> <label for="fontcolor">FONT
			COLOR:</label> <input id="fontcolor" type="color" value="#ff9818" />
		<hr />
		<label for="image">IMAGE</label> <input id="image" type="file" />
	</div>


</body>

</html>
