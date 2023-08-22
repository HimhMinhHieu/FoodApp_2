<%-- 
    Document   : index
    Created on : Aug 17, 2023, 9:16:50 AM
    Author     : Thao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var="action" />
<section class="container">
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Loai</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${stores}" var="s">
                <c:url value="/stores/${s.id}" var="searchStore" />


                <tr>
                    <td>

                    </td>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.diaChi}</td>
                    <td>${s.idLoai}</td>
                    <td>
                        <a href="${searchStore}" class="btn btn-success" >Xem Chi Tiet</a>
                        <a href="#" class="btn btn-success" >Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!--    <table class="table table-hover">
            <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Số Lượng</th>
                    <th>Giá</th>
                    <th>Loại</th>
                    <th>Cửa hàng</th>
                </tr>
            </thead>
            <tbody>
    <c:forEach items="${foods}" var="f">
        <c:url value="/stores" var="searchStore">
            <c:param name="storeId" value="${f.id}" /> 
        </c:url>

        <tr>
            <td>

            </td>
            <td>${f.id}</td>
            <td>${f.name}</td>
            <td>${f.soLuong}</td>
            <td>${f.price}</td>
            <td>${f.idLoai}</td>
            <td>${f.idCuaHang}</td>

            <td>
                <a href="${searchStore}" class="btn btn-success" >Xem Chi Tiet</a>
                                        <button class="btn btn-danger">Xóa</button>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>-->
</section>

<script src="<c:url value="/js/main.js" />"></script>