package cn.tarena.gm.service.impl;

import cn.tarena.gm.service.ProdService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.gm.mapper.ProductMapper1;
import cn.tarena.gm.pojo.Product;
@Service
public class ProdService1Impl implements ProdService1 {
	@Autowired
	private ProductMapper1 prodMapper1;
	@Override
	public Product findProdById(String id) {
		
		return prodMapper1.findProdById(id);
	}

}
