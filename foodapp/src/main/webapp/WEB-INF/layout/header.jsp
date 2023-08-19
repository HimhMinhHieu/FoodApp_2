<%-- 
    Document   : header
    Created on : Aug 18, 2023, 1:44:38 PM
    Author     : Thao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/" var="action" />
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Food App</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Trang chu</a>
                </li>
                <c:forEach items="${catestores}" var="cs">
                    <c:url value="/" var="searchCS">
                        <c:param name="catestoreId" value="${cs.id}" /> 
                    </c:url>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="${searchCS}">${cs.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</nav>
