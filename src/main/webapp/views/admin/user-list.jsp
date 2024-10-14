<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<a href="<c:url value='/admin/user/add'/>">Add User</a><br>
<hr>

<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>Avatar</th>
        <th>Full Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Role</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${listUser}" var="user" varStatus="STT">
        <tr>
            <td>${STT.index + 1}</td>
            
            <c:choose>
                <c:when test="${user.images.substring(0, 5) == 'https'}">
                    <c:url value="${user.images}" var="imgUrl"/>
                </c:when>
                <c:otherwise>
                    <c:url value="/image?fname=${user.images}" var="imgUrl"/>
                </c:otherwise>
            </c:choose>
            <td><img height="100" width="100" src="${imgUrl}" alt="User Avatar" /></td>
            
            <td>${user.fullName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.roleid}</td>
            <td>
                <c:choose>
                    <c:when test="${user.roleid == 1}">
                        Admin
                    </c:when>
                    <c:otherwise>
                        User
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="<c:url value='/admin/user/edit?id=${user.id}'/>">Edit</a> |
                <a href="<c:url value='/admin/user/delete?id=${user.id}'/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
