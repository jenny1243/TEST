package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.Order;
import com.ssm.mapper.OrderMapper;
import com.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper om;
    /*
显示订单信息
 */
    @Override
    public PageInfo<Order> ordersShow(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Order> list=om.ordersShow();
        return new PageInfo<>(list);
    }
/*
按订单号查询订单
 */
    @Override
    public Order orderfindByKey(Integer page, Integer pageSize, int key) {
        PageHelper.startPage(page,pageSize);
        Order order=om.orderfindByKey(key);
        return order;
    }

    @Override
    public boolean delOrders(Order order) {
        if(order==null){
            return false;
        }
        return om.delOrders(order);
    }

    @Override
    public boolean delmanyOrders(String[] ids) {
        if (ids.length == 0) {
            return false;
        }
        if(om.delmanyOrders(ids)){
            return true;
        }
        return false;
    }

    @Override
    public List<Order> findAll() {
        return om.findAll();
    }
}
