<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房间分配</title>
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
<!--  <table frame = box rules = all  cellpadding = 10 >-->
<table class="table table-bordered table-hover">
<tr><th>客户身份证</th>
	<th>客户姓名</th>
	<th>预定房间类型</th>
	<th>期望楼层</th>
	<th>期望朝向</th>
	<th>入住时间</th>
	<th>离店时间</th>
</tr>
<c:forEach var = "aro" items = "${aro}" varStatus = "status" >
<tr>
	<td>${aro.idcard}</td>
	<td>${aro.name}</td>
	<td>${aro.roomtype}</td>
	<td>${aro.floor}</td>
	<td>${aro.faceto}</td>
	<td>${aro.enterdate}</td>
	<td>${aro.leavedate}</td>
</tr>
</c:forEach>
</table>
</center>

<center>
<h1>可分配房间</h1>
</center>
<center>
<font color = "red">${mess}</font>
<font color = "red">${mess2}</font>
</center>
<center>
<form action = "ShowAppointedRoomController" method = "post">
<!--  <table frame = box rules = all  cellpadding = 10>-->
<table class="table table-bordered table-hover">
<tr>
	<th>
		入住日期 
		<input type = "date" name = "enterdate"/>
		
	</th>
	<th>
		离店日期
		<input type = "date" name = "leavedate"/>
		
	</th>
	<th>房间类型：
		<select name="roomType">
		<option value="请选择">-请选择（必选）-</option>
		<c:forEach var="rt" items="${roomtypes}">
		<option value="${rt}">${rt}</option>
		</c:forEach>
		</select>
	</th>
	<!--  <th>房间类型 
		<select name="roomType">     
  		<option value="请选择">-请选择（必选）-</option>     
  		<option value="大床房" >大床房</option>     
  		<option value="标准间" >标准间</option> 
  		<option value="单人间" >单人间</option>  
 		</select>  
	</th>
	-->
	<th>楼层
		<select name="floor">     
  		<option value="请选择">-请选择（默认全选）-</option>     
  		<option value="1楼" >1楼</option>     
  		<option value="2楼" >2楼</option>
  		<option value="3楼" >3楼</option>  
  		<option value="4楼" >4楼</option>  
  		<option value="5楼" >5楼</option>  
 		</select>  
	</th>
	<th>朝向
		<select name="faceto">     
  		<option value="请选择">-请选择（默认全选）-</option>     
  		<option value="东" >东</option>     
  		<option value="南" >南</option>
  		<option value="西" >西</option>  
  		<option value="北" >北</option>  
 		</select>  
	</th>
	<th>房间号</th>
	<th>房间状态</th>
	<th><input class="btn btn-primary" type = "submit" value = "搜索"/></th>
</tr>
<c:forEach var = "room" items = "${RuledRoom}" varStatus = "status" >
<tr>
	<td>${enterdate}</td>
	<td>${leavedate}</td>
	<td>${room.roomtype}</td>
	<td>${room.floor}</td>
	<td>${room.faceto}</td>
	<td>${room.roomid}</td>
	<td>${room.status}</td>
	<td><input type = "button" class="btn btn-danger" value = "分配" onclick="window.location.href='AssignRoomController?x=${room.roomid}&y=${aro[0].idcard}&a=${enterdate}&b=${leavedate}'"  ></td>
</tr>
</c:forEach>
</table>
</form>
</center>



</body>
</html>