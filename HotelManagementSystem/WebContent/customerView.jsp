<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览房间</title>
<link href="customercss/customertable.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table class="customertable">
		<tr>
			<th>房间号</th>
			<th>状态</th>
			<th>房价</th>
			<th>房间类型</th>
			<th>楼层</th>
			<th>朝向</th>
			<th>房间特征描述</th>
		</tr>
		<c:forEach var="room" items="${rooms}" varStatus="i">
			<c:if test="${(i.index-i.index%5)/5==show }" var="varName">
				<tr>
					<td>${room.roomid}</td>
					<td>${room.status}</td>
					<td>${room.price}</td>
					<td>${room.roomtype}</td>
					<td>${room.floor}</td>
					<td>${room.faceto}</td>
					<td>${room.info}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<form action="CustomerViewServlet" method="post"
		style="display: inline">
		<input type="submit" name="lastPage" value="上一页" />
	</form>
	<form action="CustomerViewServlet" method="post"
		style="display: inline">
		<input type="submit" name="nextPage" value="下一页" />
	</form>
</body>
</html>