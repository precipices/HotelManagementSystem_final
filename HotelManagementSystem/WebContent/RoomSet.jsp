<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <title>客房设置</title>
    
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/jquery.searchableSelect.css"  type="text/css">
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" >
	<link rel="stylesheet" href="css/searchstyle.css">
	 
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
	
    <script type="text/javascript">
// 	菜单
	$(document).ready(function(){
		var trigger=$('.hamburger'),
			overlay=$('.overlay'),
			isClosed=false;
		trigger.click(function(){hamburger_cross();});
		function hamburger_cross()
		{
			if (isClosed==true)
			{          
				overlay.hide();
		        trigger.removeClass('is-open');
		        trigger.addClass('is-closed');
		        isClosed=false;
			}
			else
			{   
		        overlay.show();
		        trigger.removeClass('is-closed');
		        trigger.addClass('is-open');
		        isClosed=true;
			}
		}
		$('[data-toggle="offcanvas"]').click(function(){$('#wrapper').toggleClass('toggled');});  
	});
	
// 	下拉
	$(function(){$('select').searchableSelect();});

// 	主体
	window.onload=function()
	{
		new Vue({
			el:'#box',
			data:{
				myData:[],
				roomid:"",
				roomtype:"",
				price:"",
				floor:"",
				faceto:"",
				status:"",
				roominfo:"",
				nowIndex:-100
			},
			methods:
			{
				ini:function()
				{
					<c:forEach items="${selecteddata}" var="room">
 						this.myData.push({
 							roomid:"${room.getRoomid()}",
 							roomtype:"${room.getRoomtype()}",
 							price:"${room.getPrice()}",
 							floor:"${room.getFloor()}",
 							faceto:"${room.getFaceto()}",
 							status:"${room.getStatus()}",
 							roominfo:"${room.getInfo()}"
						})
 					</c:forEach>
                    document.getElementById("load").style.display="none";
				},
				changedel:function(n)
				{
					this.roomid=this.myData[n].roomid;
					this.roomtype=this.myData[n].roomtype;
					this.price=this.myData[n].price;	
					this.floor=this.myData[n].floor;
					this.faceto=this.myData[n].faceto;
					this.status=this.myData[n].status;
					this.roominfo=this.myData[n].roominfo;
					this.myData.splice(n,1);
					document.getElementById("change").style.display="block";
				},
				changeadd:function()
				{
					var judge;
					$.ajax({
						url:"RoomChange",
						async:false,
						type:"post",      
						dataType:"text",
						data:{
							"roomid":this.roomid,
							"roomtype":document.getElementById('selecttype').options[document.getElementById('selecttype').selectedIndex].value,
							"price":this.price,
							"floor":this.floor,
							"faceto":this.faceto,
							"status":this.status,
							"roominfo":this.roominfo
						},
						success:function(Result)
						{
							judge=Result;
							alert(judge);
						},
						error:function(){alert("数据传输失败!");},
					});
					if(judge=="修改成功")
					{
						this.myData.push({
							roomid:this.roomid,
							roomtype:document.getElementById('selecttype').options[document.getElementById('selecttype').selectedIndex].value,
							price:this.price,
							floor:this.floor,
							faceto:this.faceto,
							status:this.status,
							roominfo:this.roominfo
						});
					}
					document.getElementById("change").style.display="none";
					this.roomid="";
					this.roomtype="";
					this.price="";	
					this.floor="";
					this.faceto="";
					this.status="";
					this.roominfo="";
				}
			}
		})
	}
    </script>
</head>
<body>
	<div id="wrapper">
		<div class="overlay"></div>
		<form action="searchServlet" method="post">
			<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
				<ul class="nav sidebar-nav">
                	<li class="sidebar-brand">
                    	<a>搜索条件</a>
               		</li>
               		<li>
                    	<a>房号：
                    		<div style="position:relative;z-index:6;">
                    			<select name="roomid">
                    				<option value="无">无</option>
                    				<c:forEach items="${data}" var="room">
                    					<option value=${room.getRoomid()}>${room.getRoomid()}</option>
									</c:forEach>
								</select>
							</div>
						</a>
                	</li>
                	<li>
                    	<a>状态：
                    		<div style="position:relative;z-index:5;">
                    			<select name="status">
                    				<option value="无">无</option>
									<option value="空闲">空闲</option>
									<option value="有预订">有预订</option>
									<option value="入住中">入住中</option>
									<option value="预留">预留</option>
								</select>
							</div>
						</a>
                	</li>
                	<li>
                    	<a>房型：
                    		<div style="position:relative;z-index:3;">
                    			<select name="roomtype">
                    				<option value="无">无</option>
									<c:forEach items="${roomtypedata}" var="type">
                    					<option value=${type.getRoomtype()}>${type.getRoomtype()}</option>
									</c:forEach>
								</select>
							</div>
						</a>
                	</li>
                	<li>
						<a>楼层：
                    		<div style="position:relative;z-index:2;">
                    			<select name="floor">
                    				<option value="无">无</option>
									<option value="1楼">1楼</option>
									<option value="2楼">2楼</option>
									<option value="3楼">3楼</option>
									<option value="4楼">4楼</option>
									<option value="5楼">5楼</option>
								</select>
							</div>
						</a>
                	</li>
               		<li>
                   		<a>朝向：
                    		<div style="position:relative;z-index:1;">
                    			<select name="faceto">
                    				<option value="无">无</option>
									<option value="东">东</option>
									<option value="南">南</option>
									<option value="西">西</option>
									<option value="北">北</option>
								</select>
							</div>
						</a>
               		</li>
                	<li>
                		<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                			<input type="submit" value="开始搜索" style="line-height:40px;border:none;background:none;">
                		</a>
               		</li>
				</ul>
			</nav>
		</form>
		<div id="page-content-wrapper">
			<button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
				<span class="hamb-top"></span>
				<span class="hamb-middle"></span>
				<span class="hamb-bottom"></span>
			</button>
			<div class="container" id="box">
				<div id="change" style="display:none">
					<div class="form-group">
						<label for="roomid">房间号：</label>
						<input type="text" id="roomid" class="form-control" style="height:25px;" v-model="roomid" readonly>
					</div>
					<div class="form-group">
						<label for="roomtype">客房类型：</label></br>
						<select id="selecttype">
                    		<c:forEach items="${roomtypedata}" var="type">
                    			<option value=${type.getRoomtype()}>&nbsp;&nbsp;${type.getRoomtype()}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="price">客房价格：</label>
						<input type="text" id="price" class="form-control" style="height:25px;" v-model="price" placeholder="输入客房价格">
					</div>
					<div class="form-group">
						<label for="floor">楼层：</label>
						<input type="text" id="floor" class="form-control" style="height:25px;" v-model="floor" readonly>
					</div>
					<div class="form-group">
						<label for="faceto">朝向：</label>
						<input type="text" id="faceto" class="form-control" style="height:25px;" v-model="faceto" readonly>
					</div>
					<div class="form-group">
						<label for="status">状态：</label>
						<input type="text" id="status" class="form-control" style="height:25px;" v-model="status" readonly>
					</div>
					<div class="form-group">
						<label for="roominfo">客房描述：</label>
						<input type="text" id="roominfo" class="form-control" style="height:25px;" v-model="roominfo" placeholder="输入客房描述">
					</div>
					<div class="form-group">
						<input type="button"  value="修改" class="btn btn-primary" v-on:click="changeadd()">
						<input type="reset"  value="重置" class="btn btn-danger">
					</div>
				</div>
         		</hr>
				<table class="table table-bordered table-hover">
					<caption class="h3 text-info">客房信息表</caption>
					<tr>
						<th class="text-center">房间号</th>
						<th class="text-center">客房类型</th>
						<th class="text-center">房间价格</th>
						<th class="text-center">楼层</th>
						<th class="text-center">朝向</th>
						<th class="text-center">状态</th>
						<th class="text-center">房间描述</th>
 						<th class="text-center">操作</th>
					</tr> 
					<tr class="text-center" v-for="item in myData">
						<td>{{item.roomid}}</td>
						<td>{{item.roomtype}}</td>
						<td>{{item.price}}</td>
						<td>{{item.floor}}</td>
						<td>{{item.faceto}}</td>
						<td>{{item.status}}</td>
						<td style="width:500px;"><div style="overflow:auto;width:500px;">{{item.roominfo}}</div></td>
<!-- 						<td>{{item.roominfo}}</td> -->
						<td>
							<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#layer" v-on:click="nowIndex=$index">修改</button>
						</td>
					</tr>
					<tr id="load" class="text-center" v-show="myData.length==0">
						<td colspan="8" class="text-center">
							<button class="btn btn-primary" v-on:click="ini()">加载数据</button>
						</td>
					</tr>
					<tr class="text-center" v-show="myData.length!=0">
						<td colspan="8" class="text-center">
							<button class="btn btn-primary" onclick="location.reload()">刷新</button>
						</td>
					</tr>
				</table>
				<div role="dialog" class="modal fade" id="layer" data-index="{{nowIndex}}">
              		<div class="modal-dialog">
                 		<div class="modal-content">
                      		<div class="modal-header">
                        		<button class="close" data-dismiss="modal">
                            		<span>&times;</span>
                        		</button>
                      			<h4 class="modal-title">确认修改吗？</h4>
							</div>
							<div class="modal-body text-right">
								<button class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>
								<button class="btn btn-danger btn-sm" data-dismiss="modal" v-on:click="changedel(nowIndex)">确认</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>