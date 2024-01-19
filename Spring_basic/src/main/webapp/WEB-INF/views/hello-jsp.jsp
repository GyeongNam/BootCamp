<%@ page contentType="text/html; charset=utf-8" language="java" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p>data(El 문법) : ${myData}</p>
<p>data(java 코드) :
    <%
        String getData = request.getAttribute("myData").toString();
        out.print(getData);
    %>
</p>
</body>
</html>