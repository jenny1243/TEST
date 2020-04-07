package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.Goodstype;

import java.util.List;

public interface GoodsTypeService {
    PageInfo<Goodstype> goodsShow(Integer page, Integer pageSize);    //显示用户信息

    boolean addGoodstype(Goodstype goodstype);//增加商品种类

    Goodstype findGoodtype(String typename);//按照种类名查找

    boolean delGoodstype(Goodstype goodstype);    //删除商品种类信息

    boolean delmanyGoodstype(String[] ids);//批量删除商品种类

    List<Goodstype> findAll();
}
