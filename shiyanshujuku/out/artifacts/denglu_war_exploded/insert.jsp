<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2022/5/13
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="user_mgr.do?command=add" method="post">
      用户名：<input type="text" name="user_name"><br>
      用户密码：<input type="text" name="user_pwd"><br>
      用户年龄：<input type="text" name="user_age"><br>
      <input type="submit">
      <input type="reset">
  </form>
</body>
</html>
