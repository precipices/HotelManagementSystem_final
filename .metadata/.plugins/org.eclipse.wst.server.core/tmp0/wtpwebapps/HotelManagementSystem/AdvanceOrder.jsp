<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预订单</title>

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
<center>
<div class="container" id="box">
	<!-- <table frame = box rules = all  cellpadding = 10 > -->
	<table class="table table-bordered table-hover">
		<caption class="h3 text-info">预订单</caption>
		<tr>
			<th>预订单号</th>
			<th>客户身份证</th>
			<th>客户姓名</th>
			<th>预定房间类型</th>
			<th>期望楼层</th>
			<th>期望朝向</th>
			<th>入住时间</th>
			<th>离店时间</th>
			<th></th>
		</tr>
<c:forEach var = "aro" items = "${AdvanceRoomOrder}" varStatus = "status" >
<tr>
	<td>${aro.orderid}</td> <!-- 预订单号 -->
	<td>${aro.idcard}</td>
	<td>${aro.name}</td>
	<td>${aro.roomtype}</td>
	<td>${aro.floor}</td>
	<td>${aro.faceto}</td>
	<td>${aro.enterdate}</td>
	<td>${aro.leavedate}</td>
	<td><input type = "button" class="btn btn-primary" id = "btn" value = "分配房间 " onclick="window.location.href='RoomAllocationController?x=${aro.orderid}'" ></td>
</tr>
</c:forEach>
</table>
</div>
</center>

</body>
</html>