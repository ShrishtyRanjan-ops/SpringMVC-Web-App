
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Profile</title>
</head>
<body>

<h1>My Profile</h1>

<% if (request.getParameter("success") != null) { %>
    <p style="color: green;">Profile updated successfully!</p>
<% } %>

<p style="color: red;">${error}</p>

<form action="${pageContext.request.contextPath}/profile" method="post">

    <label>Name:</label><br>
    <input type="text" name="name" value="${user.name}" required>
    <br><br>

    <label>City:</label><br>
    <input type="text" name="city" value="${user.city}" required>
    <br><br>

    <label>Email:</label><br>
    <input type="email" name="email" value="${user.email}" required>
    <br><br>

    <label>Mobile No:</label><br>
    <input type="tel" name="mobileNo" value="${user.mobileNo}" required>
    <br><br>

    <button type="submit">Update Profile</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/welcome">Back to Home</a>

</body>
</html>
