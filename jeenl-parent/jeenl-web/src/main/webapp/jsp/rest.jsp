<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="../user/create.json" method="post">
	Name:<input type="text" name="userName">
    <input type="submit" value="增加">
</form>

<form action="../user/delete.json" method="post">
    <input type="hidden" name="_method" value="DELETE">
	ID:<input type="text" name="id">
    <input type="submit" value="删除">
</form>

<form action="../user/update.json" method="post">
    <input type="hidden" name="_method" value="PUT">
	Name:<input type="text" name="userName">
    <input type="submit" value="更新">
</form>

<form action="../user/find.json" method="get">
	ID:<input type="text" name="id">
    <input type="submit" value="查找">
</form>

</body>
</html>