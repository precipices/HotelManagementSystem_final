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
    dpd.setValue("����", Integer.parseInt(s1[0]));
    dpd.setValue("��Ԥ��",Integer.parseInt(s1[1]));
    dpd.setValue("����ס",Integer.parseInt(s1[2]));
    dpd.setValue("�ѳ�ʱ", Integer.parseInt(s1[3]));
    
    String str = (String)request.getAttribute("roomType")+(String)request.getAttribute("floor")+(String)request.getAttribute("faceto");
    JFreeChart chart = ChartFactory.createPieChart(str,dpd, true, false, false);
    
    String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session); 
    //ServletUtilities������web�����Ĺ����࣬����һ���ַ����ļ���,�ļ����Զ����ɣ����ɺõ�ͼƬ���Զ����ڷ�������tomcat������ʱ�ļ��£�temp��
    
    String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //�����ļ���ȥ��ʱĿ¼��Ѱ�Ҹ�ͼƬ�������/DisplayChart·��Ҫ�������ļ����û��Զ����<url-pattern>һ��
%>
<center>
<img src="<%= url %>" width="800" height="600">
</center>
</body>
</html>