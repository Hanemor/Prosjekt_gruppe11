<%--
  Created by IntelliJ IDEA.
  User: nicolaibjorntvedt
  Date: 05/10/2020
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.utover.alleutovere.Utover" %>
<%@ page import="java.util.List" %>
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
    <caption>List over alle utovere</caption>

    <br>


    <thead>
    <tr>
        <th>UtoverID</th>
        <th>Kjonn</th>
        <th>Klubb</th>
        <th>Klasse</th>
        <th>Fornavn</th>
        <th>Etternavn</th>
        <th>Fodt</th>
    </tr>
    </thead>



    <c:forEach var = "utover" items = "${listUtovere}">

        <tr>


            <td>${utover.uID}</td>
            <td>${utover.kjonnID}</td>
            <td>${utover.klubbID}</td>
            <td>${utover.klasseID}</td>
            <td>${utover.fornavn}</td>
            <td>${utover.etternavn}</td>
            <td>${utover.fodt}</td>


        </tr>



    </c:forEach>

    </table>

</body>
</html>


