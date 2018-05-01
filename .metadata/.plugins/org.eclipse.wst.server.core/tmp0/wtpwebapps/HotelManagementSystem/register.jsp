<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
<script>new WOW().init();</script>
</head>
<body>
	<div class="header">
		<div class="top-header">
			<div class="container">
				<div class="top-header-info">
					<div class="top-header-left wow fadeInLeft animated" data-wow-delay=".5s">
						<p>欢迎，感谢您选择【515】酒店</p>
					</div>
					<div class="top-header-right wow fadeInRight animated" data-wow-delay=".5s">
						<div class="top-header-right-info">
							<ul>
								<li><a href="login.jsp">登陆</a></li>
								<li><a href="register.jsp">注册</a></li>
							</ul>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<div class="bottom-header">
			<div class="container">
				<div class="logo wow fadeInDown animated" data-wow-delay=".5s">
					<h1><a href="home.html"><img src="images/logo.jpg" alt="" /></a></h1>
				</div>
				<div class="top-nav wow fadeInRight animated" data-wow-delay=".5s">
					<nav class="navbar navbar-default">
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li><a href="home.html">酒店主页</a></li>
								<li><a href="about.html">酒店介绍</a></li>
							</ul>	
							<div class="clearfix"> </div>
						</div>	
					</nav>		
				</div>
			</div>
		</div>
	</div>
	
	<div class="login">
		<div class="container">
			<div class="login-body">
				<div class="login-heading w3layouts">
					<h1>客户注册</h1>
				</div>
				<div class="login-info">
					<form action="RegisterServlet" method="post">
						<input type="text" name="idcard" placeholder="身份证号" required="required">
						<input type="text" name="username" placeholder="真实姓名" required="required">
						<input type="password" name="password" placeholder="密码" required="required">
						<input type="password" name="surepassword" placeholder="确认密码" required="required">
						<input type="submit" value="注册">
						<div class="signup-text">
							<a href="login.jsp">已经拥有账号？立即登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<div class="popular agile-info">
		<div class="container">
			<div class="copyright w3l wow fadeInRight animated" data-wow-delay=".5s">
				<p>酒店地址：上海理工大学516号3公寓3号楼515室</p>
				<p>联系电话：********</p>
				<p>E-mail：***@515.com</p>
			</div>
		</div>
	</div>
</body>	
</html>