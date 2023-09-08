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
                    <a class="nav-link" href="${action}">Trang chu</a>
                </li>
                <c:forEach items="${catestores}" var="cs">
                    <c:url value="/" var="searchCS">
                        <c:param name="catestoreId" value="${cs.id}" /> 
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${searchCS}">${cs.name}</a>
                    </li>
                </c:forEach>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item">
                       <a class="nav-link" href="<c:url value="/stores/request" />">Danh sách đăng ký cửa hàng</a>
                   </li>
                </c:if>
                
                <div class="me-auto">
                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name != null}">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/login" />">Đăng nhập</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </div>
            </ul>
        </div>
    </div>
</nav>
