
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>index</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">

<script src="js/respond.js"></script>

</head>



<body>
	<div>
		<div class="carousel slide" id="myCarousel">
			<div class="carousel-inner">
				<div class="item active">

					<div class="bannerImage">
						<img src="images/train1.png" alt="">
					</div>


				</div>
				<!-- /Slide1 -->

				<div class="item">

					<div class="bannerImage">
						<img src="images/train2.png" alt="">
					</div>
				</div>
				<!-- /Slide2 -->

				<div class="item">

					<div class="bannerImage">
						<img src="images/train3.png" alt="">
					</div>

				</div>
				<!-- /Slide2 -->

			</div>

			<div class="control-box">
				<a data-slide="prev" href="#myCarousel"
					class="carousel-control left"></a> <a data-slide="next"
					href="#myCarousel" class="carousel-control right"></a>
			</div>
			<!-- /.control-box -->

		</div>
	</div>


	<div class="col-md-1"></div>
	<div class='row'>
		<div class="col-lg-6">

			<div class="panel panel-default" style="margin: 25px">
				<div class="panel-heading" style="background-color: gray">
					<h3 class="text-center" style="color: navy">
						<b> Find Your Distance & Parcel Transport Cost</b>
					</h3>
				</div>
				<div class="panel-body">

					<div class="form-group">
						<div class="col-md-6">
							<label> From :</label>
							<s:select cssClass='form-control-inline' name='start' id='start'
								list="stationList" listValue="name" listKey="ID"
								onchange="change()"></s:select>
						</div>


						<div class="col-md-6">
							<label>To :</label>
							<s:select cssClass='form-control-inline' name='destination'
								id='destination' list="stationList" listValue="name"
								listKey="ID" onchange="change()"></s:select>
						</div>

					</div>
					<br>


					<div class="form-group">
						<div class="col-md-12">
							<label> Item :</label>
							<s:select cssClass='form-control-inline' name='category'
								id='categoryq' list="categoryList" listValue="catName"
								listKey="unitCost" onchange="change()"></s:select>
						</div>
					</div>
					<br>

					<div class="form-group">

						<div class="col-md-6">
							<div class="form-group input-group">
								<label> Weight :</label>

								<s:textfield cssClass='form-control-inline' type='text' name='weight'
									id='weight' onkeyup="change()" placeholder="Weight(Kg)" />
							</div>
						</div>

						<div class="col-md-6">
							<label class="checkbox-inline"> <s:checkbox
									name='express' id='express' onchange="change()" /><b>Express</b>
							</label>
						</div>
					</div>
					<br> 
					<div class="form-group">
						<div id="cost"></div>
					</div>

					<div class="form-group">
						<button class="btn btn-primary btn-md btn-block">Calculate</button>
					</div>

				</div>
			</div>
		</div>





	<div class="col-lg-4">

		<div class="panel panel-default" style="margin: 25px">

			<div class="panel-heading" style="background-color: gray">
				<h3 class="text-center" style="color: navy">
					<b> Track Parcel </b>
				</h3>
			</div>

			<div class="panel-body">

				<div class="form-group">
					<label> Enter NIC :</label> <input class="form-control-inline" id="nic">
				</div>

				<div class="form-group">
					<label> Enter Parcel ID :</label> <input class="form-control-inline"
						id="id"><br>
				</div>
				

				<div class="form-group" style="margin-bottom: 35px;">
					<div id="track-result"></div>
				</div>
				<div class="form-group">
					<button class="btn btn-primary btn-md btn-block" id="track">Submit</button>
				</div>

			</div>
		</div>
	</div>
</div>
	<div class="col-md-1"></div>

	<footer>
	<div class="row" align="center">
		<div class="col-lg-12">
			<br>
			<p>
				<font color="blue"> Copyright &copy; Pack Track 2014 </font>
			</p>
		</div>
	</div>
	</footer>

	<script src="js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<script src="js/index.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000

		})
	</script>

</body>
</html>

