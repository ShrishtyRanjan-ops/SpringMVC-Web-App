
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Registration</title>
</head>
<body>
    <h2>Employee Registration</h2>

    <form action="${pageContext.request.contextPath}/register"
          method="post">

        <label>Username:</label>
        <input type="text" name="username" required>
        <br><br>

        <label>Password (exactly 6 characters):</label>
        <input type="password" name="password"
               minlength="6" maxlength="6" required>
        <br><br>

        <label>Employee Number (e.g. A1234):</label>
        <input type="text" name="employeeNumber"
               pattern="[A-Za-z][0-9]{4}"
               title="Enter one alphabet followed by exactly 4 digits"
               required>
        <br><br>

        <label>Email:</label>
        <input type="email" name="email" required>
        <br><br>

        <button type="submit">Register</button>
    </form>

    <p>
        Already registered?
        <a href="${pageContext.request.contextPath}/login">Login here</a>
    </p>

    <p>
        <a href="${pageContext.request.contextPath}/">Back to Home</a>
    </p>
</body>
</html>
