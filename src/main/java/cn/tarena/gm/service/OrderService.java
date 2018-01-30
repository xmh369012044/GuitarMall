package cn.tarena.gm.service;

import cn.tarena.gm.pojo.Order;
import cn.tarena.gm.pojo.OrderInfo;
import cn.tarena.gm.pojo.OrderItem;

import java.util.List;

/**
 * 处理订单的业务层
 * @author Administrator
 *
 */
public interface OrderService {

	List<OrderInfo> findAllByUserId(Integer userId);

	Order findOrderById(String orderId);

	void deleteOrder(String id);

	void updatePaystate(String r6_Order, int i);

	List<OrderItem> findItemByOrderId(String orderId);

}
