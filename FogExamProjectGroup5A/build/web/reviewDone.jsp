<%-- 
    Document   : reviewDone
    Created on : 04-05-2017, 15:08:29
    Author     : Kornh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tak for besøget!</title>
    </head>
    <body>
        <h1>Tak for din dejlige anmeldelse. Fog ønsker dem en fortsat god dag!</h1>
        
        <%String r = (String) request.getParameter("smiley");%>
        
        <p> Du gav os følgende anmeldelse: <%=r%> </p>
    
    </body>
</html>
