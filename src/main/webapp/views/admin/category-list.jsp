<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<a href="<c:url value='/admin/category/add'/>">Add Category</a><br>
<hr>

<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>Images</th>
        <th>Category name</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${listcate}" var="cate" varStatus="STT">
        <tr>
            <td>${STT.index + 1}</td>
            <c:choose>
                <c:when test="${cate.images.substring(0, 5) == 'https'}">
                    <c:url value="${cate.images}" var="imgUrl"/>
                </c:when>
                <c:otherwise>
                    <c:url value="/image?fname=${cate.images}" var="imgUrl"/>
                </c:otherwise>
            </c:choose>
            <td><img height="150" width="200" src="${imgUrl}" /></td>
            <td>${cate.categoryname}</td>
            <td>
                <c:choose>
                    <c:when test="${cate.status == 1}">
                        Hoạt động
                    </c:when>
                    <c:otherwise>
                        Khóa
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="<c:url value='/admin/category/edit?id=${cate.categoryid}'/>">Sửa</a> |
                <a href="<c:url value='/admin/category/delete?id=${cate.categoryid}'/>">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
    