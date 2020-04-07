package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.Goods;
import com.ssm.mapper.GoodsMapper;
import com.ssm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper gm;
/*
显示商品信息
 */
    @Override
    public PageInfo<Goods> goodsShow(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Goods> list=gm.goodsShow();
        return new PageInfo<>(list);
    }

    /*
根据关键词查找商品
 */
    @Override
    public PageInfo<Goods> goodsfindByKey(Integer page, Integer pageSize, String key) {
        PageHelper.startPage(page,pageSize);
        List<Goods> list=gm.goodsfindByKey(key);
        return new PageInfo<>(list);
    }

    /*
    发布商品信息
     */
    @Override
    public boolean addGoods(Goods goods) {
        return false;
    }

    /*
修改商品信息
 */
    @Override
    public boolean editGoods(Goods goods) {
        if(goods==null){
            return false;
        }
        return gm.editGoods(goods);
    }
    /*
    删除商品
     */
    @Override
    public boolean delGoods(Goods goods) {
        if(goods==null){
            return false;
        }
        return gm.delGoods(goods);
    }
    /*
      批量删除商品
       */
    @Override
    public boolean delmanyGoods(String[] ids) {
        if (ids.length == 0) {
            return false;
        }
        if (gm.delmanyGoods(ids)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Goods> findAll() {
        return gm.findAll();
    }
    /*
      查询未审核商品
       */
    @Override
    public PageInfo<Goods> unconfirmgoodsShow(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Goods> list=gm.unconfirmgoodsShow();
        return new PageInfo<>(list);
    }
    /*
        查询已审核商品
         */
    @Override
    public PageInfo<Goods> confirmgoodsShow(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Goods> list=gm.confirmgoodsShow();
        return new PageInfo<>(list);
    }

    @Override
    public Goods goodfindById(String id) {
        return gm.goodfindById(id);
    }


}
