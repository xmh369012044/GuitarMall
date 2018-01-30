package cn.tarena.gm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.tarena.gm.pojo.Product;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductMapper1 {

	Product findProdById(String id);
	@Update("update products set pnum=pnum-#{num} where id=#{id}")
	void updateProNum(@Param("id") String product_id, @Param("num") int buynum);
	

	
}
