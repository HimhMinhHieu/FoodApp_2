<%-- 
    Document   : stores
    Created on : Aug 19, 2023, 12:04:24 AM
    Author     : Thao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<c:url value="/stores" var="action" />--%>
<section class="container"> 
    <h1 class="text-center text-success mt-1">DANH SÁCH MENU</h1>
    <a href="<c:url value="/stores/${stores.id}/foods" />" class="btn btn-info mt-3">Thêm Menu</a>
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>ID</th>
                <th>Name</th>
                <th>Số Lượng</th>
                <th>Giá</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${foods}" var="f">
                <c:url value="/stores/${f.id}" var="searchStore">
                        <c:param name="storeId" value="${f.id}" /> 
                 </c:url>
                
                <tr>
                    <td>

                    </td>
                    <td>${f.id}</td>
                    <td>${f.name}</td>
                    <td>${f.soLuong}</td>
                    <td>${f.price}</td>
                    <td>
                        <a href="#" class="btn btn-success" >Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                    <td>
                        <a href="${searchStore}" class="btn btn-success" >Xem Chi Tiet</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
