<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<%@ page import="org.jfree.chart.*" %>
<%@ page import="org.jfree.data.general.*" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
    DefaultPieDataset dpd = new DefaultPieDataset();
	String [] s1 = (String [])request.getAttribute("s");
    dpd.setValue("空闲", Integer.parseInt(s1[0]));
    dpd.setValue("有预订",Integer.parseInt(s1[1]));
    dpd.setValue("已入住",Integer.parseInt(s1[2]));
    dpd.setValue("已超时", Integer.parseInt(s1[3]));
    
    String str = (String)request.getAttribute("roomType")+(String)request.getAttribute("floor")+(String)request.getAttribute("faceto");
    JFreeChart chart = ChartFactory.createPieChart(str,dpd, true, false, false);
    
    String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session); 
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
    
    String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
%>
<center>
<img src="<%= url %>" width="800" height="600">
</center>
</body>
</html>