<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="org.jfree.chart.*" %>
<%@ page import="org.jfree.data.general.*" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page import="com.hms.model.CustomerRoomTypeModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<div style="margin:100px;">
<%session.setAttribute("roomtypes", CustomerRoomTypeModel.getRoomTypes()); %>
<form  action = "ShowRoomStatusImageController" method = "post">
<center>
<table class="table table-bordered table-hover">
<th>	
	房间类型：
	<select name="roomType">
	<option value="请选择">-请选择（必选）-</option>
	<c:forEach var="rt" items="${roomtypes}">
	<option value="${rt}">${rt}</option>
	</c:forEach>
	</select>
</th>
<th>
 	楼层
 	<select name="floor">     
  		<option value="请选择">-请选择（默认全选）-</option>     
  		<option value="1楼" >1楼</option>     
  		<option value="2楼" >2楼</option>
  		<option value="3楼" >3楼</option>  
  		<option value="4楼" >4楼</option>  
  		<option value="5楼" >5楼</option>  
 	</select>  
</th>
<th>
	朝向
	<select name="faceto">     
  		<option value="请选择">-请选择（默认全选）-</option>     
  		<option value="东" >东</option>     
  		<option value="南" >南</option>
  		<option value="西" >西</option>  
  		<option value="北" >北</option>  
 	</select> 
</th> 
</table>
</center></br>
<center>
<input type = "submit" class="btn btn-primary" value = "按要求查询"/>
</center>
</form>
</div>
</body>
</html>