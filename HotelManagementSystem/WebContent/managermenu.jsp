<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>【515】酒店管理系统</title>
	<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="build/css/app.css" media="all">
</head>
<body>
	<div class="layui-layout layui-layout-admin kit-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">【515】酒店管理系统</div>
			<ul class="layui-nav layui-layout-right kit-nav" lay-filter="kitNavbar" kit-navbar>
				<li class="layui-nav-item">
					<a href="javascript:;"><img src="http://m.zhengjinfan.cn/images/0.jpg" class="layui-nav-img">经理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;" data-url="personalinfo.html" data-icon="" data-title="个人资料" kit-target data-id="个人资料">
								<span>个人资料</span>
							</a>
						</dd>
  					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="SafeExit"><i class="fa fa-sign-out" aria-hidden="true"></i>&nbsp&nbsp注销</a>
				</li>
			</ul>
		</div>
		<div class="layui-side layui-bg-black kit-side">
			<div class="layui-side-scroll">
				<div class="kit-side-fold" style="height:42px;"><i class="fa fa-navicon"></i></div>
				<ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
					<li class="layui-nav-item">
 						<a href="javascript:;"><i class="fa fa-gear fa-fw"></i><span>&nbsp&nbsp基础设置</span></a>
						<dl class="layui-nav-child">
 							<dd>
								<a href="javascript:;" data-url="RoomTypeSetServlet" data-icon="" data-title="客房类型设置" kit-target data-id="客房类型设置">
									<span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
									<i class="fa fa-home fa-fw"></i>
									<span>&nbsp&nbsp客房类型设置&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="RoomSetServlet" data-icon="" data-title="客房信息设置" kit-target data-id="客房信息设置">
									<span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
									<i class="fa fa-hotel fa-fw"></i>
									<span>&nbsp&nbsp客房信息设置&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="EmployeeServlet" data-icon="" data-title="账号设置" kit-target data-id="账号设置">
									<span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
									<i class="fa fa-group fa-fw"></i>
									<span>&nbsp&nbsp账号设置&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
								</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;"><span></span><i class="fa fa-sitemap fa-fw"></i><span>&nbsp&nbsp客房管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" data-url="RoomStatusStatistics.jsp" data-icon="" data-title="房态统计" kit-target data-id="房态统计">
									<span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
									<i class="fa fa-bar-chart fa-fw"></i>
									<span>&nbsp&nbsp房态统计&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
								</a>
							</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<div class="layui-body" id="container">
			<div class="layui-tab layui-tab-card kit-tab" lay-filter="kitTab">
				<ul class="layui-tab-title" style="width:100%"></ul>
				<div class="layui-tab-content"></div>
			</div>
		</div>
	</div>
   
	<script src="plugins/layui/layui.js"></script>
	<script>
		var message;
		layui.config({base:'build/js/'}).use(['app','message'],
		function(){
			var app=layui.app;
                	$=layui.jquery;
                	layer=layui.layer;
            		message=layui.message;      
			app.set({type:'iframe'}).init(); 
		});
	</script>
</body>
</html>