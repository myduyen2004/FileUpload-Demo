<%-- 
    Document   : upload
    Created on : Jun 28, 2024, 6:49:37 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "org.apache.commons.fileupload.FileItem" %>
<%@page import = "java.util.List" %>
<%@page import = "org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@page import = "java.io.File" %>
<%@page import = "org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@page import = "java.util.Collection" %>
<%@page import = "jakarta.servlet.http.Part" %>

<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="image" items="${list}">
            <img src="./${image.getUrl()}" alt="imageUpload"/>
        </c:forEach>
            ${user}
            ${email}
    </body>
</html>
