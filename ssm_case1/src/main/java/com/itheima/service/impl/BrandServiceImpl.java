package com.itheima.service.impl;

import com.itheima.dao.TbBrandMapper;
import com.itheima.domain.TbBrand;
import com.itheima.domain.TbBrandExample;
import com.itheima.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tanshuai on 2019/6/16.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    
    @Autowired
    private TbBrandMapper brandMapper;
    
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public void save(TbBrand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public List<TbBrand> search(TbBrand brand) {
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if(brand!=null){
            if(brand.getName()!=null&&!"".equals(brand.getName())){
                criteria.andNameLike("%"+brand.getName()+"%");// and name like 'a'
            }
            if(brand.getFirstChar()!=null&&!"".equals(brand.getFirstChar())){
                criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");// and firstChar like 'a'
            }
        }
        List<TbBrand> brandList = brandMapper.selectByExample(example);
        return brandList;
    }
}
