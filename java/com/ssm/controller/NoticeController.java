package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.Notice;
import com.ssm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/noticeShow")
    public String noticeShow(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer pageSize) {
        PageInfo<Notice> pageInfo = noticeService.noticeShow(page,pageSize);
        model.addAttribute("url", "/notice/noticeShow?page=");
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "notice_show";

    }
    @RequestMapping("/addPage")
    public String addPage() {
        return "notice_add";
    }

    @RequestMapping("/noticePub")
    @ResponseBody
    public Map<String,String> noticePub(Notice notice) {
        boolean result=noticeService.publishNotice(notice);
        Map<String,String> retMap = new HashMap<String, String>();
        if(!result){
            retMap.put("type","error");
            retMap.put("msg","发布失败");
        }else {
            retMap.put("type", "success");
            retMap.put("msg", "发布成功");
        }
        return retMap;
    }


}
