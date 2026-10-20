
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>

<h2>Edit Employee Details</h2>

<form action="${pageContext.request.contextPath}/employees/update" method="post">

    <input type="hidden" name="id" value="<c:out value='${employee.id}'/>">

    <label>Name:</label><br>
    <input type="text" name="name" value="<c:out value='${employee.name}'/>" required><br><br>

    <label>Gender:</label><br>
    <select name="gender" required>
        <option value="Male" ${employee.gender == 'Male' ? 'selected' : ''}>Male</option>
        <option value="Female" ${employee.gender == 'Female' ? 'selected' : ''}>Female</option>
        <option value="Other" ${employee.gender == 'Other' ? 'selected' : ''}>Other</option>
    </select><br><br>

    <label>Designation:</label><br>
    <input type="text" name="designation" value="<c:out value='${employee.designation}'/>" required><br><br>

    <label>Salary:</label><br>
    <input type="number" name="salary" min="0" step="0.01" value="${employee.salary}" required><br><br>

    <label>City:</label><br>
    <input type="text" name="city" value="<c:out value='${employee.city}'/>" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" value="<c:out value='${employee.email}'/>" required><br><br>

    <label>Mobile No:</label><br>
    <input type="tel" name="mobileNo" pattern="[0-9]{10}"
           value="<c:out value='${employee.mobileNo}'/>" required><br><br>

    <button type="submit">Update Employee</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/employees">Back to Employee List</a>

</body>
</html>
