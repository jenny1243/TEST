package com.ssm.mapper;

import com.ssm.entity.Advertisement;
import com.ssm.entity.User;

import java.util.List;

public interface AdvertiseMapper {
    boolean uploadAd(Advertisement advertisement);//上传广告图片

    List<User> userShow();
}
