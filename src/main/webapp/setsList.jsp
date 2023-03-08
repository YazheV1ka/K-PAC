<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Knowledge Packages</title>
</head>
<body>
<h1 class="kpac_table">All Knowledge Packages</h1>
<table class="kpac_table">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Creation Date</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="kPac" items="${kPac}">
        <tr>
            <td>
                <c:out value="${kPac.id}"/>
            </td>
            <td>
                <c:out value="${kPac.title}"/>
            </td>
            <td>
                <c:out value="${kPac.description}"/>
            </td>
            <td>
                <c:out value="${kPac.creation_date}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/removeKPac/${kPac.id}">Delete</a>
        </tr>
        <a href="${pageContext.request.contextPath}/createkPac.jsp">Add</a>
    </c:forEach>
</table>

</body>
</html>