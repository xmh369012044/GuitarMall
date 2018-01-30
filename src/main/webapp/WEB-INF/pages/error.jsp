<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>确认支付页面</title>
	<link href="${app }/staticfile/css/confirm.css" rel="stylesheet" type="text/css">
</head>
<body style="background:url(${app}/staticfile/img/index/background.jpg);background-size:100% 100%;">
<%@include file="/WEB-INF/pages/head.jsp" %>
<!-- 确认支付form -->
<div id="warp">
	<div>
		<h3>
			订单号：${p2_Order}
			<br><br>
			支付金额: ${p3_Amt }
			<br><br>
			<br>
			错误信息:${error }
		</h3>
		<a href="${app}/OrderListServlet">点击返回</a>
	</div>
</div>
<%@include file="/WEB-INF/pages/foot.jsp" %>
</body>
</html>