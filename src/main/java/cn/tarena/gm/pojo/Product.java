package cn.tarena.gm.pojo;

public class Product {
	private String id;
	private String name;
	private double price;
	private String category;
	private int pnum;
	private String imgurl;
	private String description;
	@Override
	public int hashCode() {
		return id==null?0:id.hashCode();
	}
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		
		if(!(obj instanceof Product)){
			return false;
		}
		
		Product other = (Product)obj;
		if(id!=null&&id.equals(other.getId())){
			return true;
		}
		return false;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
