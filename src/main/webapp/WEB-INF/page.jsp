<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="params" class="ru.innopolis.lesson14.Environment" scope="session"/>


<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<h1> JSP </h1>
    <c:forEach var ="item" items="${params.paramsList}">
        <tr>
            <td> <c:out value="${item.key}"/> </td>
            <td> <c:out value="${item.value}"/> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
