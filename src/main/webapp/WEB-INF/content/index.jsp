
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--
<meta name="viewport" content="width=device-width, initial-scale=1">
-->
<meta name="viewport" content="1000px, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Pack Track</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/index.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome-4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

</head>

<body>



	<!-- Header Carousel -->
	<header id="myCarousel" class="carousel slide"> <!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner">
		<div class="item active">
			<div class="fill" style="background-image: url('images/train1.png');">
			</div>
		</div>
		<div class="item">
			<div class="fill" style="background-image: url('images/train2.png')">
			</div>
		</div>
		<div class="item">
			<div class="fill" style="background-image: url('images/train3.png');">
			</div>
		</div>
	</div>

	<a class="left carousel-control" href="#myCarousel" data-slide="prev">

		<span class="icon-prev"> </span>
	</a> <a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="icon-next"> </span>
	</a> </header>

	<div class="container">

		<div class="row" align="center">
			<div class="col-lg-12">
				<h1 class="page-header">
					<font color="blue"> </font>
				</h1>
			</div>
			<a href=" Track Parcel"> <font size=4 color="gray"> <input
					type="image" src="images/track.png" alt="submit"
					value="<s:url action="login"/>"
					style="height: 100%; width: 20%; min-height: 90px; margin: 0 6% 0 0;">
			</font>
			</a> <a href="Calculate Transport Cost"> <font size=4 color="gray">
					<input type="image" src="images/cost.png" alt="submit"
					value="Calculate Transport cost"
					style="height: 100%; width: 20%; min-height: 90px; margin: 0 6% 0 0;">
			</font>
			</a> <a href="/PackTrack/login.action"> <font size=4 color="gray">
					<input type="image" src="images/login.png" alt="submit"
					value="Log in" style="height: 100%; width: 20%; min-height: 90px;">
			</font>
			</a>

			<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>
						<font color="blue"> Copyright &copy; Pack Track 2014 </font>
					</p>
				</div>
			</div>
			</footer>
		</div>
	</div>

	<!-- /.container -->

	<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js">
		
	</script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js">
		
	</script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000

		})
	</script>
</body>

</html>
