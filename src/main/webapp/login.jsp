<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <span style="color:red;">${error}</span>
	<form action="login" method="post">
		用户编号:<input type="text" name="username" size="25" /><br /> 用户密码:<input
			type="password" name="password" size="25" /><br /> <input
			type="submit" value="登录" />
	</form>

</body>
</html>