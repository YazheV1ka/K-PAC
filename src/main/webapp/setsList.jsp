<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sets</title>
</head>
<body>
<h1 class="set_table">All Sets</h1>
<table class="set_table">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Creation Date</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="set" items="${set}">
        <tr>
            <td>
                <c:out value="${set.id}"/>
            </td>
            <td>
                <c:out value="${set.title}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/removeSet/${set.id}">Delete</a>
        </tr>
        <a href="${pageContext.request.contextPath}/createSet.jsp">Add</a>
    </c:forEach>
</table>

</body>
</html>