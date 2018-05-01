<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}
li {
	font: 200 20px/1.5 Helvetica, Verdana, sans-serif;
	border-bottom: 1px solid #ccc;
}
li a {
	text-decoration: none;
	color: #000;
	display: block;
	width: 200px;
	-webkit-transition: font-size 0.3s ease, background-color 0.3s ease;
	-moz-transition: font-size 0.3s ease, background-color 0.3s ease;
	-o-transition: font-size 0.3s ease, background-color 0.3s ease;
	-ms-transition: font-size 0.3s ease, background-color 0.3s ease;
	transition: font-size 0.3s ease, background-color 0.3s ease;
}
li a:hover {
	font-size: 30px;
	background: #f6f6f6;
}
</style>
</head>
<body>
	<ul>
		<li><a href="personCenter.jsp" target="right">个人中心</a></li>
		<li><a href="customerOrder.jsp" target="right">下订单</a></li>
		<li><a href="customerAllOrder.jsp" target="right">所有订单</a></li>
		<li><a href="CustomerViewServlet" target="right">浏览房间</a></li>
	</ul>
</body>
</html>