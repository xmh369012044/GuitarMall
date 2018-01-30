package cn.tarena.gm.service;

import cn.tarena.gm.pojo.Product;

import java.util.List;



public interface ProductService {
	
	public List<Product> findAll();

	public List<Product> findProdList(String name, String category, String minprice, String maxprice);

	public Product findProdById(String id);

	public List<Product> findProdByPName(String prodname);

}
