package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.Goodstype;
import com.ssm.entity.User;
import com.ssm.service.GoodsTypeService;
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
@RequestMapping("/goodstype")
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService gts;

    @RequestMapping("/goodstypeShow")
    public String goodsShow(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer pageSize) {
        PageInfo<Goodstype> pageInfo = gts.goodsShow(page,pageSize);
        model.addAttribute("url", "/goodstype/goodstypeShow?page=");
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "goodstype_show";
    }

    /**
     * 添加商品种类信息
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage() {
        return "goodstype_add";
    }

    @RequestMapping("/addGoodstype")
    @ResponseBody
    public Map<String,String> addGoodstype(Goodstype goodstype) {
        boolean result=gts.addGoodstype(goodstype);
        Map<String,String> retMap = new HashMap<String, String>();
        if(!result){
            retMap.put("type","error");
            retMap.put("msg","该种类已经存在");
        }else {
            retMap.put("type", "success");
            retMap.put("msg", "添加成功");
        }
        return retMap;
    }

    /**
     * 删除商品种类信息
     * @return
     */
    @RequestMapping("/delGoodstype")
    @ResponseBody
    public Map<String,String> delGoodstype(Goodstype goodstype) {
        Map<String,String> retMap = new HashMap<String, String>();
        boolean result=gts.delGoodstype(goodstype);
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
     * 批量删除商品种类信息
     * @return
     */
    @RequestMapping("/delmanyGoodstype")
    @ResponseBody
    public Map<String,String> delmanyGoodstype(@RequestParam(name = "ids") String ids) {
        Map<String,String> retMap = new HashMap<String, String>();
        String[] strarry = ids.split(",");
        boolean result=gts.delmanyGoodstype(strarry);
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
     * Excile导出
     */
    @RequestMapping("/toGoodstypeExcel")
    @CrossOrigin
    public void export(HttpServletResponse response) throws IOException {

        // 查询到所有的数据
        List<Goodstype> list = gts.findAll();

        Workbook workbook = Excel_Util.exportGoodstypeExcel(list);
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
