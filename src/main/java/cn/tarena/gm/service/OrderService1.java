package cn.tarena.gm.service;

import cn.tarena.gm.exception.MsgException;
import cn.tarena.gm.pojo.Order;
import cn.tarena.gm.pojo.OrderItem;

import java.util.List;

public interface OrderService1 {

	void addOrder(Order order, List<OrderItem> orderItems)throws MsgException;

}
