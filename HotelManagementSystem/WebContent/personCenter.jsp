<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<body>
个人中心
<table>
<tr><td>身份证号:</td><td>${user.customer.idcard}</td></tr>
<tr><td>用户名:</td><td>${user.customer.name}</td></tr>
<tr><td>总计消费(元):</td><td>${user.customer.spend}</td></tr>
<tr><td>消费次数(笔):</td><td>${user.customer.spendtime}</td></tr>
<tr><td>入住总时长(天):</td><td>${user.customer.livelength}</td></tr>
</table>
</body>
</html>