<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部订单</title>
<link href="customercss/customertable.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="OrderSelectServlet" method="post">
<input type="submit" value="查询"/>
${message }<br/>
</form>
等待处理的订单:
<table class="customertable">
<tr><th>订单号</th><th>房间类型</th><th>楼层</th><th>朝向</th><th>入住日期</th><th>离店日期</th></tr>
<c:forEach var="order" items="${sessionScope.customerAdvanceOrders}">
<tr><td>${order.orderid }</td><td>${order.roomtype }</td><td>${order.floor }</td><td>${order.faceto }</td><td>${order.enterdate }</td><td>${order.leavedate }</td>
</tr>
</c:forEach>
</table>
正在进行的订单:
<table class="customertable">
<tr><th>订单号</th><th>房间号</th><th>入住日期</th><th>离店日期</th></tr>
<c:forEach var="order" items="${sessionScope.customerOrders}">
<tr><td>${order.orderid }</td><td>${order.roomid }</td><td>${order.enterdate }</td><td>${order.leavedate }</td>
</tr>
</c:forEach>
</table>
</body>
</html>