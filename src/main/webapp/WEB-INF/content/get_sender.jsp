<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:set name="customer" value="%{sender}" />
<s:if test="%{#customer==null}">
	<td><b>Sender Name</b></td>
		<td>
			<table style="width: 100%">
				<s:textfield cssClass='input_class' type='text' name='receiver_name'
											id='receiver_name' />
			</table>
		</td>
		<td><b>Sender Address</b></td>
		<td>
			<table style="width: 100%">
				<s:textfield cssClass='input_class' type='text' name='receiver_address'
											id='receiver_address' />
			</table>
		</td>
		<td><b>Sender email</b></td>
		<td>
			<table style="width: 100%">
				<s:textfield cssClass='input_class' type='text' name='receiver_email'
											id='receiver_email' />
			</table>
		</td>
</s:if>
<s:else>
<tr>
<td><b>Sender Name</b></td>
<td width="72%"><s:property escape="false" value="%{sender.name}"></s:property></td>
</tr>
<tr>
<td><b>Sender Address</b></td>
<td width="72%"><s:property escape="false" value="%{sender.address}"></s:property></td>
</tr>
<tr>
<td><b>Sender E mail</b></td>
<td width="72%"><s:property escape="false" value="%{sender.email}"></s:property></td>
</tr>
<tr>
<td><b>Sender Mobile</b></td>
<td width="72%"><s:property escape="false" value="%{sender.mobile}"></s:property></td>
</tr>
<tr>
<td><b>Sender Telephone</b></td>
<td width="72%"><s:property escape="false" value="%{sender.telephone}"></s:property></td>
</tr>
</s:else>