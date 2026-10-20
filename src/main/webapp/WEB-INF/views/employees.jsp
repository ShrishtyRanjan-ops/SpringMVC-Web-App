
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background: #eeeeee; }
        a, button { margin-right: 8px; }
        .error { color: red; }
    </style>
</head>
<body>

<h2>Employee Management</h2>

<p>
    <a href="${pageContext.request.contextPath}/employees/add">Add Employee</a> |
    <a href="${pageContext.request.contextPath}/welcome">Back to Home</a>
</p>

<form action="${pageContext.request.contextPath}/employees/search" method="get">
    <label>Search Employee by ID:</label>
    <input type="number" name="id" min="1" required>
    <button type="submit">Search</button>
    <a href="${pageContext.request.contextPath}/employees">Show All</a>
</form>

<c:if test="${not empty error}">
    <p class="error"><c:out value="${error}"/></p>
</c:if>

<c:if test="${searched}">
    <h3>Search Result</h3>
    <c:choose>
        <c:when test="${not empty employee}">
            <p>
                ID: <c:out value="${employee.id}"/> |
                Name: <c:out value="${employee.name}"/> |
                City: <c:out value="${employee.city}"/>
            </p>
            <a href="${pageContext.request.contextPath}/employees/edit/${employee.id}">Edit</a>
            <a href="${pageContext.request.contextPath}/employees/delete/${employee.id}">Delete</a>
        </c:when>
        <c:otherwise>
            <p>No employee found with this ID.</p>
        </c:otherwise>
    </c:choose>
</c:if>

<c:if test="${not searched}">
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>ID</th>
            <th>Gender</th>
            <th>Designation</th>
            <th>Salary</th>
            <th>City</th>
            <th>Email Id</th>
            <th>Mobile No</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${employees}">
            <tr>
                <td><c:out value="${e.name}"/></td>
                <td><c:out value="${e.id}"/></td>
                <td><c:out value="${e.gender}"/></td>
                <td><c:out value="${e.designation}"/></td>
                <td><c:out value="${e.salary}"/></td>
                <td><c:out value="${e.city}"/></td>
                <td><c:out value="${e.email}"/></td>
                <td><c:out value="${e.mobileNo}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees/edit/${e.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/employees/delete/${e.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>
