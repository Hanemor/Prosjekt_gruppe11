<%--
  Created by IntelliJ IDEA.
  User: nicolaibjorntvedt
  Date: 07/10/2020
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.testresultater.alletestresultater.alleTestresultater"%>
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
<p>Her ser man en oversikt over alle testresultater</p>
<table style="width: 100%">
    <caption>Liste over alle testresultater</caption>

    <br>


    <thead>
    <tr>
        <th>UtoverID</th>
        <th>år</th>
        <th>uke</th>
        <th>klasseID</th>
        <th>watt_60</th>
        <th>bevegelighet</th>
        <th>watt_5000_m</th>
        <th>tid_5000_m</th>
        <th>watt_2000_m</th>
        <th>tid_2000_m</th>
        <th>prosent_ligg_ro</th>
        <th>kilo_ligg_ro</th>
        <th>prosent_knebøy</th>
        <th>kilo_knebøy</th>
        <th>Cm_Sargeant</th>
        <th>sek_2000_m</th>
        <th>min_2000_m</th>
        <th>antall_Kr_hev</th>
        <th>_3000_løp</th>
    </tr>
    </thead>



    <c:forEach var = "testresultat" items = "${listTestresultater}">

        <tr>


            <td>${testresultat.uID}</td>
            <td>${testresultat.år}</td>
            <td>${testresultat.uke}</td>
            <td>${testresultat.klasseID}</td>
            <td>${testresultat.watt_60}</td>
            <td>${testresultat.bevegelighet}</td>
            <td>${testresultat.tid_5000_m}</td>
            <td>${testresultat.watt_2000_m}</td>
            <td>${testresultat.tid_2000_m}</td>
            <td>${testresultat.prosent_ligg_ro}</td>
            <td>${testresultat.kilo_ligg_ro}</td>
            <td>${testresultat.prosent_knebøy}</td>
            <td>${testresultat.kilo_knebøy}</td>
            <td>${testresultat.cm_Sargeant}</td>
            <td>${testresultat.sek_2000_m}</td>
            <td>${testresultat.min_2000_m}</td>
            <td>${testresultat.antall_Kr_hev}</td>
            <td>${testresultat._3000_løp}</td>





        </tr>



    </c:forEach>

</table>

</body>
</html>
