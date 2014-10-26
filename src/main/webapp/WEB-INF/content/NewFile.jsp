<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!DOCTYPE html>
<html class="no-js no-browser" lang="en">

<head>
<link href='styles.css' rel='stylesheet'>
<link href='receipt.css' rel='stylesheet'>
<script src="jquery-1.10.2.js"></script>
<script src="jquery.qrcode-0.10.1.min.js"></script>
<script src="ff-range.js"></script>
<script src="scripts.js"></script>

<script>
	function writeMessage() {
		document.getElementById("parcel_ID").innerHTML = "egerg";
		document.getElementById("container_1").innerHTML = document
				.getElementById("container").outerHTML;
		document.getElementById("container_2").innerHTML = document
				.getElementById("container").outerHTML;
	}
</script>
<script>
	function printData() {
		var divToPrint = document.getElementById("print");
		newWin = window.open("", 'NewWin', 'toolbar=no,status=no');
		newWin.document.write(divToPrint.innerHTML);
		newWin.focus();
		newWin.print();
		newWin.close();
	}
</script>


</head>

<body>

	<form name="parcel_form" onload="date1()">
		<p>
			<input type="text" size="20" onkeyup="writeMessage()" id='text'
				value="Enter Parcel URL Here">
		</p>
	</form>

	<div id="print">

		<table cellpadding="3" id="printTable">
			<tbody>
				<tr>
					<td rowspan="2" width="400" height="600"
						style="border-right-style: dotted">
						<h2 align='center'>Sri Lanka Railway</h2>
						<h2 align='center'>Freight Service</h2>
						<p align='center'>Name : Lahiru Rangana De Silva</p>
						<p align='center' id='parcel_ID'></p>
						<p align='center'>From : Colombo Fort</p>
						<p align='center'>Destination : Kandy</p>
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

						<p align='center'>Weight: 200kg &nbsp &nbsp Fee : 100</p>
						<div id="container" align="center"></div>
					</td>
					<td width="300">
						<div id="container_1" align="center"></div>
					</td>
				</tr>
				<tr>
					<td style="border-top-style: dotted">
						<div id="container_2" align="center"></div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<br />
	<br />

	<button onclick="printData()">Print me</button>

	<div class="control left">
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

	<div class="control right">
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
