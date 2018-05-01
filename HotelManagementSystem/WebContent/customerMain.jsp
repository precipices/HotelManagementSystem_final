<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户页面</title>
</head>
<frameset rows="22.5%,*,30%" frameborder=no>
<frame src="head.jsp" name="top" noresize scrolling="no"/>
<frameset cols="15%,*" frameborder=no>
<frame src="customerMenu.jsp" name="left" noresize scrolling="no"/>
<frame src="customerOrder.jsp" name="right"/>
</frameset>
<frame src="tail.jsp" name="tail" scrolling="no"/>
</frameset>
</html>