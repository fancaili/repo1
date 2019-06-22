package com.itheima.controller;

import com.itheima.domain.TbBrand;
import com.itheima.model.Result;
import com.itheima.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tanshuai on 2019/6/16.
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    
    @RequestMapping("/findAll")
    public Result findAll(){
        List<TbBrand> brandList = brandService.findAll();
        return  new Result(true,"成功",brandList);//{"success":true,"message":"成功","data":[{}]}
    }
    @RequestMapping("/saveBrand")
    public Result saveBrand(TbBrand brand){
        try {
            brandService.save(brand);
            return new Result(true,"保存成功!");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"保存失败!");
        }
    }
    @RequestMapping("/search")
    public Result search(TbBrand brand){
        List<TbBrand> brandList = brandService.search(brand);
        return new Result(true,"成功",brandList);
    }
}
