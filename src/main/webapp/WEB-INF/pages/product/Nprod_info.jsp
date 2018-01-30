<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>商品详情页面</title>
<link href="${app}/staticfile/css/prodInfo.css" rel="stylesheet"type="text/css">
<script type="text/javascript" class="library" src="${app}/staticfile/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" class="library" src="${app}/staticfile/js/jquery.colorbox-min.js"></script>
<script type="text/javascript" class="library" src="${app}/staticfile/js/zzsc.js"></script>
<script type="text/javascript"src="${app }/staticfile/js/jquery-1.4.2.js"></script>
<script type="text/javascript"src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript"src="${app}/staticfile/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${app}/staticfile/js/materialize.js"></script>
<script type="text/javascript" src="${app}/staticfile/js/init.js"></script>
<link rel="stylesheet" href="${app}/staticfile/css/materialize.css" />
<link rel="stylesheet" href="${app}/staticfile/css/regist.css" />
<link rel="stylesheet" type="text/css" href="${app}/staticfile/css/zzsc.css">
<style type="text/css">
.clear{
	clear:both;
}

</style>
<script type="text/javascript">
	$(function() {
		$(".add_cart_but")
				.click(
						function() {
							//获取商品输入框列表
							var num = $(this).parent().prev().find(
									"input[class=buyNumInp]").val();
							var id = $(this).parent().prev().find(
									"input[class=buyNumInp]").attr("id");
							window.location.href = "${pageContext.request.contextPath}/cart/addcart.action?pid="
									+ id + "&buynum=" + num;
						});

		$(".delNum").click(function() {
			//获取商品id
			//var id=$(this).next().attr("id");			
			//获取输入框的数量
			var num = $(this).next().val();
			num = num - 1;
			if (num > 0) {
				$(this).next().val(num);
			} else {
				$(this).next.val(1);
			}
		});

		$(".addNum").click(function() {
			//获取商品id
			//var id=$(this).prev().attr("id");
			//获取输入框的数量
			var num = $(this).prev().val();
			//num是String类型
			num = parseInt(num) + 1;
			$(this).prev().val(num);
		});

		$(".buyNumInp").blur(function() {
			//获取商品id
			var id = $(this).attr("id");
			//获取输入框数量
			var num = $(this).val();
			//获取隐藏域id
			var oldnum = $("#hid_" + id).val();
			//判断两个值是否相等
			if (num != oldnum) {
				if (/^[1-9][0-9]*$/.test(num)) {
					$(this).val(num);
				} else {
					//alert("请输入大于等于0的整数");
					$(this).val(oldnum);
				}

			}
		});

	});
</script>
</head>
<body
	style="background:url(${app}/staticfile/img/index/background.jpg);background-size:100% 100%;">
	<%@include file="../head.jsp"%>
	<div id="warp">
		<div id="left">
			<div id="left_top">
				<img src="${app}${product.imgurl}" style="cursor: pointer;" />
			</div>
	
			<div class="carousel" id="left_bottom">
				<a class="carousel-item" href="#one!"><img style="width: 66px;"
					src="${app}${product.imgurl}"></a> <a
					class="carousel-item" href="#two!"><img style="width: 66px;"
					src="${app}${product.imgurl}"></a> <a
					class="carousel-item" href="#three!"><img style="width: 66px;"
					src="${app}${product.imgurl}"></a> <a
					class="carousel-item" href="#four!"><img style="width: 66px;"
					src="${app}${product.imgurl}"></a> <a
					class="carousel-item" href="#five!"><img style="width: 66px;"
					src="${app}${product.imgurl}"></a>
			</div>
		</div>


		<div id="right">
			<div id="right_top">
				<span style="color: #fff;" id="prod_name">${product.name }<br/></span> <br> <span
					id="prod_desc" style="color: #fff;">${product.description }<br/></span>
			</div>
			<div id="right_middle">
				<span id="right_middle_span" style="color: #fff;padding-top: 0;margin-top: 16px;"> GuitarMall
					价：<span class="price_red">￥${product.price } <br /> 
					运 费：满300 免运费 <br /> 
					服 务：由GuitarMall负责发货，并提供售后服务 <br /> 
					库 存：${product.pnum } <br /> 
					购买数量： <a href="width:2%; void(0)" class="delNum" id="delNum" onclick="" style="color:#fff;">-</a>
						<input style=";margin-bottom: 0px;"class="buyNumInp" id="${product.id } " type="text" value="${bnum}" onblur="">
						<a href="javascript:void(0)" class="addNum"id="addNum" onclick="" style="color:#fff;">+</a> <br /> 
						<input type="hidden" id="hid_${product.id }" value="${bnum }" />
			</div>
			<div id="right_bottom">
				<input class="add_cart_but" type="button" onclick="" />
			</div>
		</div>
	</div>
</div>


<div style="width:1200px;text-align: center;"> 
<h3 style="text-align: center;color:#fff;">因没有高清图，所以商品无法展示放大镜效果，特写事例展示</h3>
<div class="con-FangDa" id="fangdajing";>
  <div class="con-fangDaIMg"  style="width:394px;">
  	
  	<img src="${app}/staticfile/img/big/1.jpg">
    
    <div class="magnifyingBegin"></div>
   
    <div class="magnifyingShow"><img src="${app}/staticfile/img/big/1.jpg"></div>
  </div>
  
  <ul class="con-FangDa-ImgList">
    
    <li class="active"><img src="${app}/staticfile/img/thumb/1.jpg" data-bigimg="${app}/staticfile/img/big/1.jpg"></li>
    <li><img src="${app}/staticfile/img/thumb/2.jpg" data-bigimg="${app}/staticfile/img/big/2.jpg"></li>
    <li><img src="${app}/staticfile/img/thumb/3.jpg" data-bigimg="${app}/staticfile/img/big/3.jpg"></li>
    <li><img src="${app}/staticfile/img/thumb/4.jpg" data-bigimg="${app}/staticfile/img/big/4.jpg"></li>
    <li><img src="${app}/staticfile/img/thumb/5.jpg" data-bigimg="${app}/staticfile/img/big/5.jpg"></li>
  </ul>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>
</div>

<script type="text/javascript">

$(document).ready(function(){
$('.carousel').carousel();
});
</script>
	<%@include file="../foot.jsp"%>
</body>
</html>
