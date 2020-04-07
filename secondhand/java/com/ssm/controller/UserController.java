package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import com.ssm.util.Excel_Util;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;
    /*
    分页显示所有用户信息
     */

    @RequestMapping("/userShow")
    public String userShow(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer pageSize) {
        PageInfo<User> pageInfo = us.userShow(page,pageSize);
        model.addAttribute("url", "/user/userShow?page=");
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "user_show";

    }

    /**
     * 用户查找
     */
    @RequestMapping("/userfindByKey")
    public String schoolfindByKey(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer pageSize, @RequestParam(name = "key") String key) {
        PageInfo<User> pageInfo = us.userfindByKey(page, pageSize, key);
        model.addAttribute("url", "/user/userfindByKey?key=" + key + "&page=");
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "user_show";

    }




    /**
     * 删除用户信息
     * @return
     */
    @RequestMapping("/delUser")
    @ResponseBody
    public Map<String,String> delUser(User user) {
        Map<String,String> retMap = new HashMap<String, String>();
        boolean result=us.delUser(user);
        if(result){
            retMap.put("type","success");
            retMap.put("msg","删除成功");
            return retMap;
        }else {
            retMap.put("type","error");
            retMap.put("msg","删除失败");
            return retMap;
        }

    }

    /**
     * 批量删除用户信息
     * @return
     */
    @RequestMapping("/delmanyUser")
    @ResponseBody
    public Map<String,String> delmanyUser(@RequestParam(name = "ids") String ids) {
        Map<String,String> retMap = new HashMap<String, String>();
        String[] strarry = ids.split(",");
        boolean result=us.delmanyUser(strarry);
        if(result){
            retMap.put("type","success");
            retMap.put("msg","删除成功");
            return retMap;
        }else {
            retMap.put("type","error");
            retMap.put("msg","删除失败");
            return retMap;
        }

    }
    /**
     * 修改用户信息
     */
    @RequestMapping("/editPage")
    public String editPage(Model model, String id) {
        User user = us.userfindById(id);
        model.addAttribute("user", user);
        return "user_edit";
    }


    @RequestMapping("/editUser")
    @ResponseBody
    public Map<String,String> editUser(User user) {
        Map<String,String> retMap = new HashMap<String, String>();
        boolean result = us.editUser(user);
        if(result){
            retMap.put("type","success");
            retMap.put("msg","修改成功");
            return retMap;
        }else {
            retMap.put("type","error");
            retMap.put("msg","修改失败");
            return retMap;
        }
    }

    /**
     * Excile导出
     */
    @RequestMapping("/toExcel")
    @CrossOrigin
    public void export(HttpServletResponse response) throws IOException {

        // 查询到所有的数据
        List<User> list = us.findAll();

        Workbook workbook = Excel_Util.exportuserExcel(list);
        // 告诉浏览器 需要下载文件
        response.setHeader("Content-Disposition", "attachment;fileName=" + System.currentTimeMillis() + ".xlsx");
        //获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 输出表格数据
        workbook.write(outputStream);
        // 关闭资源
        outputStream.close();
        workbook.close();

    }


}
