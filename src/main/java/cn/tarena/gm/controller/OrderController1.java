package cn.tarena.gm.controller;

import cn.tarena.gm.exception.MsgException;
import cn.tarena.gm.pojo.Order;
import cn.tarena.gm.pojo.OrderItem;
import cn.tarena.gm.pojo.Product;
import cn.tarena.gm.pojo.User;
import cn.tarena.gm.service.OrderService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController1 {
	@Autowired
	private OrderService1 orderService;

	@RequestMapping("/addorder")
	public String addOrder(String receiverinfo, HttpSession session, Model model) {
		if (receiverinfo == null || "".equals(receiverinfo)) {
			model.addAttribute("errormsg", "请输入收货地址");
			return "/order/order_add";
		}
		User user = null;
		/***
		 * 写完用户登录后添加
		 */

		if(session.getAttribute("userSession")==null){
		 model.addAttribute("errormsg", "请登录"); return "/cart/toaddorder"; }


		 // user 可能会与系统冲突,上线时注意
     	 user = (User) session.getAttribute("userSession");
     	 // user应该通过session获取


		/*
		 * 测试使用数据
		 */
		Order order = new Order();
		String orderId = UUID.randomUUID().toString();
		order.setId(orderId);
		order.setOrdertime(new Date());
		order.setPaystate(0);
		order.setReceiverinfo(receiverinfo);
		order.setUser_id(user.getId());
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Map<Product, Integer> map = (Map<Product, Integer>) session.getAttribute("cart");
		Double money = 0.00;
		for (Map.Entry<Product, Integer> entry : map.entrySet()) {
			money = money + entry.getValue() * entry.getKey().getPrice();
			OrderItem orderItem = new OrderItem();
			String productId = entry.getKey().getId();
			Integer buynum = entry.getValue();
			orderItem.setBuynum(buynum);
			orderItem.setOrder_id(orderId);
			orderItem.setProduct_id(productId);
			orderItems.add(orderItem);
		}
		order.setMoney(money);
		try {
			orderService.addOrder(order,orderItems);
		} catch (MsgException e) {
			model.addAttribute("errormsg", e.getMessage());
			return "/order/order_add";
		}
		/**
		 * 根据具体页面跳转
		 */
		return "redirect:/OrderListServlet";

	}
}
