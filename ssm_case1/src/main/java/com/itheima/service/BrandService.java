package com.itheima.service;

import com.itheima.domain.TbBrand;

import java.util.List;

/**
 * Created by tanshuai on 2019/6/16.
 */
public interface BrandService {
    /**
     * 查询所有品牌列表
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 保存品牌
     * @param brand
     */
    void save(TbBrand brand);
    
    List<TbBrand> search(TbBrand brand);
}
