package cn.tarena.gm.controller;

import cn.tarena.gm.pojo.Product;
import cn.tarena.gm.service.ProdService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Autowired
	private ProdService1 prod1;
	
	//其他页面的进如购物车通过这个方法
	@RequestMapping("/tocart")
	public String tocart(){		
		return "/order/cart";
	}
	//由商品页点击加入购物车出发的请求,请求路径/cart/addcart
	@RequestMapping("/addcart")
	public String addCart(String pid,HttpSession session,String buynum){
		Product prod = prod1.findProdById(pid);
		Map<Product,Integer> cart =null;
		if(session.getAttribute("cart")!=null){
			cart= (Map<Product, Integer>) session.getAttribute("cart");
		}else{
			cart=new HashMap<Product,Integer>();
			session.setAttribute("cart", cart);
		}
		Integer num =null;
		
		if(buynum==null){
			
			if(cart.containsKey(prod)){
				cart.put(prod, cart.get(prod)+1);
			}else{
				cart.put(prod, 1);
			}
		}else{
			num=Integer.parseInt(buynum);
			if(cart.containsKey(prod)){
				cart.put(prod, cart.get(prod)+num);
			}else{
				cart.put(prod, num);
			}
		}
		return "/order/cart";
	}
	//由购物车页面点击'-'或'+'号,输入框修改商品数量
	@RequestMapping("/edit")
	public String edit(String pid,String buynum,HttpSession session ){
		Map<Product,Integer> cart=(Map<Product, Integer>) session.getAttribute("cart");
		Product prod =new Product();
		prod.setId(pid);
		cart.put(prod, Integer.parseInt(buynum));	
		return "/order/cart";
	}
	//删除购物车中的商品
	@RequestMapping("/del")
	public String del(String pid,HttpSession session){
		Map<Product,Integer> cart=(Map<Product, Integer>) session.getAttribute("cart");
		Product prod =new Product();
		prod.setId(pid);
		cart.remove(prod);
		return "/order/cart";
	}
	@RequestMapping("/toaddorder")
	public String toaddOrder(){
		return "/order/order_add";
	}
	
}
