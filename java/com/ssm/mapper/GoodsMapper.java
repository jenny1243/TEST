package com.ssm.mapper;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    List<Goods> goodsShow();    //显示商品信息

    List<Goods> goodsfindByKey(@Param("key") String key);    //关键字查询

    boolean editGoods(Goods goods);   //编辑商品信息

    boolean delGoods(Goods goods);    //删除商品信息

    boolean delmanyGoods(String[] ids);//批量删除

    List<Goods> findAll();

    List<Goods> unconfirmgoodsShow();    //显示未审核商品信息

    List<Goods> confirmgoodsShow();    //显示已审核商品信息

   Goods goodfindById(@Param("id") String id);//按id查询
}
