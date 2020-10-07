<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roproject</title>
</head>
<body>
<div align="center">
    <h1>Legg til ny utøver</h1>
    <form action="/RoProject/HentUt" method="POST">
        <p>
            UtøverID <input type="number" name="uID" required />
        </p>

        <p>
            <input type="submit" value="RUN" />
        </p>
    </form>
</div>
</body>
</html>

