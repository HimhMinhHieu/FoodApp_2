<%-- 
    Document   : foods
    Created on : Aug 19, 2023, 1:14:18 AM
    Author     : Thao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/stores/${id = foods.idCuaHang.id}/foods" var="action" />
<form:form modelAttribute="foods" method="post" action="${action}" >
    <form:hidden path="id" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="name" class="form-control" id="name" placeholder="Enter name..." name="name" />
        <label for="name">Tên</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="text" path="soLuong" class="form-control" id="soLuong" placeholder="Enter Amout" name="soLuong" />
        <label for="soLuong">Số Lượng</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="text" path="price" class="form-control" id="price" placeholder="Enter Price" name="price" />
        <label for="price">Price</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:select class="form-select" id="loai" name="loai" path="idLoai">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${c.id == foods.idLoai.id}"><option value="${c.id}" selected>${c.name}</option></c:when>
                    <c:otherwise><option value="${c.id}">${c.name}</option></c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
        <label for="cate" class="form-label">Danh mục</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:select class="form-select" id="store" name="store" path="idCuaHang">
            <c:forEach items="${stores}" var="s">
                <c:choose>  
                    <c:when test="${s.id == foods.idCuaHang.id}"><option value="${s.id}" selected>${s.name}</option></c:when>
                    <c:otherwise><option value="${s.id}">${s.name}</option></c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
        <label for="store" class="form-label">Tên cửa hàng</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${foods.id != null}">Cập nhật sản phẩm</c:when>
                <c:otherwise>Thêm sản phẩm</c:otherwise>
            </c:choose>
        </button>
    </div>


</form:form>