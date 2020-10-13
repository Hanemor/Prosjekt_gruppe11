
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Roproject</title>
</head>
<body>
<div>
  <ul>
    <li><a href="HomePage3.jsp">HomePage:)</a></li>


    <li><a href="InsertPage.jsp">Insert ny utøver her</a></li>
    <li><a href="UtøverParameter.jsp">Hent ut utøver etter ID</a></li>
    <li><a href="<%=request.getContextPath()%>/alleutovere">alleutovere</a></li>
    <li><a href="alleTestresultaterServlet">Legg inn testresultater</a></li>
    <li><a href="alleTestresultaterServlet">Hent ut alle testresultater</a></li>
    <li><a href="<%=request.getContextPath()%>/test1">Test1-funksjon</a></li>
    <li><a href="<%=request.getContextPath()%>/herlig">herlig</a></li>
    <li><a href="<%=request.getContextPath()%>/fantastisk">fantastisk</a></li>
    <li><a href="<%=request.getContextPath()%>/test11">klikke her!</a></li>

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



  </ul>
</div>
</body>
</html>

