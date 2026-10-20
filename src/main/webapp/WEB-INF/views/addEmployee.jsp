
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>

<h2>Add New Employee</h2>

<p style="color:red;">${error}</p>

<form action="${pageContext.request.contextPath}/employees/add" method="post">

    <label>Name:</label><br>
    <input type="text" name="name" required><br><br>

    <label>Gender:</label><br>
    <select name="gender" required>
        <option value="">Select Gender</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
    </select><br><br>

    <label>Designation:</label><br>
    <input type="text" name="designation" required><br><br>

    <label>Salary:</label><br>
    <input type="number" name="salary" min="0" step="0.01" required><br><br>

    <label>City:</label><br>
    <input type="text" name="city" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Mobile No:</label><br>
    <input type="tel" name="mobileNo" pattern="[0-9]{10}"
           title="Enter a 10-digit mobile number" required><br><br>

    <button type="submit">Save Employee</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/employees">Back to Employee List</a>

</body>
</html>
