package cn.tarena.gm.mapper;


import cn.tarena.gm.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

	public List<Product> findAll();

	public List<Product> findProdList1(@Param("pname") String pname, @Param("cate") String cate,
									   @Param("min") Double min, @Param("max") Double max);

	public List<Product> findProdList2(@Param("pname") String pname, @Param("cate") String cate,
									   @Param("min") Double min);

	public List<Product> findProdList3(@Param("pname") String pname, @Param("cate") String cate,
									   @Param("max") Double max);

	public List<Product> findProdList4(@Param("pname") String pname, @Param("cate") String cate);

	public Product findProdById(String id);
	
	public List<Product> findProdByPName(@Param("name") String pname);
}
