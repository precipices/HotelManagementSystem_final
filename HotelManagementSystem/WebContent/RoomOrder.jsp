<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/jquery.searchableSelect.css"  type="text/css">
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" >
	<link rel="stylesheet" href="css/sycstyle.css">
	
	<!-- 主体 -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/vue.js"></script>
	<!-- 菜单 -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- 搜索 -->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/jquery.searchableSelect.js"></script>
</head>
<body>
<center><h1>所有订单</h1></center>
<center>
<!--  <table frame = box rules = all  cellpadding = 10 >-->
<table class="table table-bordered table-hover">
<tr>
	<th>订单号</th>
	<th>入住房间号</th>
	<th>客户身份证号</th>
	<th>入住时间</th>
	<th>离店时间</th>
	<th>付款金额</th>
	<th></th>
</tr>

<c:forEach var = "ro" items = "${RoomOrder}" varStatus = "status" >
<tr>
	<td>${ro.orderid}</td>
	<td>${ro.roomid}</td>
	<td>${ro.idcard}</td>
	<td>${ro.enterdate}</td>
	<td>${ro.leavedate}</td>
	<td>${ro.charge}</td>
	<td><input type = "button" class="btn btn-primary" value = "退房" onclick = "window.location.href='CheckOutRoomController?x=${ro.orderid}&y=${ro.roomid }'"/></td>
</tr>
</c:forEach>
</table>
</center>
${mes}
</body>
</html>