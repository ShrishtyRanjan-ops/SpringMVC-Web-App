
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Login</title>
</head>
<body>
    <h2>Login</h2>

    <p style="color: green;">${success}</p>
    <p style="color: red;">${error}</p>

    <form action="${pageContext.request.contextPath}/login"
          method="post">

        <label>Username:</label>
        <input type="text" name="username" required>
        <br><br>

        <label>Password:</label>
        <input type="password" name="password" required>
        <br><br>

        <button type="submit">Login</button>
    </form>

    <p>
        New user?
        <a href="${pageContext.request.contextPath}/register">
            Register here
        </a>
    </p>

    <p>
        <a href="${pageContext.request.contextPath}/">
            Back to Home
        </a>
    </p>
</body>
</html>
