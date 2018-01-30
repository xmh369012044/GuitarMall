package cn.tarena.gm.controller;

import cn.tarena.gm.service.OrderService;
import cn.tarena.gm.tool.PaymentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
@Controller
public class PayController {
	private static Properties prop;
	static{
		prop = new Properties();
		String path=PayController.class.getClassLoader().
				getResource("merchantInfo.properties").getPath();
		try {
			prop.load(new FileInputStream(new File(path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Autowired
	private OrderService orderService;
	@RequestMapping("topay")
	public String toPay(String orderId,String orderMoney,Model model){
		model.addAttribute("orderId", orderId);
		model.addAttribute("orderMoney", orderMoney);
		return"/pay/pay";
	}
	@RequestMapping("PayServlet")
public String payOrder(String orderId,String orderMoney,String pd_FrpId, Model model,HttpServletRequest request){
	//2.查询订单的金额
	//3、准备第三方支付平台需要参数
	String p0_Cmd="Buy";
	//商品标识号
	String p1_MerId=prop.getProperty("p1_MerId");
	String p2_Order = orderId;//订单id
	//测试使用0.01
	String p3_Amt = "0.01";//支付金额
	//正式使用改回来
	//String p3_Amt = money+"";
	String p4_Cur="CNY";//币种：人民币
	String p5_Pid="";//商品名称
	String p6_Pcat="";//商品种类
	String p7_Pdesc = "";//商品描述
	//重定向和点对点通讯
	String p8_Url = prop.getProperty("responseURL");
	String p9_SAF ="";//收货地址
	String pa_MP = "";//商户的扩展信息
	//支付通道编码
	String pr_NeedResponse = "1";//应答机制
	String hmac = PaymentUtil.buildHmac(p0_Cmd, 
			p1_MerId, p2_Order, p3_Amt, p4_Cur, 
			p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, 
			p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, 
			prop.getProperty("keyValue"));
	//4保存到request作用域中
	request.setAttribute("pd_FrpId", pd_FrpId);
	request.setAttribute("p0_Cmd", p0_Cmd);
	request.setAttribute("p1_MerId", p1_MerId);
	request.setAttribute("p2_Order", p2_Order);
	request.setAttribute("p3_Amt", p3_Amt);
	request.setAttribute("p4_Cur", p4_Cur);
	request.setAttribute("p5_Pid", p5_Pid);
	request.setAttribute("p6_Pcat", p6_Pcat);
	request.setAttribute("p7_Pdesc", p7_Pdesc);
	request.setAttribute("p8_Url", p8_Url);
	request.setAttribute("p9_SAF", p9_SAF);
	request.setAttribute("pa_MP", pa_MP);
	request.setAttribute("pr_NeedResponse", pr_NeedResponse);
	request.setAttribute("hmac", hmac);
	return"pay/paytime";
}
	@RequestMapping("/CallBackServlet")
	public String callBackServlet(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		// 获得回调所有数据
		
				String p1_MerId = request.getParameter("p1_MerId");
				String r0_Cmd = request.getParameter("r0_Cmd");
				String r1_Code = request.getParameter("r1_Code");
				String r2_TrxId = request.getParameter("r2_TrxId");
				String r3_Amt = request.getParameter("r3_Amt");
				String r4_Cur = request.getParameter("r4_Cur");
				String r5_Pid = request.getParameter("r5_Pid");
				String r6_Order = request.getParameter("r6_Order");
				String r7_Uid = request.getParameter("r7_Uid");
				String r8_MP = request.getParameter("r8_MP");
				String r9_BType = request.getParameter("r9_BType");
				String rb_BankId = request.getParameter("rb_BankId");
				String ro_BankOrderId = request.getParameter("ro_BankOrderId");
				String rp_PayDate = request.getParameter("rp_PayDate");
				String rq_CardNo = request.getParameter("rq_CardNo");
				String ru_Trxtime = request.getParameter("ru_Trxtime");
				//获取加密后值
				String hmac = request.getParameter("hmac");
				String keyValue=prop.getProperty("keyValue");
				//判断数据是否被篡改
				boolean result = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
				model.addAttribute("r6_Order", r6_Order);
				if(result){//未被篡改
					if("1".equals(r9_BType)){
						response.getWriter().write("支付已提交，支付结果还需等待银行通知...");
						//测试保留，部署前删除！！！！
						//修改库存
						//1表示已经支付
						orderService.updatePaystate(r6_Order,1);
					}else if("2".equals(r9_BType)){//点对点通讯
						if("1".equals(r1_Code)){//支付成功
							//修改库存
							//1表示已经支付
							orderService.updatePaystate(r6_Order,1);
							//给第三方支付平台响应success
							response.getWriter().write("success");
						}else{//支付失败
							model.addAttribute("error", "支付失败！");
							return"/error";
						}
					}
				}else{
					model.addAttribute("error", "数据被篡改！！");
					return" /error";
				}
				System.out.println(1);
		return"redirect:/OrderListServlet";
	}
	@RequestMapping("/paycancle")
	public String payCancle (String p2_Order ,String p3_Amt,Model model){
		model.addAttribute("p2_Order",p2_Order );
		System.out.println(p3_Amt);
		model.addAttribute("p3_Amt",p3_Amt);
		model.addAttribute("error","订单支付已取消");
		return"error";
	}
}
