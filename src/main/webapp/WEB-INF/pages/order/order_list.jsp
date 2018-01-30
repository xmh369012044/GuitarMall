<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>我的订单</title>
    <link href="${app}/staticfile/css/orderList.css" rel="stylesheet" type="text/css">
</head>
<body style="background:url(${app}/staticfile/img/index/background.jpg);background-size:100% 100%;">
<%@include file="../head.jsp"%>
<div style="height: 1922px; width: 1298px; margin-left: auto;">
<c:forEach items="${list}" var="info">
		<dl class="Order_information" >
			<dt>
				<h3>订单信息</h3>
			</dt>
			<dd style="color:#fff;">
				订单编号：${info.order.id }<br />
				 下单时间：${info.order.ordertime }<br /> 
				 订单金额：${info.order.money }<br /> 
				 支付状态：
				 <c:if test="${info.order.paystate==0 }" var="flag">
						<font color="red">未支付</font>&nbsp;&nbsp;&nbsp;
						<a href="/OrderDeleteServlet?id=${info.order.id}">
						<img src="${app}/staticfile/img/orderList/sc.jpg" width="69" height="19"style="border-radius: 60%;"></a> 
				 		<a href="${app}/topay?id=${info.order.id }&money=${info.order.money}"> 
				 		<img src="${app}/staticfile/img/orderList/zx.jpg" width="69" height="19" style="border-radius: 60%;"></a><br /> 
				 </c:if>
				 <c:if test="${!flag }">
						<font color="blue">已支付</font><br/>
				 </c:if>
				 收货地址：${info.order.receiverinfo }<br/>
				支付方式：在线支付
				<a href="${app}/createxcel?orderId=${info.order.id}">订单下载</a>
			</dd>
		</dl>
		<table width="1200" border="0" cellpadding="0"
			cellspacing="1" style="background:#d8d8d8;color:#333333">
			<tr>
				<th width="276" height="30" align="center" valign="middle" bgcolor="#f3f3f3">商品图片</th>
				<th width="247" align="center" valign="middle" bgcolor="#f3f3f3">商品名称</th>
				<th width="231" align="center" valign="middle" bgcolor="#f3f3f3">商品单价</th>
				<th width="214" align="center" valign="middle" bgcolor="#f3f3f3">购买数量</th>
				<th width="232" align="center" valign="middle" bgcolor="#f3f3f3">小计</th>
			</tr>
		<c:forEach items="${info.map }" var="entry">
			<tr>
					${entry.key.name }
				<td align="center" valign="middle" bgcolor="#FFFFFF">
					<img src="${app }${entry.key.imgurl }" width="90" height="105">
				</td>
				<td align="center" valign="middle" bgcolor="#FFFFFF">${entry.key.name }</td>
				<td align="center" valign="middle" bgcolor="#FFFFFF">${entry.key.price }元</td>
				<td align="center" valign="middle" bgcolor="#FFFFFF">${entry.value }件</td>
				<td align="center" valign="middle" bgcolor="#FFFFFF">${entry.key.price*entry.value }元</td>
			</tr>
		</c:forEach>
		</table>
		<div class="Order_price">${info.order.money }元</div>
</c:forEach>
</div>
<%@include file="../foot.jsp" %>
</body>
</html>
