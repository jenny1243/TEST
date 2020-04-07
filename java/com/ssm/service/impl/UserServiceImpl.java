package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.User;
import com.ssm.mapper.UserMapper;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;
    /*
    显示所有用户
     */
    @Override
    public PageInfo<User> userShow(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<User> list = um.userShow();
        return new PageInfo<>(list);
    }
/*
根据关键字查询用户信息
 */
    @Override
    public PageInfo<User> userfindByKey(Integer page, Integer pageSize, String key) {
       PageHelper.startPage(page,pageSize);
       List<User> list =um.userfindByKey(key);
        return new PageInfo<>(list);
    }

    @Override
    public User userfindById(String id) {
        return um.userfindById(id);
    }


    @Override
    public boolean editUser(User user) {
        if(user==null){
            return false;
        }
        return um.editUser(user);
    }

    @Override
    public boolean delUser(User user) {
        if(user==null){
            return false;
        }
        return um.delUser(user);
    }

    @Override
    public boolean delmanyUser(String[] ids) {
        if (ids.length == 0) {
            return false;
        }
        if (um.delmanyUser(ids)) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return um.findAll();
    }
}
