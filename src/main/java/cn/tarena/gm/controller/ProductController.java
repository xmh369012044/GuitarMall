package cn.tarena.gm.controller;

import cn.tarena.gm.pojo.Product;
import cn.tarena.gm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController extends BaseController{
	
	@Autowired
	private ProductService productService;
	//查询所有商品
	@RequestMapping("/prodList")
	public String findAll(Model model){
		List<Product> productList=productService.findAll();
		model.addAttribute("productList", productList);
		return "/product/prod_list";
	}
	
	@RequestMapping("/findList")
	public String findProdList(String name,String category,
			String minprice,String maxprice,Model model){
		System.out.println(name+category+minprice+maxprice+"#");
		List<Product> productList=productService.findProdList(name,category,minprice,maxprice);
		model.addAttribute("productList", productList);
		model.addAttribute("name", name);
		model.addAttribute("cate", category);
		model.addAttribute("min", minprice);
		model.addAttribute("max", maxprice);		
		return "/product/prod_list";
	}
	
	@RequestMapping("prodInfoList")
	public String prodInfoList(String id,Model model){
		Product product=productService.findProdById(id);
		model.addAttribute("product", product);	
		int i=1;
		model.addAttribute("bnum", i);
		return "/product/Nprod_info";
	}
	
	@RequestMapping("/query")
	public String findProdByPName(String prodname,Model model){
		List<Product> productList=productService.findProdByPName(prodname);
		model.addAttribute("productList", productList);
		return "/product/prod_list";
	}
	

}
