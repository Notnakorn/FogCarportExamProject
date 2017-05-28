<%-- 
    Document   : customerReviewJSP
    Created on : Apr 25, 2017, 2:14:30 PM
    Author     : Anton
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String veryHappy = new String("Img/Very_Happy_Smiley.png");
    String Happy = new String("Img/Happy_Smiley.png");
    String Sad = new String("Img/Sad_Smiley.png");
    String verySad = new String("Img/Very_Sad_Smiley.png");    
            
    List<String> smileys = new ArrayList<String>();
    smileys.add(veryHappy);
    smileys.add(Happy);
    smileys.add(Sad);
    smileys.add(verySad);
%>


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
   <style>
            ul#menu li {
            display:inline;
            }
        </style>
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
        
        <h1>Tak fordi du bestilte hos Johannes Fog - hvor tilfreds var du med dit besøg på vores side?</h1>
 
        <ul id="menu">   
            
            <li>

            <%
            int count = 0;
            for(String smiley : smileys)
                
            {
                count++;
            %>
                    <form action= "FrontController" method="GET">    
                        <input  name="smiley" id="smileyID<%=count%>" type="image" 
                                src="<%=smiley%>" 
                                width="77" 
                                height="76" 
                                alt="Smiley<%=count%>" 
                                value="<%=count%>"
                        >      
                        <input  type="hidden" name="cmd" value="customer-review" />

                    <form/>
                
            
            <%
                }
            %>
        </li>
        </ul>
        
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
