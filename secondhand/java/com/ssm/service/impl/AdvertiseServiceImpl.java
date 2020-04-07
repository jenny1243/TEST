package com.ssm.service.impl;

import com.ssm.entity.Advertisement;
import com.ssm.entity.User;
import com.ssm.mapper.AdvertiseMapper;
import com.ssm.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class AdvertiseServiceImpl implements AdvertiseService {
@Autowired
    private AdvertiseMapper advertiseMapper;
    @Override
    public boolean uploadAd(Advertisement advertisement) {
        return advertiseMapper.uploadAd(advertisement);
    }

    @Override
    public List<User> userShow() {
        List<User> list = advertiseMapper.userShow();
        return list;
    }
}
