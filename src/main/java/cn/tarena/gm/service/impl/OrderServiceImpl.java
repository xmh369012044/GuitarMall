package cn.tarena.gm.service.impl;

import cn.tarena.gm.mapper.OrderMapper;
import cn.tarena.gm.mapper.ProductMapper1;
import cn.tarena.gm.pojo.Order;
import cn.tarena.gm.pojo.OrderInfo;
import cn.tarena.gm.pojo.OrderItem;
import cn.tarena.gm.pojo.Product;
import cn.tarena.gm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ProductMapper1 proMapper;
	@Override
	public List<OrderInfo> findAllByUserId(Integer userId) {
		List<OrderInfo> orderInfoList=new ArrayList<OrderInfo>();
		 List<Order> orderList= orderMapper.findAllByUserId(userId);
		 for(Order a:orderList){
			 OrderInfo orderInfo=new OrderInfo();
			 orderInfo.setOrder(a);
			 Map<Product, Integer> proMap=new HashMap<Product, Integer>();
			 List<OrderItem> orderItemList=orderMapper.findItemByOrderId(a.getId());
			 for(OrderItem b:orderItemList){
				 Product pro=proMapper.findProdById(b.getProduct_id());
				 proMap.put(pro, b.getBuynum());
			 }
			 orderInfo.setMap(proMap);
			 orderInfo.setOrder(a);
			 orderInfoList.add(orderInfo);
			 System.out.println(orderInfo);
		 }
		return orderInfoList;
	}
	@Override
	public Order findOrderById(String orderId) {
		// TODO Auto-generated method stub
		return orderMapper.findOrderById(orderId);
	}
	@Override
	public void deleteOrder(String orderId) {
		orderMapper.deleteOrder(orderId);
		orderMapper.deleteOrderItem(orderId);
	}
	@Override
	public void updatePaystate(String r6_Order, int i) { 
		orderMapper.updatePaystate(r6_Order,i);
		List<OrderItem> orderItemList=orderMapper.findItemByOrderId(r6_Order);
		for(OrderItem b:orderItemList){
			proMapper.findProdById(b.getProduct_id());
			proMapper.updateProNum(b.getProduct_id(),b.getBuynum());
		}
		
	}
	public List<OrderItem> findItemByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderMapper.findItemByOrderId(orderId);
	}
}
