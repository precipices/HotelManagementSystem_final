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
	
	<!-- ���� -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/vue.js"></script>
	<!-- �˵� -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- ���� -->
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
	�������ͣ�
	<select name="roomType">
	<option value="��ѡ��">-��ѡ�񣨱�ѡ��-</option>
	<c:forEach var="rt" items="${roomtypes}">
	<option value="${rt}">${rt}</option>
	</c:forEach>
	</select>
</th>
<th>
 	¥��
 	<select name="floor">     
  		<option value="��ѡ��">-��ѡ��Ĭ��ȫѡ��-</option>     
  		<option value="1¥" >1¥</option>     
  		<option value="2¥" >2¥</option>
  		<option value="3¥" >3¥</option>  
  		<option value="4¥" >4¥</option>  
  		<option value="5¥" >5¥</option>  
 	</select>  
</th>
<th>
	����
	<select name="faceto">     
  		<option value="��ѡ��">-��ѡ��Ĭ��ȫѡ��-</option>     
  		<option value="��" >��</option>     
  		<option value="��" >��</option>
  		<option value="��" >��</option>  
  		<option value="��" >��</option>  
 	</select> 
</th> 
</table>
</center></br>
<center>
<input type = "submit" class="btn btn-primary" value = "��Ҫ���ѯ"/>
</center>
</form>
</div>
</body>
</html>