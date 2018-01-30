<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../base.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>我的购物车</title>
 	<link href="${app }/staticfile/css/cart.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${app }/staticfile/js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
	$(function(){
		$(".del").click(function(){
			if(confirm("您确定删除吗？")){
				var id = $(this).parent().parent().find("input[class=buyNumInp1]").attr("id");
				window.location.href="${app}/cart/del?pid="+id;
			}
		});
	$(".delNum").click(function(){
		//1获取商品的id
		var id = $(this).next().attr("id");
		//2获取输入框中数量
		var num = $(this).next().val();
		//3、计算减1后的值
		num = num-1;
		if(num>0){
			//4、跳转
			window.location.href="${app}/cart/edit?pid="+id+"&buynum="+num;
		}else{
			if(confirm("您确认删除吗？")){
				window.location.href="${app}/cart/del?pid="+id;
			}
		}
	});
	$(".addNum").click(function(){
		//1.获取商品id
		var id = $(this).prev().attr("id");
		//2获取输入框中数量
		var num = $(this).prev().val();
		//3计算数量
		num = parseInt(num)+1;
		//4跳转
		window.location.href="${app}/cart/edit?pid="+id+"&buynum="+num;
	});
	$(".buyNumInp1").blur(function(){
		//获取输入框中的数量
		var num = $(this).val();
		//获取商品id
		var id = $(this).attr("id");
		//获取隐藏域中的值
		var oldNum = $("#hid_"+id).val();
		//如果num!=oldNum才执行修改操作
		if(num!=oldNum){
			//判断是否为0，
			if(num==0){//执行删除
				window.location.href="${app}/cart/del?pid="+id;
			}else if(/^[1-9][0-9]*$/.test(num)){
				//判断输入的数据是否合法
				window.location.href="${app}/cart/edit?pid="+id+"&buynum="+num;
			}else{
				alert("请输入大于等于0的整数！");
				//回显  text() html() attr("..")
				$(this).val(oldNum);
			}
		}
	});
});
	</script>
	</head>
<body style="background:url(${app}/staticfile/img/index/background.jpg);background-size:100% 50%;">
<%@include file="../head.jsp" %>
	<div class="warp">
	${msg }
		<!-- 标题信息 -->
		<div id="title">
			<input name="allC" type="checkbox" value="" onclick=""/>
			<span id="title_checkall_text">全选</span>
			<span id="title_name">商品</span>
			<span id="title_price">单价（元）</span>
			<span id="title_buynum">数量</span>
			<span id="title_money">小计（元）</span>
			<span id="title_del">操作</span>
		</div>
		<!-- 购物信息 -->
	<c:set var="money" value="0"/>
	<c:forEach items="${cart}" var="entry">
		<div id="prods">
			<input name="prodC" type="checkbox" value=""/>
			<img src="${app }${entry.key.imgurl}" width="90" height="90" />
			<span id="prods_name">${entry.key.name }</span>
			<span id="prods_price">${entry.key.price }</span>
			<span id="prods_buynum"> 
				<input type="hidden" id="hid_${entry.key.id }" value="${entry.value }"/>
				<a href="javascript:void(0)" class="delNum" >-</a>
				<input class="buyNumInp1" id="${entry.key.id }"  type="text" value="${entry.value }" >
				<a href="javascript:void(0)" class="addNum" >+</a>
			</span>
			<span id="prods_money">${entry.key.price*entry.value }</span>
			<c:set var="money" value="${money+entry.key.price*entry.value }"/>
			<span id="prods_del">
			  <a href="javascript:void(0)" class="del">删除</a>
			</span>
		</div>
	</c:forEach>
		<!-- 总计条 -->
		<div id="total">
			<div id="total_1">
				<input name="allC" type="checkbox" value=""/> 
				<span style="color: #fff;">全选</span>
				<a id="del_a" href="#" style="color: #fff;">删除选中的商品</a>
				<span id="span_1" style="color: #fff;">总价：</span>
				<span id="span_2">￥${money }</span>
			</div>
			<div id="total_2">	
				<a id="goto_order" href="${app }/cart/toaddorder">去结算</a>
			</div>
		</div>
	</div>
<%@include file="../foot.jsp" %>

</body>
</html>