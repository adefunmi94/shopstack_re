<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<title>List Outlet</title>
</head>
<body>
<h3>Check ShopOutlet</h3>

<form:form action="${pageContext.request.contextPath}/outlet/process" modelAttribute="outlet" method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>Outlet Name (*) : </label></td>
						<td><form:input path="displayName" /></td>					
					</tr>
					<tr>
						<td><label>Location (*): </label></td>
						<td><form:input path="location" /></td>					
					</tr>
					<tr>
						<td><label>Phone number : </label></td>
						<td><form:input path="phone" /></td>					
					</tr>
					<tr>
						<td><label>email (*): </label></td>
						<td><form:input path="email" /><form:errors path="email" cssClass="error" /></td>					
					</tr>
					
					<tr>
						<td><label>Date : </label></td>
						<td><form:input path="dateAdded" /></td>					
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>					
					</tr>
					
					
				</tbody>
			</table>
		
		</form:form>

</body>
</html>