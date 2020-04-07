package com.ssm.controller;

import com.ssm.entity.Admin;
import com.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     *登录信息提交
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> login(Admin admin, HttpServletRequest request){
        Map<String,String> retMap = new HashMap<String, String>();
        if(admin == null){
            retMap.put("type","error");
            retMap.put("msg","请填写正确的用户信息");
            return retMap;
        }
        /*
        用户名为空
         */
        if(StringUtils.isEmpty(admin.getAdminname())){
            retMap.put("type","error");
            retMap.put("msg","请输入用户");
            return retMap;
        }
        /*
        密码为空
         */
        if(StringUtils.isEmpty(admin.getAdminpwd())){
            retMap.put("type","error");
            retMap.put("msg","请输入密码");
            return retMap;
        }
        /*
        通过得到的用户名去数据库中查询数据(admin1为数据库中查询出来的数据）
         */
        Admin admin1 = adminService.findAdminByName(admin.getAdminname());
        if(admin1 == null){
            retMap.put("type","error");
            retMap.put("msg","用户名不存在");
            return retMap;
        }
        /*
        查出来的密码和输入的密码不匹配
         */
        if(!admin.getAdminpwd().equals(admin1.getAdminpwd())){
            retMap.put("type","error");
            retMap.put("msg","密码错误");
            return retMap;
        }
        /*
        成功登录，将用户信息存入Session
         */
        request.getSession().setAttribute("admin",admin1);
        retMap.put("type","success");
        retMap.put("msg","登录成功,正在进入系统");
        return retMap;
    }

    /**
     * 注册信息提交
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> register(Admin admin){
        boolean result=adminService.registAdmin(admin);
        Map<String,String> retMap = new HashMap<String, String>();
        if(!result){
            retMap.put("type","error");
            retMap.put("msg","该用户已经被注册");
        }else {
            retMap.put("type", "success");
            retMap.put("msg", "注册成功");
        }
        return retMap;
    }

/*
退出登录
 */
    @RequestMapping("/logout")
    public void logout(HttpServletResponse response, HttpServletRequest request) {
        request.getSession().setAttribute("admin", null);
        try {
            request.getRequestDispatcher("loginpage").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @RequestMapping("/loginpage")
    public String loginPage(HttpServletRequest request) {
        return "login";
    }
}
