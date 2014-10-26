<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:set name="customer" value="%{receiver}" />
<s:if test="%{#customer==null}">
	<p>Customer dose not exist</p>
	<div style="width: 80%; margin: 10px auto;">
		<a href="<s:url action="add_customer-input"/>"
			class="btn btn-default btn-s"><span
			class='glyphicon glyphicon-plus-sign'></span> Add customer </a>
	</div>
</s:if>
<s:else>
	<tr>
		<td><b>Receiver Name</b></td>
		<td width="72%"><s:property escape="false"
				value="%{receiver.name}"></s:property></td>
	</tr>
	<tr>
		<td><b>Receiver Address</b></td>
		<td width="72%"><s:property escape="false"
				value="%{receiver.address}"></s:property></td>
	</tr>
	<tr>
		<td><b>Receiver E mail</b></td>
		<td width="72%"><s:property escape="false"
				value="%{receiver.email}"></s:property></td>
	</tr>
	<tr>
		<td><b>Receiver Mobile</b></td>
		<td width="72%"><s:property escape="false"
				value="%{receiver.mobile}"></s:property></td>
	</tr>
	<tr>
		<td><b>Receiver Telephone</b></td>
		<td width="72%"><s:property escape="false"
				value="%{receiver.telephone}"></s:property></td>
	</tr>
</s:else>