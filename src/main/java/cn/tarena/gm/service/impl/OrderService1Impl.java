package cn.tarena.gm.service.impl;

import java.util.List;

import cn.tarena.gm.service.OrderService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.gm.exception.MsgException;
import cn.tarena.gm.mapper.OrderMapper1;
import cn.tarena.gm.mapper.ProductMapper1;
import cn.tarena.gm.pojo.Order;
import cn.tarena.gm.pojo.OrderItem;
import cn.tarena.gm.pojo.Product;
@Service
public class OrderService1Impl implements OrderService1 {
	@Autowired
	private OrderMapper1 orderMapper;
	@Autowired
	private ProductMapper1 productMapper;
	@Override
	public void addOrder(Order order, List<OrderItem> orderItems) throws MsgException {
		orderMapper.addOrder(order);
		for (OrderItem orderItem : orderItems) {
			Product product =productMapper.findProdById(orderItem.getProduct_id());
			if(product.getPnum()<orderItem.getBuynum()){
				throw new MsgException(product.getName()+"库存不足");
			}
			orderMapper.addOrderItem(orderItem);
		}
	}

}
