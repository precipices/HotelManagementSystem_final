<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预订</title>
<link href="customercss/customertable.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<font color=red>${message}</font>
<form action="CustomerOrderServlet" method="post">
<table class="customertable">
	<tr><td>入住日期:</td><td><input type="date" name="enterdate"/></td></tr>
	<tr><td>离店日期:</td><td><input type="date" name="leavedate"/></td></tr>
	<tr><td>房间类型:</td><td>
	<select name="roomtype">
	<c:forEach var="rt" items="${roomtypes}">
	<option value="${rt}">${rt}</option>
	</c:forEach>
	</select>
	</td></tr>
	<tr><td>期望楼层:</td><td>
	<select name="floor">
	<option value="无要求">无要求</option>
	<option value="1-3楼">1-3楼</option>
	<option value="4-5楼">4-5楼</option>
	<option value="一楼">一楼</option>
	<option value="一楼">一楼</option>
	<option value="二楼">二楼</option>
	<option value="三楼">三楼</option>
	<option value="四楼">四楼</option>
	<option value="五楼">五楼</option>
	</select>
	</td></tr>
	<tr><td>期望朝向:</td><td>
	<select name="faceto">
	<option value="无要求">无要求</option>
	<option value="朝阳">朝阳</option>
	<option value="通风">通风</option>
	<option value="东">东</option>
	<option value="南">南</option>
	<option value="西">西</option>
	<option value="北">北</option>
	</select>
	</td></tr>
	<tr><td><input type="submit" value="确认预订"/></td><td><input type="reset" value="重置"/></td></tr>
	</table>
</form>
</body>
</html>