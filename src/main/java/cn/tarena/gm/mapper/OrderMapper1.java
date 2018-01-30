package cn.tarena.gm.mapper;

import cn.tarena.gm.pojo.Order;
import cn.tarena.gm.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper1 {

	void addOrder(Order order);

	void addOrderItem(OrderItem orderItem);

}
