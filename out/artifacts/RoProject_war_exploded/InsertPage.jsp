<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roproject</title>
</head>
<body>
<div align="center">
    <h1>Legg til ny utøver</h1>
    <form action="/RoProject/LeggTil" method="POST">
        <p>
            UtøverID <input type="number" name="uID" required />
        </p>
        <p>
            KjønnID <input type="text" name="kjonnID" required />
        </p>
        <p>
            KlubbID<input type="text" name="klubbID" required />
        </p>
        <p>
            KlasseID <input type="text" name="klasseID" required />
        </p>
        <p>
            Fornavn <input type="text" name="fornavn" required />
        </p>
        <p>
            Etternavn <input type="text" name="etternavn" required />
        </p>
        <p>
            Fødselsdato <input type="number" name="fodt" required />
        </p>
        <p>
            <input type="submit" value="RUN" />
        </p>
    </form>
</div>
</body>
</html>
