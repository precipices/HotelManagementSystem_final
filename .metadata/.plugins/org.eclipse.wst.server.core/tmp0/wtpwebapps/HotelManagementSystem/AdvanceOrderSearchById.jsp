<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预订单查询</title>

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
<form action = "AdvanceOrderSearchByIdController" method = "post">
<center>
<label >通过身份证查询客户订单：</label>
</center>
<center>
	<div class="container" id="box">
		<div class="form-group">
			<!-- <input type = "text" class="form-control"  name = "userId" style = "border-radius:3px;border:1px solid #000;" size = 50>
			 -->
			 <input type = "text" class="form-control" style="height:25px;" name = "userId" >
		</div>
	</div>
</center>
<center>
<input type = "submit" class="btn btn-primary" value = "查询订单">
</center>
</form>
</br>
<form action = "AdvanceOrderSearchAllController" method = "post">
<center>
<input type = "submit" class="btn btn-danger" value = "查询所有预订单">
</center>
</form>
<center>
${message}
</center>

</div>
</body>
</html>