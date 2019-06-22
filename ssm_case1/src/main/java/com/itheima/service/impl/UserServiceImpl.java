package com.itheima.service.impl;

import com.itheima.dao.TbUserMapper;
import com.itheima.domain.TbUser;
import com.itheima.domain.TbUserExample;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tanshuai on 2019/6/16.
 */
@Service
@Transactional

public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public boolean login(TbUser user) {
        //登陆逻辑
        if(user==null){
            throw  new RuntimeException("没有数据");
        }
        //根据用户名和密码继续查询
        TbUserExample examle = new TbUserExample();
        TbUserExample.Criteria criteria = examle.createCriteria();
        //添加条件  where username = ? and password = ?
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<TbUser> users = userMapper.selectByExample(examle);
        if(user==null||users.size()<1){
            throw new RuntimeException("用户名或密码错误");
        }
        return true;
    }
}