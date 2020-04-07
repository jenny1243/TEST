package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.User;

import java.util.List;

public interface UserService {
    PageInfo<User> userShow(Integer page, Integer pageSize);    //显示用户信息
    PageInfo<User> userfindByKey(Integer page, Integer pageSize, String key);    //关键字查询
    User userfindById(String id);            //按照用户id查询
    boolean editUser(User user);   //编辑用户信息
    boolean delUser(User user);    //删除用户信息
    boolean delmanyUser(String[] ids);//批量删除
    List<User> findAll();
}
