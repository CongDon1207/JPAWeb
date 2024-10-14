<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<form action="<c:url value='/admin/category/update'/>" method="post" enctype="multipart/form-data">
    <input type="text" name="categoryid" value="${cate.categoryid}" hidden="hidden">

    <label for="categoryname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br><br>

    <label for="images">Link images:</label><br>
    <input type="text" id="images" name="images" value="${cate.images}"><br><br>

    <c:choose>
        <c:when test="${cate.images.substring(0, 5) == 'https'}">
            <c:url value="${cate.images}" var="imgUrl"/>
        </c:when>
        <c:otherwise>
            <c:url value="/image?fname=${cate.images}" var="imgUrl"/>
        </c:otherwise>
    </c:choose>

    <img height="150" width="200" src="${imgUrl}" /><br><br>

    <label for="images1">Upload images:</label><br>
    <input type="file" id="images1" name="images1"><br><br>

    <label for="status">Status:</label><br>
    <input type="radio" id="ston" name="status" value="1" ${cate.status == 1 ? 'checked' : ''}>
    <label for="ston">Hoạt động</label><br>

    <input type="radio" id="stoff" name="status" value="0" ${cate.status != 1 ? 'checked' : ''}>
    <label for="stoff">Khóa</label><br><br>

    <input type="submit" value="Update">
</form>
