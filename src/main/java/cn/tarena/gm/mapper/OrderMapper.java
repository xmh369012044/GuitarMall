package cn.tarena.gm.mapper;

import cn.tarena.gm.pojo.Order;
import cn.tarena.gm.pojo.OrderItem;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理订单的mapper
 * @author Administrator
 *
 */
@Repository
@Mapper
public interface OrderMapper {
	@Select("select * from orders where user_id=#{userId}")
	public List<Order> findAllByUserId(Integer userId);
	@Select("select * from orderitem where order_id=#{orderId}")
	public List<OrderItem> findItemByOrderId(String orderId);

	public Order findOrderById(String orderId);

	@Delete("delete from orders where id=#{orderId}")
	public void deleteOrder(String orderId);
	@Delete("delete from orderitem where order_id=#{orderId}") 
	public void deleteOrderItem(String orderId); 
	@Update("update orders set paystate=#{state} where id=#{orderId}")
	public void updatePaystate(@Param("orderId") String r6_Order, @Param("state") int i);
}
