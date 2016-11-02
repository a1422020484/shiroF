<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<!--[if lt IE 9]><script>document.createElement("canvas");</script><![endif]-->
</head>
<body>
<div >
	<form action="${ctx}/user/login" method="post">
		账号：<input type="text" name="usercode">
		密码：<input type="text" name="password">
		<input type="submit" value="登录">
	</form>
</div>


</body>
</html>