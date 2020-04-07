package com.ssm.service;


import com.github.pagehelper.PageInfo;
import com.ssm.entity.Goods;
import com.ssm.entity.Order;

import java.util.List;


public interface OrderService {
    PageInfo<Order> ordersShow(Integer page, Integer pageSize);    //显示订单信息
    Order orderfindByKey(Integer page, Integer pageSize, int key);    //关键字查询

    boolean delOrders(Order order);    //删除订单信息
    boolean delmanyOrders(String[] ids);//批量删除
    List<Order> findAll();
}
