package com.ssm.mapper;

import com.ssm.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    List<Order> ordersShow();    //显示订单信息
    Order orderfindByKey(int order_num);    //按订单号查询
    boolean delOrders(Order order);    //删除订单信息
    boolean delmanyOrders(String[] ids);//批量删除
    List<Order> findAll();
}
