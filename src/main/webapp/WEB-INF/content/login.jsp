<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<body bgcolor="#F8F8F4">
	<br>
	<br>
	<br>
	<br>
	<div style="text-align: center;">
	<div style="box-sizing: border-box; display: inline-block; width:700px; background-color: #FFFFFF; border: 2px solid #0361A8; border-radius: 5px; box-shadow: 0px 0px 8px #0361A8; margin: 50px auto auto;">
	<div style="background:black; border-radius: 6px 6px 0px 0px; padding: 15px;"><span style="font-family: verdana,arial; color: #FFFFFF; font-size: 1.5em; font-weight:bold;">Log in to SLR Freight services</span></div>
	<div style="background: ; padding: 15px">
	<style type="text/css" scoped>
	td { text-align:left; font-family: verdana,arial; color: #064073; font-size: 1.20em; }
	input { border: 1px solid #CCCCCC; border-radius: 5px; color: #666666; display: inline-block; font-size: 1.00em;  padding: 5px; width: 100%; }
	input[type="button"], input[type="reset"], input[type="submit"] { height: auto; width: auto; cursor: pointer; box-shadow: 0px 0px 5px #0361A8; float: right; margin-top: 10px; }
	table.center { margin-left:auto; margin-right:auto; }
	.error { font-family: verdana,arial; color: #D41313; font-size: 1.00em; }
	</style>

<table class='center'>
<tr><td>User ID:</td><td><input type="text" name="login"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
<tr><td>&nbsp;</td><td><input type="submit" value="Log in"></td></tr>
<s:form>
		<s:textfield name="userName" label="User name"/>
		<s:textfield name="password" label="Password"/>
		<s:submit value="Log in" />
	</s:form>
<tr><td colspan=2>&nbsp;</td></tr>
<tr><td colspan=2>Forgot password?<a href><br> Click here</a>!</td></tr>
<tr><td colspan=2> <a href></a> </td></tr>
</table>
</form>
</div></div></div>
	<div>Status :<s:property value="status"/></div>
</body>
</html>