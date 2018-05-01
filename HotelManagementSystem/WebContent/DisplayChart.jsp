<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
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
    
    dpd.setValue("管理人员", 25);
    dpd.setValue("市场人员", 25);
    dpd.setValue("开发人员", 45);
    dpd.setValue("其他人员", 10);
    
    JFreeChart chart = ChartFactory.createPieChart("某公司组织结构图",dpd, true, false, false);
    
    String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session); 
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
    
    String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致

%>

<img src="<%= url %>" width="800" height="600">

</body>
</html>