<%-- 
    Document   : index
    Created on : Aug 17, 2023, 9:16:50 AM
    Author     : Thao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
            <c:forEach items="${stores}" var="s">
                <li>${s.id} - ${s.name} - ${s.diaChi}</li>
            </c:forEach>
        </ul>
    </body>
</html>
