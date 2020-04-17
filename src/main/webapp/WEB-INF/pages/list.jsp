<%--
  Created by IntelliJ IDEA.
  User: hfL
  Date: 2020/4/16
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>springmvc执行成功！</h3>
    <C:forEach items="${list}" var="account">
        ${account.name}
        <br/>
    </C:forEach>


</body>
</html>
