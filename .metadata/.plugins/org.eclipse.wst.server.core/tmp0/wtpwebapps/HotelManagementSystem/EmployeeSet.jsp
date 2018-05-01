<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工账号设置</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/vue.js"></script>
	<script>
		window.onload = function(){
			new Vue({
				el:'#box',
				data:{
					myData:[],
					position:"",
					empID:"",
					empname:"",
					emppw:"",
					emppwcheck:"",
					nowIndex:-100
				},
				methods:{
					add:function(){
						var judge;
						$.ajax({
							url:"EmployeeAdd",
							async:false,
							type:"post",      
							dataType:"text",
							data:{
								"position":document.getElementById('position').options[document.getElementById('position').selectedIndex].value,
								"empID":this.empID,
								"empname":this.empname,
								"emppw":this.emppw,
								"emppwcheck":this.emppwcheck
                            },
							success:function(Result)
							{
								judge=Result;
								alert(judge);
							},
							error:function(){alert("数据传输失败!");},
						});
						if(judge=="员工账号添加成功")
						{
							this.myData.push({
								position:document.getElementById('position').options[document.getElementById('position').selectedIndex].value,
  								empID:this.empID,
  								empname:this.empname,
							});
						}
						this.position="";
						this.empID="";
						this.empname="";
						this.emppw="";
						this.emppwcheck="";
                     },
                     ini:function(){
						<c:forEach items="${data}" var="emp">
							this.myData.push({
 								position:"${emp.getPosition()}",
 								empID:"${emp.getStaffid()}",
 								empname:"${emp.getName()}"
 							})
 						</c:forEach>
                    	document.getElementById("load").style.display="none";
                    },
					del:function(n){
						$.ajax({
							url:"EmployeeDel",
							type:"post",      
							dataType:"text",
							data:{"empID":this.myData[n].empID},
							success:function(Result){alert(Result);},
							error:function(){alert("数据传输失败!");}
						});
						this.myData.splice(n,1);
					}
				}
			})
		}
	</script>
</head>
<body>
	<div class="container" id="box">
		<div class="form-group">
			<label for="position">职务：</label></br>
			<select id="position">
				<option value="前台接待员">&nbsp;&nbsp;前台接待员</option>
				<option value="经理">&nbsp;&nbsp;经理</option>
			</select>
		</div>
		<div class="form-group">
			<label for="empID">员工号：</label>
			<input type="text" id="empID" class="form-control" style="height:25px;" v-model="empID" placeholder="输入员工号"/>
		</div>
		<div class="form-group">
			<label for="empname">姓名：</label>
			<input type="text" id="empname" class="form-control" style="height:25px;" v-model="empname" placeholder="输入姓名"/>
		</div>
		<div class="form-group">
			<label for="emppw">密码：</label>
			<input type="password" id="emppw" class="form-control" style="height:25px;" v-model="emppw" placeholder="输入密码"/>
		</div>
		<div class="form-group">
			<label for="emppwcheck">密码验证：</label>
			<input type="password" id="emppwcheck" class="form-control" style="height:25px;" v-model="emppwcheck" placeholder="再次输入密码"/>
		</div>
		<div class="form-group">
			<input type="button"  value="添加" class="btn btn-primary" v-on:click="add()"/>
			<input type="reset"  value="重置" class="btn btn-danger"/>
		</div>
		</hr>
		<table class="table table-bordered table-hover">
			<caption class="h3 text-info">员工信息表</caption>
			<tr>
				<th class="text-center">职务</th>
				<th class="text-center">员工号</th>
				<th class="text-center">姓名</th>
				<th class="text-center">操作</th>
			</tr> 
			<tr class="text-center" v-for="item in myData">
				<td>{{item.position}}</td>
				<td>{{item.empID}}</td>
				<td>{{item.empname}}</td>
				<td>
					<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#layer" v-on:click="nowIndex=$index">删除</button>
				</td>
             </tr>
             <tr id="load" class="text-center">
             	 <td colspan="4" class="text-center">
                     <button class="btn btn-primary" v-on:click="ini()">加载已有数据</button>
                 </td>
             </tr>
             <tr class="text-center" v-show="myData.length!=0">
             	 <td colspan="4" class="text-center">
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
                          <h4 class="modal-title">确认删除吗？</h4>
                      </div>
                      <div class="modal-body text-right">
                          <button class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>
                          <button class="btn btn-danger btn-sm" data-dismiss="modal" v-on:click="del(nowIndex)">确认</button>
                      </div>
                  </div>
              </div>
         </div>
     </div>
</body>
</html>