<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2022/5/13
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="user_mgr.do?command=updateuser" method="post">
  用户名：<input type="text" name="user_name" value="<bean:write name="user" property="user_name"/>"><br>
  用户密码：<input type="text" name="user_pwd" value="<bean:write name="user" property="user_pwd"/>"><br>
  用户年龄：<input type="text" name="user_age" value="<bean:write name="user" property="user_age"/>"><br>
    <input type="hidden" name="user_id" value="<bean:write name="user" property="user_id"/>"><br>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>
