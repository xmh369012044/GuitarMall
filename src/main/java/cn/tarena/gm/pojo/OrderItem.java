package cn.tarena.gm.pojo;

public class OrderItem {
	private String orderid;
	private String productid;
	private int buynum;
	public String getOrder_id() {
		return orderid;
	}
	public void setOrder_id(String order_id) {
		this.orderid = order_id;
	}
	public String getProduct_id() {
		return productid;
	}
	public void setProduct_id(String product_id) {
		this.productid = product_id;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
}
