<%--
  Created by IntelliJ IDEA.
  User: nicolaibjorntvedt
  Date: 11/10/2020
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Norges Roforbund</title>
    <link rel="stylesheet" type="text/css" href="style3.css">
</head>
<body>
<header id="main-header">
    <div class="container">
        <h1>Norges Roforbund</h1>
    </div>
</header>

<nav id="navbar">
    <div class="container">
        <ul>
            <li><a href="HentTestresultater.jsp">Testresultater</a></li>
            <li><a href="#">Utøvere</a></li>
        </ul>
    </div>
</nav>

<section id="showcase">

    <form action="/RoProject/parameter" method="GET">

        <p>
            År <input type="number" name="år">
        </p>
        <p>
            Uke <input type="number" name="uke">
        </p>
        <p>
            Roklasse <input type="text" name="klasse">
        </p>
        <p>
            <input type="submit" value="send">
        </p>


    </form>

</section>
<div class="container">
    <section id="main">
        <h1>Velkommen</h1>
        <p>Teskt teskt teskt</p>
    </section>
    <aside id="sidebar">
        <p>Tekst tekst teskrt</p>
    </aside>
</div>

<footer id="main-footer">
    <p>Copuritgh my website. Ingen kødder!</p>
</footer>
</body>
</html>
