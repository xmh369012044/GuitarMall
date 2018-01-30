package cn.tarena.gm.controller;

import cn.tarena.gm.pojo.OrderInfo;
import cn.tarena.gm.pojo.User;
import cn.tarena.gm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理订单列表的请求的类
 * @author Administrator
 *
 */
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	/**
	 * 查询全部订单信息 
	 * @return
	 */
	@RequestMapping("/OrderListServlet")
public String findAll(HttpSession session,Model model){
		User user =(User)session.getAttribute("userSession") ;
	Integer userId=user.getId();

	List<OrderInfo> orderList=orderService.findAllByUserId(userId);
	System.out.println(orderList);
	model.addAttribute("list", orderList);
	 return "/order/order_list";
	
}
	 @RequestMapping("/OrderDeleteServlet")
		public String deleteOrder(String id){
			 
			 
			 orderService.deleteOrder(id);
			
			 return"redirect:/OrderListServlet";
		 }

}

