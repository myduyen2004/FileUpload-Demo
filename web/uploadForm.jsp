<%-- 
    Document   : uploadForm
    Created on : Jun 28, 2024, 7:02:32 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            <input type="text" name="username" placeholder="Username">
            <input type="text" name="email" placeholder="Email">
            <input type="file" name="file" multiple>
            <input type="submit" value="Upload">
        </form>
    </body>
</html>
