package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.Goodstype;
import com.ssm.mapper.GoodsTypeMapper;
import com.ssm.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeMapper gtm;
    /*
显示商品种类
 */
    @Override
    public PageInfo<Goodstype> goodsShow(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Goodstype> list=gtm.goodstypeShow();
        return new PageInfo<>(list);
    }

    /*
    添加商品种类
     */
    @Override
    public boolean addGoodstype(Goodstype goodstype) {
        Goodstype findgoodstype=gtm.findGoodtype(goodstype.getTypename());
        if(findgoodstype!=null){
            return false;
        }else{
            return gtm.addGoodstype(goodstype);
        }
    }

    /*
    按名字找商品种类
     */
    @Override
    public Goodstype findGoodtype(String typename) {
        Goodstype goodstype=gtm.findGoodtype(typename);
        return goodstype;
    }


    /*
    删除商品种类
     */
    @Override
    public boolean delGoodstype(Goodstype goodstype) {
        if(goodstype==null){
            return false;
        }
        return gtm.delGoodstype(goodstype);
    }


/*
批量删除商品种类
 */
    @Override
    public boolean delmanyGoodstype(String[] ids) {
        if (ids.length == 0) {
            return false;
        }
        if (gtm.delmanyGoodstype(ids)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Goodstype> findAll() {
        return gtm.findAll();
    }
}
