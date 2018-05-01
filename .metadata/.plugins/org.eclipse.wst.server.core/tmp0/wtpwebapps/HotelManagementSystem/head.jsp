<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>客房预订管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet" type="text/css"
	media="all">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/wow.min.js"></script>
<script>
	new WOW().init();
</script>
</head>
<body>
	<div class="header">
		<div class="top-header">
			<div class="container">
				<div class="top-header-info">
					<div class="top-header-left wow fadeInLeft animated"
						data-wow-delay=".5s">
						<p>欢迎，${user.username}，感谢您选择【515】酒店</p>
					</div>
					<div class="top-header-right wow fadeInRight animated"
						data-wow-delay=".5s">
						<div class="top-header-right-info">
							<ul>
								<li><a href="SafeExit" target="_top">注销</a></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="bottom-header">
			<div class="container">
				<div class="logo wow fadeInDown animated" data-wow-delay=".5s">
					<h1>
						<a href="customerHome.jsp" target="_top"><img
							src="images/logo.jpg" alt="" /></a>
					</h1>
				</div>
				<div class="top-nav wow fadeInRight animated" data-wow-delay=".5s">
					<nav class="navbar navbar-default">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="customerHome.jsp" target="_top">酒店主页</a></li>
							<li><a href="loginedabout.jsp" target="_top">酒店介绍</a></li>
							<li><a href="customerMain.jsp" target="_top">客户管理</a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>
</html>