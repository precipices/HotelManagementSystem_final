<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客房类型设置</title>
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
                     roomtype:"",
                     nowIndex:-100
                  },
                  methods:{
                     add:function(){
                    	  var judge;
                          $.ajax({
                        	  url:"RoomTypeAdd",
                        	  async:false,
                        	  type:"post",      
                              dataType:"text",
                              data:{"roomtype":this.roomtype},
                              success:function(Result)
                              {
                            	  judge=Result;
                            	  alert(judge);
                              },
                              error:function(){alert("数据传输失败!");},
                          });
                          if(judge=="新客房类型添加成功！")
                          {
                        	  this.myData.push({
                      	 		roomtype:this.roomtype,
                      	 		number:0
                      	 	});
                          }
                          this.roomtype="";
                     },
                     ini:function(){
                    	<c:forEach items="${data}" var="room">
 							this.myData.push({roomtype:"${room.getRoomtype()}",number:"${room.getNumber()}"})
 						</c:forEach>
                    	document.getElementById("load").style.display="none";
                    },
                      del:function(n){
                    	  $.ajax({
                        	  url:"RoomTypeDel",
                        	  type:"post",      
                              dataType:"text",
                              data:{"roomtype":this.myData[n].roomtype},
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
         <form role="form">
             <div class="form-group">
                 <label for="roomtype">客房类型：</label>
                 <input type="text" id="roomtype" class="form-control" v-model="roomtype" placeholder="输入客房类型"/>
             </div>
             <div class="form-group">
                 <input type="button"  value="添加" class="btn btn-primary" v-on:click="add()"/>
                 <input type="reset"  value="重置" class="btn btn-danger"/>
             </div>
         </form>
         <hr/>
         <table class="table table-bordered table-hover">
              <caption class="h3 text-info">客房类型信息表</caption>
             <tr>
                 <th class="text-center">客房类型</th>
                 <th class="text-center">现有数量</th>
                 <th class="text-center">操作</th>
             </tr> 
             <tr class="text-center" v-for="item in myData">
                 <td>{{item.roomtype}}</td>
                 <td>{{item.number}}</td>
                 <td>
                     <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#layer" v-on:click="nowIndex=$index">删除</button>
                 </td>
             </tr>
             <tr id="load" class="text-center">
             	 <td colspan="3" class="text-center">
                     <button class="btn btn-primary" v-on:click="ini()">加载已有数据</button>
                 </td>
             </tr>
             <tr class="text-center" v-show="myData.length!=0">
             	 <td colspan="3" class="text-center">
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