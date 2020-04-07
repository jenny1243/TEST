package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.Notice;
import com.ssm.mapper.NoticeMapper;
import com.ssm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public PageInfo<Notice> noticeShow(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Notice> list=noticeMapper.noticeShow();
        return new PageInfo<>(list);
    }

    @Override
    public boolean publishNotice(Notice notice) {

        return noticeMapper.publishNotice(notice);
    }

    @Override
    public boolean delNotice(Notice notice) {
        if(notice==null){
            return false;
        }
        return noticeMapper.delNotice(notice);
    }

    @Override
    public boolean delmanyNotice(String[] ids) {
        if(ids.length==0){
            return false;
        }
        if(noticeMapper.delmanyNotice(ids)){
            return true;
        }
        return false;
    }

    @Override
    public boolean editNotice(Notice notice) {
        if(notice==null){
            return false;
        }
        return noticeMapper.editNotice(notice);
    }

    @Override
    public List<Notice> findAll() {
        return noticeMapper.findAll();
    }
}
