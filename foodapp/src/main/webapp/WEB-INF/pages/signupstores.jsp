<%-- 
    Document   : signupstores
    Created on : Sep 7, 2023, 5:43:03 AM
    Author     : Thao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<c:url value="/stores" var="action" />--%>
<section class="container"> 
    <h1 class="text-center text-success mt-1">DANH SÁCH ĐĂNG KÝ CỬA HÀNG</h1>
    
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Hình Ảnh</th>
                <th>ID User</th>
                <th>Tên User</th>
                <th>Tên Cửa Hàng</th>
                <th>Địa Chỉ</th>
                <th>Loại Cửa Hàng</th>
                <th>Ngày Đăng Ký</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${req}" var="r">
                <tr>
                    <td>
                        <img src="${r.image}" alt="${r.image}" width="120"/>
                    </td>
                    <td>${r.idNguoiDung.id}</td>
                    <td>${r.idNguoiDung.taiKhoan}</td>
                    <td>${r.name}</td>
                    <td>${r.diaChi}</td>
                    <td>${r.idLoaiCuaHang.name}</td>
                    <td>${r.createdDate}</td>
                    <td>
                        <c:url value="/api/stores/request/${r.id}/" var="api" />
                        <button class="btn btn-success" onclick="addStore('${api}')">Duyệt</button>
                        <button class="btn btn-danger" onclick="delReq('${api}')">Từ chối</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
</section>

<script src="<c:url value="/js/main.js" />"></script>