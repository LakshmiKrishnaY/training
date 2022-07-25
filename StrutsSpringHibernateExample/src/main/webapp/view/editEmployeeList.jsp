<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Struts - Spring - Hibernate Example</title>
<style>
table.list {
	border-collapse: collapse;
	width: 40%;
}

table.list, table.list td, table.list th {
	border: 1px solid gray;
	padding: 5px;
}
</style>
</head>
<body>

	<h2>Struts - Spring - Hibernate Example</h2>

	<s:form method="post" action="add">
		<table>
			<tr>
				<td><s:hidden name="employee.id"/></td>
			</tr>
			<tr>
				<td><s:textfield key="label.firstname"
						name="employee.firstname" /></td>
			</tr>
			<tr>
				<td><s:textfield key="label.lastname" name="employee.lastname" /></td>
			</tr>
			<tr>
				<td><s:textfield key="label.email" name="employee.email" /></td>
			</tr>
			<tr>
				<td><s:textfield key="label.telephone"
						name="employee.telephone" /></td>
			</tr>
			<tr>
				<td><s:submit key="label.add"></s:submit></td>
			</tr>
		</table>
	</s:form>

	<h3>Employees</h3>
	<c:if test="${!empty employees}">
		<table class="list">
			<tr>
				<th align="left">Name</th>
				<th align="left">Email</th>
				<th align="left">Telephone</th>
				<th align="left">Actions</th>
			</tr>
			<c:forEach items="${employees}" var="emp">
				<tr>
					<td>${emp.lastname},${emp.firstname}</td>
					<td>${emp.email}</td>
					<td>${emp.telephone}</td>
					<td><a href="delete/${emp.id}">delete</a>
						<a href="edit/${emp.id}">edit</a>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>