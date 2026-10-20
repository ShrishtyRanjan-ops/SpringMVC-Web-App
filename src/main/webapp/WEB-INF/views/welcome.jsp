
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>

    <h1>Welcome ${username}!</h1>

    <p>You have logged in successfully.</p>

    <h2>My Account</h2>

    <p>
        <a href="${pageContext.request.contextPath}/profile">
            View / Update My Profile
        </a>
    </p>

    <h2>Employee Management</h2>

    <p>
        <a href="${pageContext.request.contextPath}/employees">
            Manage Employees
        </a>
    </p>

    <p>
        <a href="${pageContext.request.contextPath}/logout">
            Logout
        </a>
    </p>

</body>
</html>
