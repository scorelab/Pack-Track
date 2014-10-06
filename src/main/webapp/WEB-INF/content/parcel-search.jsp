<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table class="table table-striped" style="width: 80%;" align="center">
	<thead>
		<tr>
			<th style="width: 10%;">ID</th>
			<th style="width: 15%;">Start</th>
			<th style="width: 15%;">Destination</th>
			<th style="width: 15%;">Receiver NIC</th>
			<th style="width: 15%;">Sender NIC</th>
			<th style="width: 15%;">Current Station</th>
			<th style="width: 10%;">Released</th>
		</tr>
	</thead>
	<tbody class="searchable">

		<s:property escape="false" value="tableRows"></s:property>
	</tbody>
</table>