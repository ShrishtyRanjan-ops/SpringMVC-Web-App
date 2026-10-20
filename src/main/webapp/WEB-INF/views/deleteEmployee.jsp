
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Delete Employee</title>
</head>
<body>

<h2>Confirm Employee Deletion</h2>

<p>Are you sure you want to delete this employee?</p>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <td><c:out value="${employee.id}"/></td>
    </tr>
    <tr>
        <th>Name</th>
        <td><c:out value="${employee.name}"/></td>
    </tr>
    <tr>
        <th>Designation</th>
        <td><c:out value="${employee.designation}"/></td>
    </tr>
    <tr>
        <th>City</th>
        <td><c:out value="${employee.city}"/></td>
    </tr>
    <tr>
        <th>Email</th>
        <td><c:out value="${employee.email}"/></td>
    </tr>
</table>

<br>

<form action="${pageContext.request.contextPath}/employees/delete/${employee.id}"
      method="post">
    <button type="submit">Yes, Delete Employee</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/employees">Cancel</a>

</body>
</html>
