<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="input-group" style="width:300px"> 
    <span class="input-group-addon">Filter</span>

    <input id="filter" type="text" class="form-control" placeholder="Type here...">
</div>
<table class="table table-striped" style="width:300px" align="center">
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
	<script src="js/jquery-1.11.0.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/table.js"></script>

</body>
</html>