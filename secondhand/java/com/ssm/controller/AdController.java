package com.ssm.controller;

import com.ssm.entity.User;

import com.ssm.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/advertisement")
public class AdController {

@Autowired
private AdvertiseService advertiseService;


    @RequestMapping("/uploadimage")
    public String uploadimage(Model model) {
        List<User> list=advertiseService.userShow();
        model.addAttribute("list",list);
        return "upload_image";
    }


}
