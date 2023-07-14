<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false" %>
<html>
<header>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</header>
<body>
<c:set var="factorial" value="1"/>
<table>
    <tr>
        <th>Number</th>
        <th>Factorial</th>
    </tr>
    <c:forEach begin="0" end="10" var="current">
        <c:if test="${current >= 0}">
            <c:if test="${current != 0}">
                <c:set var="factorial" value="${factorial * current}"/>
            </c:if>

            <tr>
                <td>${current}</td>
                <td>${factorial}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
