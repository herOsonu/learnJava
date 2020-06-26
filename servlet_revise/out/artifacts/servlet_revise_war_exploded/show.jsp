<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2020/6/25
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>nihao</h1>
<table align="center" width="60%">
    <tr>
        <th>IP</th>
        <th>次数</th>
    </tr>
    <c:forEach items="${applicationScope.map}" var="entry">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
