<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management</title>
</head>
<body>
	<h1>Users data</h1>
	<form:form action="user.do" method="POST" modelAttribute="user">
		<table>
			<tr>
				<td>Id</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="action" value="Create" />
					<input type="submit" name="action" value="Update" />
					<input type="submit" name="action" value="GetById" />
					<input type="submit" name="action" value="GetByMail" />
					<input type="submit" name="action" value="Delete" />
					<input type="submit" name="action" value="GetUsers" />
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<table border="1">
		<th>Id</th>
		<th>Name</th>
		<th>LastName</th>
		<th>Password</th>
		<th>Email</th>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.lastName}</td>
				<td>${user.password}</td>
				<td>${user.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>