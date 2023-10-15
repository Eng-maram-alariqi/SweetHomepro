<%-- 
    Document   : success
    Created on : Oct 13, 2023, 9:50:54 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
String message = (String) request.getAttribute("message");
if (message != null && !message.isEmpty()) {
%>
<script>
    Swal.fire({
        title: 'Success',
        text: '<%= message %>',
        icon: 'success'
    });
</script>
<%
}
%>
    </body>
</html>
