package cn.tarena.gm.service.impl;

import cn.tarena.gm.mapper.ProductMapper;
import cn.tarena.gm.pojo.Product;
import cn.tarena.gm.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/10.
 */
@Service
public class ProdServiceImpl implements ProdService{
    @Autowired
    private ProductMapper prodMapper;
    @Override
    public Product findProdById(String id) {

        return prodMapper.findProdById(id);
    }
}
