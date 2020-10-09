<%--
  Created by IntelliJ IDEA.
  User: nicolaibjorntvedt
  Date: 05/10/2020
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roproject</title>
</head>
<style>
    table, th, td{
        border: 1px solid black;
        border-collapse: collapse;
    }
    th, td{
        padding: 5px;
        text-align: center;
    }
</style>
<body>

<h2>Table caption</h2>
<p>Her ser man en oversikt over alle utøverne</p>

<table style="width: 100%">
    <caption>Liste over utøvere</caption>
    <thead>
        <tr>
            <th>UtoverID</th>
            <th>Kjonn</th>
            <th>Klubb</th>
            <th>Klasse</th>
            <th>Fornavn</th>
            <th>Etternavn</th>
            <th>Fodselsdato</th>
        </tr>
    </thead>
        <tr>
            <td>${utoverid}</td>
            <td>${kjonn}</td>
            <td>${roklubb}</td>
            <td>${roklasse}</td>
            <td>${fornavn}</td>
            <td>${etternavn}</td>
            <td>${fodt}</td>
        </tr>



</table>

</body>
</html>
