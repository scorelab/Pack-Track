<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="index.html">SB Admin v2.0</a>
</div>
<!-- /.navbar-header -->

<ul class="nav navbar-top-links navbar-right">
	<li><a href="#">SLR Home</a></li>
	<li><a href="<s:url action="settings-input"/>">Settings</a></li>
	<li><a href="<s:url action="logout"/>">Logout</a></li>
</ul>
<!-- /.navbar-top-links -->

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<a class="navbar-brand" href="#">Hi <s:property
							value="#session['userName']" /></a>
				</div> <!-- /input-group -->
			</li>
			<li><a id="user_home" href="home">Home</a></li>
			<s:property escape="false" value="items"></s:property>
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->
</html>
