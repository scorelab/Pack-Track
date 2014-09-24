<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:set name="customer" value="%{customer}" />
<s:if test="%{#customer==null}">
	<td><b>Name</b></td>
		<td>
			<table style="width: 100%">
				<s:textfield cssClass='input_class' type='text' name='name'
											id='name' />
			</table>
		</td>
</s:if>
<s:else>
<tr>
<td><b>Name</b></td>
<td width="72%"><s:property escape="false" value="%{customer.name}"></s:property></td>
</tr>
<tr>
<td><b>Address</b></td>
<td width="72%"><s:property escape="false" value="%{customer.address}"></s:property></td>
</tr>
<tr>
<td><b>E mail</b></td>
<td width="72%"><s:property escape="false" value="%{customer.email}"></s:property></td>
</tr>
<tr>
<td><b>Mobile</b></td>
<td width="72%"><s:property escape="false" value="%{customer.mobile}"></s:property></td>
</tr>
<tr>
<td><b>Telephone</b></td>
<td width="72%"><s:property escape="false" value="%{customer.telephone}"></s:property></td>
</tr>
</s:else>