<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>客户主页</title>
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
							<li><a href="customerMain.jsp">客户管理</a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<div class="banner">
		<div class="slider">
			<h2 class="wow shake animated" data-wow-delay=".5s">【515】</h2>
			<div class="border"></div>
			<div id="top" class="callbacks_container-wrap">
				<ul class="rslides" id="slider3">
					<li>
						<div class="slider-info">
							<h3>上海理工最舒适的酒店</h3>
							<p>提供给您最顶级的服务和享受</p>
							<div class="more-button">
								<a href="about.html">更多酒店相关信息</a>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="banner-bottom w3layouts">
		<div class="container">
			<div class="banner-bottom-grids agile-info">
				<div class="col-md-6 banner-bottom-left wow fadeInLeft animated"
					data-wow-delay=".5s">
					<div class="left-border">
						<div class="left-border-info">
							<p>让您的生活更愉悦。</p>
						</div>
					</div>
				</div>
				<div
					class="col-md-6 banner-bottom-left banner-bottom-right wow fadeInRight animated"
					data-wow-delay=".5s">
					<div class="left-border">
						<div class="left-border-info right-border-info">

							<p>放松您的身心。</p>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<div class="information w3lagile">
		<div class="container">
			<div class="information-heading">
				<h3 class="wow fadeInDown animated" data-wow-delay=".5s">酒店展示</h3>
				<p class="wow fadeInUp animated" data-wow-delay=".5s">【515】酒店一直致力于为客服提供最优质的服务，让客户享受最尊贵的待遇</p>
			</div>

			<div class="information-grids agile-info">
				<div class="col-md-4 information-grid wow fadeInLeft animated"
					data-wow-delay=".5s">
					<div class="information-info">
						<div class="information-grid-img">
							<img src="images/8.jpg" alt="" />
						</div>
						<div class="information-grid-info">
							<h4>个性化厨房</h4>
							<p>酒店部分套房自带个性化厨房，让客户能够在享受烹饪的同时感受如家一般的温暖。</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 information-grid wow fadeInUp animated"
					data-wow-delay=".5s">
					<div class="information-info">
						<div class="information-grid-info">
							<h4>异域风格客房</h4>
							<p>酒店专门聘请国外知名设计师为酒店设计了舒适而充满异域风格的客房，带给客户不一样的享受。</p>
						</div>
						<div class="information-grid-img">
							<img src="images/3.jpg" alt="" />
						</div>
					</div>
				</div>
				<div class="col-md-4 information-grid wow fadeInRight animated"
					data-wow-delay=".5s">
					<div class="information-info">
						<div class="information-grid-img">
							<img src="images/7.jpg" alt="" />
						</div>
						<div class="information-grid-info">
							<h4>公共休息区</h4>
							<p>酒店为客户提供了功能丰富的公共休息区，为客户社交、休闲提供便利。</p>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

	</div>

	<div class="popular agile-info">
		<div class="container">
			<div class="copyright w3l wow fadeInRight animated"
				data-wow-delay=".5s">
				<p>酒店地址：上海理工大学516号3公寓3号楼515室</p>
				<p>联系电话：********</p>
				<p>E-mail：***@515.com</p>
			</div>
		</div>
	</div>
</body>
</html>