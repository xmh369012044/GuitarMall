<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<link rel="stylesheet" href="${app }/staticfile/css/head.css"/>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />

<div id="common_head">
	<div id="line1">

		<div id="content" style="text-align:left;background-color: #8F5E24" >
	
	<c:if test="${empty sessionScope.userSession}" var="eptun" scope="page">
	<a href="/login" style="color: #EEEEEE;margin: 5px;">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	<a href="/regist"  style="color: #EEEEEE">注册</a>
	</c:if>
	<c:if test="${!eptun}">
<<<<<<< .mine
	欢迎${sessionScope.user.username}&nbsp;&nbsp;<a href="/logout">注销</a>
=======
	欢迎${sessionScope.userSession.username}&nbsp;&nbsp;
	<a href="${app}/logout.action">注销</a>
>>>>>>> .r43
	</c:if>
	</div>
	<marquee direction="left" align="bottom" width="100%"  onmouseout="this.start()" onmouseover="this.stop()" scrollamount="20" scrolldelay="0" style="color: yellow; font-size: 16px;font-weight: bolder;">
	公告：本站将于2017年X月1日正式上线，更多精彩内容敬请期待！
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	公告：本站将于2017年X月1日正式上线，更多精彩内容敬请期待！
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	公告：本站将于2017年X月1日正式上线，更多精彩内容敬请期待！
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	公告：本站将于2017年X月1日正式上线，更多精彩内容敬请期待！
	</marquee>
	</div>
	<div id="line2">
		<img id="logo" style="width: 200px;height: 74px;margin-left: 50px;margin-right: 128px;" src="${app}/staticfile/img/head/logo.png"/>
		<form action="/query.action" method="post" style="position: absolute;left:542px;top: 36px;">
		<input type="text" name="prodname" style="margin-bottom: 0px;"/>
		<input type="submit" value="搜 索" style="width: 62px;height: 34px;background-color: #8F5E24;color: #fff;"/>
		</form>
		<span id="goto" style="margin-left: 92px;position:absolute;left:984px;top: 28px;">
			<a id="goto_order" href="/OrderListServlet" style="color:white;">我的订单</a>
			<a id="goto_cart" href="/cart/tocart" style="color:white;">我的购物车</a>
		</span>
	</div>
	<div id="line3">
		<div id="content">
			<ul>
				<li><a href="/index.jsp">首页</a></li>
				<li><a href="/prodList.action">全部商品</a></li>
				<li><a href="#">马丁系列</a></li>
				<li><a href="#">泰勒系列</a></li>
				<li><a href="#">产品</a></li>
				<li><a href="#">定制商店</a></li>
				<li><a href="#">新闻活动</a></li>
				<li><a href="#">艺术家</a></li>
				<li><a href="#">联系我们</a></li>
				<li><a href="#">如何购买</a></li>
			</ul>
		</div>
	</div>
</div>
