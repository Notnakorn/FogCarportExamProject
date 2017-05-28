<%-- 
    Document   : reviewDone
    Created on : 04-05-2017, 15:08:29
    Author     : Kornh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Johannes Fog</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link type="text/css" rel="stylesheet" href="CSS/FogCarportCSS.css" />
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-left" href="https://www.johannesfog.dk/"><img src="Img/logo.png"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" >
      <ul class="nav navbar-nav">
       <li><a href="http://http://207.154.197.214:8080/FogExamProjectGroup5A/index.html">Home</a></li>
        <li><a href="https://www.johannesfog.dk/byggecenter/om-fog/">About</a></li>
        <li><a href="http://http://207.154.197.214:8080/FogExamProjectGroup5A/index.jsp">Carporte</a></li>
        <li><a href="https://johannesfog.dk/byggecenter/find-butik/">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tak for besøget!</title>
    </head>
    
        <h1>Tak for din dejlige anmeldelse.</h1><br>
        <p>Fog ønsker dem en fortsat god dag!<p>
        
        <%String r = (String) request.getParameter("smiley");%>
        

    
        
        <footer class="container-fluid text-center">
    <div class="pull-left">
    Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439
</div>
<div class="pull-right">
    Alle priser er inkl. moms
</div>
</footer>
        
    </body>
</html>
