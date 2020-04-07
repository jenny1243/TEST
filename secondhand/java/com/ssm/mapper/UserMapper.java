package com.ssm.mapper;

import com.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> userShow();    //显示用户信息
    List<User> userfindByKey(@Param("key") String key);    //关键字查询
    User userfindById(@Param("id") String id);//按id查询用户
    boolean editUser(User user);   //编辑用户信息
    boolean delUser(User user);    //删除用户信息
    boolean delmanyUser(String[] ids);//批量删除
    List<User> findAll();
}
