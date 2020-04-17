<%--
  Created by IntelliJ IDEA.
  User: hfL
  Date: 2020/4/16
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="account/findAll">测试findAll</a>

    <form action="account/save" method="post">
    姓名：<input type="text" name="name" />
    <br/>
    余额：<input type="text" name="money" />
    <br/>
    <input type="submit" value="保存">
    </form>

</body>
</html>
