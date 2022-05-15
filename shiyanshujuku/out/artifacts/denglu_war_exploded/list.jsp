<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2022/5/13
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <tbody>
    <logic:empty name="userlist">
      <tr><td>没有用户信息！</td></tr>
    </logic:empty>
    <logic:notEmpty name="userlist">
      <logic:iterate id="user" name="userlist">
        <tr>
          <td><bean:write name="user" property="user_id"/> </td>
          <td><bean:write name="user" property="user_name"/> </td>
          <td><bean:write name="user" property="user_pwd"/> </td>
          <td><bean:write name="user" property="user_age"/> </td>
          <td>
            <a href="user_mgr.do?command=finduser&&user_id=
<bean:write name="user" property="user_id"/>">编辑</a>
            <a href="user_mgr.do?command=deluser&&user_id=
<bean:write name="user" property="user_id"/>">删除</a><br>
          </td>
        </tr>
      </logic:iterate>
    </logic:notEmpty>
  </tbody>

</body>
</html>
