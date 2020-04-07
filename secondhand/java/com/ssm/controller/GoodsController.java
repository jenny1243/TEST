package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.Goods;
import com.ssm.entity.User;
import com.ssm.service.GoodsService;
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
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService gs;
    /*
    分页显示所有商品信息
     */
    @RequestMapping("/goodsShow")
    public String goodsShow(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer pageSize) {
        PageInfo<Goods> pageInfo = gs.goodsShow(page,pageSize);
        model.addAttribute("url", "/goods/goodsShow?page=");
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "goods_show";
    }
    /*
   查找商品信息
    */
    @RequestMapping("/goodsfindByKey")
    public String goodsfindByKey(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer pageSize,@RequestParam(name = "key") String key) {
        PageInfo<Goods> pageInfo = gs.goodsfindByKey(page, pageSize, key);
        model.addAttribute("url", "/goods/goodsfindByKey?key=" + key + "&page=");
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "goods_show";
    }


    /**
     * 删除商品信息
     * @return
     */
    @RequestMapping("/delGoods")
    @ResponseBody
    public Map<String,String> delGoods(Goods good) {
        Map<String,String> retMap = new HashMap<String, String>();
        boolean result=gs.delGoods(good);
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
     * 批量删除商品信息
     * @return
     */
    @RequestMapping("/delmanyGoods")
    @ResponseBody
    public Map<String,String> delmanyGoods(@RequestParam(name = "ids") String ids) {
        Map<String,String> retMap = new HashMap<String, String>();
        String[] strarry = ids.split(",");
        boolean result=gs.delmanyGoods(strarry);
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

    /*
分页显示未审核商品信息
 */
    @RequestMapping("/unconfirmShow")
    public String unconfirmShow(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Goods> pageInfo =gs.goodsShow(page,pageSize);
        model.addAttribute("url", "/confirm/unconfirmShow?page=");
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "unconfirm_show";
    }

    /*
分页显示已审核商品信息
 */
    @RequestMapping("/confirmShow")
    public String confirmShow(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Goods> pageInfo = gs.confirmgoodsShow(page,pageSize);
        model.addAttribute("url", "/confirm/confirmShow?page=");
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "confirm_show";
    }

    @RequestMapping("/showoneGood")
    public  String showoneGood(Model model,String id){
        Goods goods=gs.goodfindById(id);
        model.addAttribute("goods",goods);
        return "showone_good";
    }



    /**
     * Excile导出
     */
    @RequestMapping("/toGoodsExcel")
    @CrossOrigin
    public void export(HttpServletResponse response) throws IOException {

        // 查询到所有的数据
        List<Goods> list = gs.findAll();

        Workbook workbook = Excel_Util.exportGoodsExcel(list);
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
