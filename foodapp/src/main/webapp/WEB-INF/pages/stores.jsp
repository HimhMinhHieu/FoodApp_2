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
                        <img src="${f.image}" alt="${f.image}" width="120"/>
                    </td>
                    <td>${f.id}</td>
                    <td>${f.name}</td>
                    <td>${f.soLuong}</td>
                    <td>${f.price}</td>
                    <td>
                        <c:url value="/api/stores/${stores.id}/foods/${f.id}/" var="api" />
                        <a href="<c:url value="/stores/${stores.id}/foods/${f.id}" />" class="btn btn-success" >Cập nhật</a>
                        <button class="btn btn-danger" onclick="delFood('${api}')">Xóa</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#myModal-${f.id}">
                            Xem chi tiết
                        </button>
                        <div class="modal fade" id="myModal-${f.id}">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">${stores.name}</h4>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <table class="table table-hover">
                                            <tbody>
                                                <tr>
                                                    <td>ID</td>
                                                    <td>${f.id}</td>
                                                </tr>

                                                <tr>
                                                    <td>Tên</td>
                                                    <td>${f.name}</td>
                                                </tr>
                                                <tr>
                                                    <td>Số Lượng</td>
                                                    <td>${f.soLuong}</td>
                                                </tr>
                                                <tr>
                                                    <td>Giá</td>
                                                    <td>${f.price}</td>
                                                </tr>

                                                <tr>
                                                    <td>Loại</td>
                                                    <td>${f.idLoai.name }</td> 
                                                </tr>

                                                <tr>
                                                    <td>Tên Cửa Hàng</td>
                                                    <td>${f.idCuaHang.name}</td>
                                                </tr>
                                                
                                                <tr>
                                                    <img src="${f.image}" alt="${f.image}" width="100%"/>
                                                </tr>
                                            </tbody>
                                        </table> 
                                    </div>


                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
</section>

<script src="<c:url value="/js/main.js" />"></script>