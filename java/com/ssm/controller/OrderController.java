package com.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.ssm.entity.Goods;
import com.ssm.entity.Order;
import com.ssm.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService os;

    /*
    分页显示所有订单
     */
    @RequestMapping("/ordersShow")
    public String ordersShow(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer pageSize) {
        PageInfo<Order> pageInfo = os.ordersShow(page,pageSize);
        model.addAttribute("url", "/order/ordersShow?page=");
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "orders_show";


    }
/*
按订单号查询订单
 */
@RequestMapping("/orderfindByKey")
    public  String orderfindByKey(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer pageSize, @RequestParam(name = "key") int key) {
        Order order=os.orderfindByKey(page,pageSize,key);
        model.addAttribute("url", "/order/orderfindByKey?page=");
        model.addAttribute("order", order);
        return "orders_show";
}

    /**
     * 删除订单信息
     * @return
     */
    @RequestMapping("/delOrders")
    @ResponseBody
    public Map<String,String> delOrders(Order order) {
        Map<String,String> retMap = new HashMap<String, String>();
        boolean result=os.delOrders(order);
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
     * 批量删除订单信息
     * @return
     */
    @RequestMapping("/delmanyOrders")
    @ResponseBody
    public Map<String,String> delmanyOrders(@RequestParam(name = "ids") String ids) {
        Map<String,String> retMap = new HashMap<String, String>();
        String[] strarry = ids.split(",");
        boolean result=os.delmanyOrders(strarry);
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
     * Excle导出
     */
    @RequestMapping("/toOrdersExcel")
    @CrossOrigin
    public void export(HttpServletResponse response) throws IOException {

        // 查询到所有的数据
        List<Order> list = os.findAll();

        Workbook workbook = Excel_Util.exportOrdersExcel(list);
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
