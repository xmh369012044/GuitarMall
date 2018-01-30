package cn.tarena.gm.service.impl;

import cn.tarena.gm.mapper.ProductMapper;
import cn.tarena.gm.pojo.Product;
import cn.tarena.gm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  
	@Autowired
	private ProductMapper productMapper;


	public List<Product> findAll() {
		return productMapper.findAll();
	}

	public List<Product> findProdList(String name, String category, String minprice, String maxprice) {
		String pname="";
		String cate="";
		Double min=null;
		Double max=null;
		if(name!=null&&!"".equals(name.trim())){
			pname=name.trim();
		}
		if(category!=null&&!"".equals(category.trim())){
			cate=category.trim();
		}
		if(minprice!=null&&!"".equals(minprice.trim())){
			min=Double.parseDouble(minprice.trim());
		}
		if(maxprice!=null&&!"".equals(maxprice.trim())){
			max=Double.parseDouble(maxprice.trim());
		}
		
		//分为min/max是否为空四种情况
		if(min!=null && max!=null){
			return productMapper.findProdList1(pname,cate,min,max);
		}else if(min!=null && max==null){
			return productMapper.findProdList2(pname,cate,min);
		}else if(min==null && max!=null){
			return productMapper.findProdList3(pname,cate,max);
		}else{
			return productMapper.findProdList4(pname,cate);
		}
		
	   
	}
	//按id号查询商品详情
	
	public Product findProdById(String id) {
		
		return productMapper.findProdById(id);
	}

	@Override
	public List<Product> findProdByPName(String name) {
		String pname="";
		if(name!=null&&!"".equals(name.trim())){
			pname=name.trim();
		}		
		return productMapper.findProdByPName(pname);
	}
}
