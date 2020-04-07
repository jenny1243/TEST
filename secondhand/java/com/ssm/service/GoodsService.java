package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.Goods;

import java.util.List;

public interface GoodsService {
    PageInfo<Goods> goodsShow(Integer page, Integer pageSize);    //显示商品信息
    PageInfo<Goods> goodsfindByKey(Integer page, Integer pageSize, String key);    //关键字查询
    boolean  addGoods(Goods goods);    //添加商品
    boolean editGoods(Goods goods);   //编辑商品信息
    boolean delGoods(Goods goods);    //删除商品信息
    boolean delmanyGoods(String[] ids);//批量删除
    List<Goods> findAll();
    PageInfo<Goods> unconfirmgoodsShow(Integer page, Integer pageSize);    //显示未审核商品信息
    PageInfo<Goods> confirmgoodsShow(Integer page, Integer pageSize);    //显示已审核商品信息
    Goods goodfindById(String id);
}
