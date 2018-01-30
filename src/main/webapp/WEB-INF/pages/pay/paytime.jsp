<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="shortcut icon" href="http://www.zhangxinxu.com/zxx_ico.png" />
	<link rel="stylesheet" href="../css/common.css" type="text/css" />
	<script type="text/javascript" src="${app}/staticfile/js/jquery-1.4.2.js"></script>
	<style type="text/css">
		body{
			background: #eeeeee;
		}
		.date-head{
			width:100%;
		}
		.date-head-statue{
			width:100%;
			font-size:14px;
			border-radius:4px;
			padding-left:15px;
			padding-right:15px;
		}
		.date-head-state{
			background: #fff;
			height: 240px;
			border-radius: 10px;
			margin-top: 16px;
			padding-top: 14px;
			position: relative;
		}
		/*.set-detail-number a{
         color: #333333;
        }*/
		/*.section-body .set-text-button .set-text-button a{
         color: #1c94f7;
        }*/
		.reservation-status,.order-number,.total-order,.order-status,.payment-status,.pay-immediately,.pay-immediately-count{
			display: -moz-box;
			-moz-box-orient: horizontal;
			display: -webkit-box;
			-webkit-box-orient: horizontal;
		}
		.order-number,.total-order,.order-status,.payment-status{
			margin-top: 10px;
		}
		.pay-immediately{
			position: absolute;
			bottom: 0px;
			width: 100%;
			/* margin-top: 16px; */
		}
		.space-underline {
			border-bottom: 1px solid #999999;
			/*margin-top: 12px;*/
			-webkit-transform:scaleY(0.2);
			-moz-transform:scaleY(0.2);
			-o-transform:scaleY(0.2);
		}
		.reservation-status div:nth-of-type(2){
			position: absolute;
			right: 0px;
			margin-right: 90px;
			color: #999999;
		}
		.reservation-status div:nth-of-type(3){
			position: absolute;
			right: 0px;
			margin-right: 26px;
			color: #999999;
		}
		.order-number div:nth-of-type(2),.total-order div:nth-of-type(2),.order-status div:nth-of-type(2),.payment-status div:nth-of-type(2) {
			position: absolute;
			left: 0px;
			margin-left: 130px;
		}

		.reservation-status,.order-number ,.total-order ,.order-status,.payment-status{
			/*position: absolute;
            left: 0px;
            margin-left: 130px;*/
			padding-left: 12px;
		}
		.payment-status div:nth-of-type(3) {
			position: absolute;
			left: 0px;
			margin-left: 200px;
			color: #1c94f7;
		}
		.cancel-order{
			width: 100%;
		}
		.pay-immediately div:nth-of-type(1){
			width: 70%;
			background: #1c94f7;
			height: 40px;
			line-height: 40px;
			text-align: center;
			border-radius: 0px 0px 0px 10px;
			color: #ffffff;
			paddingleft: 20p;
			padding-left: 20px;
			white-space: nowrap;
		}
		.pay-immediately div:nth-of-type(2){
			width: 30%;
			height: 40px;
			background: #097bd9;
			boder-radus: 5px;
			/* border-radius: 5px; */
			line-height: 40px;
			text-align: center;
			border-radius: 0px 0px 10px 0px;
			color: #ffffff;
		}
		.wide-space_line {
			height: 30px;
			width: 100%;
			background: #eeeeee;
			text-align: center;
		}
		.wide-space_line div:nth-of-type(1) {
			margin-top: 7px;
			position: absolute;
			left: 0px;
			margin-left: 16px;
			font-size: 15px;
			color: #999999;
		}
		.total-order div:nth-of-type(2){
			color:#ff5e38;
			font-size: 16px;
			font-weight: bold;
		}
		.order-status div:nth-of-type(2){
			color: #1c94f7;
		}
		.check-in-time,.room-type,.booking-person,.special-requirements{
			display: -moz-box;
			-moz-box-orient: horizontal;
			display: -webkit-box;
			-webkit-box-orient: horizontal;
			margin-left: 16px;
		}
		.check-in-time div:nth-of-type(1),.room-type div:nth-of-type(1),.booking-person div:nth-of-type(1),.special-requirements div:nth-of-type(1){
			color: #999999;
		}
		.check-in-time div:nth-of-type(2),.room-type div:nth-of-type(2),.booking-person div:nth-of-type(2),.special-requirements div:nth-of-type(2){
			color: #333;
			position: absolute;
			left: 0px;
			margin-left: 98px;
		}
		/*.check-in-time div:nth-of-type(3),.room-type div:nth-of-type(3),.booking-person div:nth-of-type(3){
         color: #333;
         position: absolute;
         left: 0px;
         margin-left: 60px;
        }*/
		.check-in-time div:nth-of-type(3){
			color: #333;
			position: absolute;
			left: 0px;
			margin-left: 222px;
		}
		.room-type div:nth-of-type(3){
			color: #333;
			position: absolute;
			left: 0px;
			margin-left: 152px;
		}
		.booking-person div:nth-of-type(3){
			color: #333;
			position: absolute;
			left: 0px;
			margin-left: 152px;
		}
		.check-information{
			background: #ffffff;
			height: 128px;
		}
		.check-in-time{
			padding-top: 10px;
			margin-top: 10px;
		}
		.room-type,.booking-person,.special-requirements{
			padding-top: 10px;
		}

		/*中间列表样式**************************************************************************/
		.section-body .set-detail,.section-body .set-detail-number,.section-body .set-detail-address{
			display: -moz-box;
			-moz-box-orient: horizontal;

			display: -webkit-box;
			-webkit-box-orient: horizontal;

			margin-left: 10px;
		}
		.set-detail,.set-detail-number{
			padding-top: 13px;
			padding-bottom: 13px;
			text-align: center;
			/* border-bottom: 1px solid #999999;
             -webkit-border-image: url(../../images/hotel/border.gif) 1 stretch;*/
		}
		.set-detail-address{
			padding-top: 10px;
			padding-bottom: 10px;
			text-align: center;
		}
		@font-face{
			font-family:"font-name-icon";
			font-weight:normal;
			font-style:normal;
		}
		.font-name-icon{
			font-family: "font-name-icon";
			font-weight: normal;
			font-style: normal;
			font-size: 15px;
			-webkit-font-smoothing: antialiased;
			-moz-osx-font-smoothing: grayscale;

		}
		.first-icon{
			color: #999999;
		}
		.second-icon{
			margin-left: 5px;
		}
		.set-text-button{
			position: absolute;
			right: 0px;
			margin-right: 24px;
			font-size: 14px;
			color: #1c94f7;
		}
		.greater-number {
			position: absolute;
			right: 0;
			margin-right: 10px;
			margin-top: 4px;
			display: inline-block;
			width: 8px;
			height: 8px;
			border-top: 1px solid #999;
			border-right: 1px solid #999;
			-webkit-transform: rotate(45deg);
			-moz-transform: rotate(45deg);
			-o-transform: rotate(45deg);
		}
		.greater-number-bottom{
			position: absolute;
			right: 0;
			margin-right: 10px;
			margin-top: 7px;
			display: inline-block;
			width: 4px;
			height: 8px;
			border-top: 1px solid #999;
			border-right: 1px solid #999;
			-webkit-transform: rotate(45deg);
			-moz-transform: rotate(45deg);
			-o-transform: rotate(45deg);
		}
		.set-detail,.set-detail-number{
			padding-top: 13px;
			padding-bottom: 13px;
			text-align: center;
			/* border-bottom: 1px solid #999999;
             -webkit-border-image: url(../../images/hotel/border.gif) 1 stretch;*/
		}
		.set-text-detail{
			margin-left: 10px;
			font-size: 13px;
		}
		.set-text-detail2 .aa{
			margin-left: 15px;
			font-size: 13px;
			color: #333333;
		}
		.set-detail-address{
			padding-top: 10px;
			padding-bottom: 10px;
			text-align: center;
		}
		.set-text-shut{
			white-space: nowrap;
			text-overflow: ellipsis;
			overflow: hidden;
			width: 221px;
		}
		.set-text-button{
			position: absolute;
			right: 0px;
			margin-right: 24px;
			font-size: 14px;
			color: #1c94f7;
		}
		.set-text-button .bb{
			color: #1c94f7;
		}
		.space_line{
			height: 10px;
			width: 100%;
			background: #eeeeee;
		}
		.section-body{
			background: #ffffff;
		}
		/*底部按钮样式**************************************************************************/
		.footer{
			display: -moz-box;
			-moz-box-orient: horizontal;

			display: -webkit-box;
			-webkit-box-orient: horizontal;
		}
		.greater-number-bottom{
			position: absolute;
			right: 0;
			margin-right: 10px;
			margin-top: 6px;
			display: inline-block;
			width: 8px;
			height: 8px;
			border-top: 1px solid #999;
			border-right: 1px solid #999;
			-webkit-transform: rotate(45deg);
			-moz-transform: rotate(45deg);
			-o-transform: rotate(45deg);
		}
		.ellipse{
			width: 26px;
			height: 18px;
			display: block;
			border-radius: 8px;
			background: #1c94f7;
			color: #ffffff;
			position: absolute;
			right: 0px;
			margin-right: 18px;
			margin-top: -17px;
			padding-right: 6px;
			font-size: 10px;
			text-align: center;
			line-height: 18px;
		}
		.footer{
			display: -moz-box;
			-moz-box-orient: horizontal;
			display: -webkit-box;
			-webkit-box-orient: horizontal;
			position: relative;
			bottom: 0px;
			width: 100%;
			height: 40px;
			/* background: #fff; */
			margin-top: 50px;
			/* padding-top: 50px; */
		}
		.footer div:nth-of-type(1){
			padding-top: 11px;
			width: 50%;
			border-right: 1px solid #eeeeee;
			background-color: white;
			text-align: center;
		}
		.footer div:nth-of-type(2){
			padding-top: 12px;
			width: 50%;
			padding-left: 28px;
			background-color: white;
		}
		.footer span{
			padding-left: 5px;
		}

		.pay-immediately div:nth-of-type(3){
			display: none;
		}
		/*倒计时样式**************************************************************************/

		.time-item {
			background: #C71C60;
			color: #fff;
			line-height: 40px;
			font-size: 14px;
			font-family: Arial;
			padding: 0 10px;
			border-radius: 5px;

		}
		#day_show {
			float:left;
			line-height:40px;
			color:#ffffff;
			font-size:14px;
			margin:0 10px;
			font-family:Arial,Helvetica,sans-serif;
		}
		.item-title .unit {
			background:none;
			line-height:40px;
			font-size:14px;
			padding:0 10px;
			float:left;
		}
		.pay-immediately-count-num{
			display: -moz-box;
			-moz-box-orient: horizontal;

			display: -webkit-box;
			-webkit-box-orient: horizontal;
		}
		.del-order{
			display: none;
			text-align: center;
			background: #999999;
			height: 40px;
			border-radius: 0px 0px 10px 10px;
			position: absolute;
			bottom: 0px;
			width: 100%;
			color: #fff;
			line-height: 40px;
		}
		  .arrow_mask {
			  position: absolute;
			  top: 0;
			  left: 0;
			  bottom: 0;
			  right: 0;
			  z-index: 1;
			  background: #333333;
			  opacity: 0.55;
			  display: none;
		  }
		.cancel-order-dialog{
			display: none;
			width: 260px;
			height: 206px;
			background: #fff;
			border-radius: 6px;
			position: absolute;
			top: 0px;
			margin-top: 200px;
			left: 50%;
			margin-left: -130px;
			z-index: 1;
			padding-top: 33px;
		}
		.cancel-dialog div:nth-of-type(1){
			text-align: center;
			/* border-right: 1px solid #999;
            padding: 10px;
            border-top: 1px solid #999;*/
		}
		.cancel-dialog-btn{
			display: -moz-box;
			-moz-box-orient: horizontal;
			display: -webkit-box;
			-webkit-box-orient: horizontal;
			/* margin-top: -8px;*/
		}
		.cancel-dialog-btn div:nth-of-type(1){
			width: 130px;
			border-right: 1px solid #999;
			padding: 10px;
			border-top: 1px solid #999;
		}

		.cancel-dialog-btn div:nth-of-type(2){
			width: 130px;
			text-align: center;
			padding: 10px;
			border-top: 1px solid #999;
		}

		.space-underline2 {
			margin-top: 116px;
		}
		.space-underline3 {
			width: 100%;
			height: 10px;
			-webkit-transform: scaleX(0.2);
			-moz-transform: scaleX(0.2);
		}



		*{margin:0;padding:0;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);-webkit-box-sizing: border-box;-moz-box-sizing: border-box;}

		html {
			min-height: 100%;
			font-size: 100%;
			-webkit-text-size-adjust: 100%;
			-ms-text-size-adjust: 100%;
		}

		body {
			width: 100%;
			min-height: 100%;
			font-family:"Microsoft YaHei","微软雅黑","MicrosoftJhengHei","华文细黑","Helvetica", "Arial", "sans-serif";
			font-size: 14px;
			position: relative;
			word-break:break-all;
		}

		a {
			text-decoration: none;
			-webkit-tap-highlight-color: rgba(0, 0, 0, 0.35);
			-webkit-box-sizing:border-box;
		}

		img {
			-ms-interpolation-mode: bicubic;
			vertical-align: middle;
		}

		img:not([src*="/"]) {
			display: none;
		}

		table {
			border-collapse: collapse;
			border-spacing: 0;
		}

		textarea {
			resize: none;
		}

		input, button, select, textarea {
			-webkit-appearance:none;
			outline: none;
			border-radius: 0;
		}
		input::-webkit-outer-spin-button,
		input::-webkit-inner-spin-button {
			-webkit-appearance: none !important;
			margin: 0;
		}
		ul,ol,li {
			list-style: none;
			-webkit-margin-before: 0;
			-webkit-margin-after: 0;
			-webkit-margin-start: 0;
			-webkit-margin-end: 0;
			-webkit-padding-start: 0;
		}
		.section-body .text {
			margin-top: 24px;
			margin-left: 40px;
			margin-right: 35px;
			width: 84%;
			font-family: "宋体";
			font-size: 18px;
		}
		.section-body .textImg{
			margin-top: 45px;
			color: blue;
			text-align: center;
			vertical-align: middle;
		}
	</style>
	<script type="text/javascript" src="${app}/staticfile/js/jquery.js"></script>
	<script type="text/javascript" src="${app}/staticfile/js/jqzoom.js"></script>
	<script type="text/javascript">
		$(function () {        //加载完DOM的只执行函数
			var intDiff = parseInt(10000);    //倒计时总秒数量
			function timer(intDiff) {
				window.setInterval(function () {
					var day = 0,
							hour = 0,
							minute = 0,
							second = 0;//时间默认值
					if (intDiff > 0) {
						//计算相关的天，小时，还有分钟，以及秒
						day = Math.floor(intDiff / (60 * 60 * 24));
						hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
						minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
						second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
					}
					if (minute <= 9) minute = '0' + minute;
					if (second <= 9) second = '0' + second;
					$('#day_show').html(day + "天");
					$('#hour_show').html('<s id="h"></s>' + hour + '时');
					$('#minute_show').html('<s></s>' + minute + '分');
					$('#second_show').html('<s></s>' + second + '秒');
					intDiff--;
				}, 1000);
				//循环函数，是时钟运动起来
				setInterval(function(){
					if($('#minute_show').text() =='00分' && $('#second_show').text() =='00秒'){
						$('.pay-immediately-count').remove();
						$('.cancle-order').remove();
						$('.del-order').show();
						clearInterval();
					}
				},1000)

				//下面三个是跳转链接，本来是在node工程里面的路由配置的，这里大家可以换成自己的链接

				$("#dingdan").click(function () {
					location.href = "/hotel/order"; //这里跳转的是路由的路径
				});
				$("#mengdian").click(function () {
					location.href = "/hotel"; //这里跳转的是路由的路径
				});
				$(".set-detail").click(function () {
					location.href = "/hotel/detail"; //这里跳转的是路由的路径
				});

				//这里都是一些单击事件

				/* 点击删除按钮*/
				$('.del-order').click(function(){
					$(".arrow_mask").show();
					$(".cancel-order-dialog").show()
				})
				/* 弹框的设置---取消键*/
				$(".cancle-order-btn").click(function(){
					$(".cancel-order-dialog").hide();
					$(".arrow_mask").hide();
				});
				/* 弹框的设置---确定键*/
				$(".certain-order").click(function(){
					$(".section-first").remove();
					$(".cancel-order-dialog").remove();
					$(".arrow_mask").remove();
					$(".footer").css({"position":"fixed"});
				});
				/* 弹框的设置---取消键*/
				$(".cancle-order").click(function(){
					$(".section-first").remove();
					$(".footer").css({"position":"fixed"});
				});

			}
			//执行上面的函数
			$(function () {
				timer(intDiff);
			});

		});
	</script>
</head>

<body>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta charset="utf-8">
	<meta content="" name="description">
	<meta content="" name="keywords">
	<meta content="eric.wu" name="author">
	<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
	<meta property="qc:admins" />
	<meta content="telephone=no, address=no" name="format-detection">

	<!--添加title前面的图片(这里换成你自己图片的路径即可)-->
	<link rel="shortcut icon" href="/images/hotel/zc.png" type="image/x-icon" />

	<!--页面初始化的样子（这个文件可以页面做初始化）-->
	<link href="/css/hotel/order_detail.css" rel="stylesheet" type="text/css" />

	<!--引入JQ文件-->
	<script type="text/javascript" src="/javascripts/lib-cmd/jquery.min2.js"></script>

	<!--引入页面操作的JS文件-->
</head>
<body>
<div class="section-first">
	<div class="date-head">
		<div class="date-head-statue">
			<ul class="date-head-state">
				<li>
					<div class="reservation-status">

				<li>
					<div class="order-status">
						<div>订单状态：</div>
						<div>处理中</div><br>
						订单号:${p2_Order }<br>
						支付金额:${p3_Amt }
					</div>
				</li>
				<li>
					<div class="payment-status">
						<div>支付状态：</div>
						<div>线上支付 </div>
						<div>未支付</div>
					</div>
				</li>
				<form action="https://www.yeepay.com/app-merchant-proxy/node" method="post" >
					<input type="hidden" name="pd_FrpId" value="${pd_FrpId }" />
					<input type="hidden" name="p0_Cmd" value="${p0_Cmd }" />
					<input type="hidden" name="p1_MerId" value="${p1_MerId }" />
					<input type="hidden" name="p2_Order" value="${p2_Order }" />
					<input type="hidden" name="p3_Amt" value="${p3_Amt }" />
					<input type="hidden" name="p4_Cur" value="${p4_Cur }" />
					<input type="hidden" name="p5_Pid" value="${p5_Pid }" />
					<input type="hidden" name="p6_Pcat" value="${p6_Pcat }" />
					<input type="hidden" name="p7_Pdesc" value="${p7_Pdesc }" />
					<input type="hidden" name="p8_Url" value="${p8_Url }" />
					<input type="hidden" name="p9_SAF" value="${p9_SAF }" />
					<input type="hidden" name="pa_MP" value="${pa_MP }" />
					<input type="hidden" name="pr_NeedResponse" value="${pr_NeedResponse }" />
					<input type="hidden" name="hmac" value="${hmac}" />
					<input type="submit" value="确认支付"style="position: absolute; top: 206px;left: 33px;z-index: 1;background-color: #1c94f7;border: 0;color: #fff;width: 111px; height: 28px;"/>
				</form>
				<li class="cancel-order">
					<div class="pay-immediately">
						<div class="pay-immediately-count">
							<div class="pay-immediately-count-num">立即支付
								<div class="time-item">

									<!--<span id="day_show">0天</span>
                                    <strong id="hour_show">0时</strong>-->
									<span id="minute_show">0分</span>
									<span id="second_show">0秒</span>
								</div>
							</div>
						</div>
						<div class="cancle-order">取消订单</div>
						<form action="paycancle">
							<input type="hidden" name="p2_Order" value="${p2_Order }" />
							<input type="hidden" name="p3_Amt" value="${p3_Amt }" />
							<a href="http://localhost:8090/OrderListServlet"><input type="" value="支付取消"style="text-align:center;cursor: pointer; position: absolute;top: 0px;left: 941px;z-index: 1;background-color: #097bd9;border: 0;color: #fff;width: 421px;height: 39px;"/></a>
						</form>
						<span class="del-order">删除订单</span>
					</div>

					<!--<div class="space-underline"></div>-->
			</ul>
		</div>

		<div class="arrow_mask"></div>
		<!--取消的弹框-->
		<div class="cancel-order-dialog">
			<div class="cancel-dialog">
				<div>你确定要取消该订单吗？</div>
				<div class="space-underline2"></div>
				<div class="shuxian"></div>
				<div class="cancel-dialog-btn">
					<div class="cancle-order-btn">取消</div>
					<div class="certain-order">确定</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
