<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="${app}/staticfile/css/login.css"/>
	<title>GuitarMall欢迎您登陆</title>
	<script type="text/javascript" src="${app}/staticfile/js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$(function(){
			var uname = "${cookie.remname.value }";
			$("#username").val(uname);
		});
	</script>
</head>


<body style="background:url(${app}/staticfile/img/index/background.jpg);background-size:100% 100%;">

<a href="http://localhost:8090/index.jsp" style=" text-decoration:none;background-image: url('../staticfile/img/login/denglu.jpg');width:200px;height:50px;border-style:none;font-size:20px;font-weight:bold;color:white;cursor: pointer;box-shadow:10px 10px 66px 16px #ccc;border-radius:50px;background-color: #2B1900;">&nbsp;&nbsp;返回主页&nbsp;&nbsp; </a>
<h1 style="width: 649px;text-align: center;margin-top: 142px;color: #fff;font-size: 80px;text-shadow:0px 0px 0 rgb(221,213,213),-1px -1px 0 rgb(206,198,198),-2px -2px 0 rgb(192,184,184),-3px -3px 0 rgb(177,169,169),-4px -4px 0 rgb(163,155,155),-5px -5px 0 rgb(148,140,140), -6px -6px 0 rgb(134,126,126),-7px -7px 6px rgba(0,0,0,0.6),-7px -7px 1px rgba(0,0,0,0.5),0px 0px 6px rgba(0,0,0,.2); font-family:'Microsoft YaHei';}">欢迎登陆天籁琴行</h1>
<form action="${app}/tologin" method="post">
	<table style="box-shadow:10px 10px 66px 16px #ccc inset;border-radius:50px;background-color: #2B1900;width:400px;height:400px;text-align: center;">
		<tr>
			<td class="tdx" style="color: #fff;padding-left: 44px;padding-top: 50px;">用&nbsp;户&nbsp;名：</td>
			<td style="padding-top: 50px;"><input type="text" id="username" name="username" value=""/>
				<span style="color:red">${UerrorInfo}</span>
			</td>
		</tr>
		<tr>
			<td class="tdx" style="color: #fff;padding-left: 44px;">密&nbsp;&nbsp; 码：</td>
			<td><input type="password" name="password"/>
				<span style="color:red">${PerrorInfo}</span>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="checkbox" name="remname" value="true"/>
				<a style="color: #fff;">记住用户名</a>
				<input type="checkbox" name="autologin" value="true"/>
				<a style="color: #fff;">30天内自动登陆</a>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="登陆"/>
				<input type="submit" value="忘记密码" style="margin-left: 60px;"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<span style="color:red">${msg}</span>
			</td>
		</tr>
	</table>
</form>
</body>
</html>

  