package com.ssm.util;


import com.ssm.entity.Goods;
import com.ssm.entity.Goodstype;
import com.ssm.entity.Order;
import com.ssm.entity.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Excel_Util {
    /**
     * 解析excel的数据
     *
     * @param inputStream : 对应excel的表格的输入流
     * @throws IOException
     */
    public static List<List<String>> parseExcel(FileInputStream inputStream) throws IOException {
        // 返回的数据
        List<List<String>> data = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(inputStream);
        // 2.获取sheet1的对象,从0开始
        Sheet sheetAt = workbook.getSheetAt(0);
        // 3.获取最大的行数
        int lastRowNum = sheetAt.getLastRowNum();
        // 4.从指定行开始遍历
        // 从第二行开始,下标从0开始
        for (int i = 1; i <= lastRowNum; i++) {
            // 行数据
            List<String> rowData = new ArrayList<>();
            // 获取当前行对象
            Row row = sheetAt.getRow(i);
            // 获取行的最大列
            short lastCellNum = row.getLastCellNum();
            // 从指定的列开始遍历列,列下标0开始
            for (int j = 0; j < lastCellNum; j++) {

                // 获取单元格对象
                Cell cell = row.getCell(j);
                String value = "";
                // 读取数据
                if (cell != null) {
                    // 验证单元格的类型
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            // 表格中返回的数字类型是科学计数法因此不能直接转换成字符串格式
                            value = new BigDecimal(cell.getNumericCellValue()).toPlainString();
                            break;
                        case FORMULA:
                            // 和数字类似
                            value = new BigDecimal(cell.getNumericCellValue()).toPlainString();
                        case STRING:
                            value = cell.getStringCellValue();
                            break;
                        case BLANK:
                            value = "";
                            break;
                        case BOOLEAN:
                            value = Boolean.toString(cell.getBooleanCellValue());
                            break;
                        case ERROR:
                            value = "error";
                            break;
                        default:
                            value = "undefined";
                            break;
                    }
                }
                rowData.add(value);
            }
            data.add(rowData);
        }
        return data;
    }


    /**
     * 创建用户信息excel表格
     */
    public static Workbook exportuserExcel(List<User> users) {
        // 1. 创建workbook对象
        Workbook workbook = new XSSFWorkbook();
        // 2. 创建sheet
        Sheet sheet = workbook.createSheet("用户信息列表");
        // 3. 创建表头
        // 创建行
        Row row = sheet.createRow(0);
        // 依次创建列
        row.createCell(0).setCellValue("用户名");
        row.createCell(1).setCellValue("昵称");
        row.createCell(2).setCellValue("联系电话");
        row.createCell(3).setCellValue("账号创建时间");
        row.createCell(4).setCellValue("最近登录时间");
        row.createCell(5).setCellValue("账号状态");
        row.createCell(6).setCellValue("发布的商品数量");
        row.createCell(7).setCellValue("信用分");
        row.createCell(8).setCellValue("邮箱");
        row.createCell(9).setCellValue("密码");


        // 遍历数据创建对应的行
        int create = 1;
        for (User user : users) {
            Row row1 = sheet.createRow(create);
            // 依次创建列
            row1.createCell(0).setCellValue(user.getUsername());
            row1.createCell(1).setCellValue(user.getNickname());
            row1.createCell(2).setCellValue(user.getPhone());
            row1.createCell(3).setCellValue(user.getCreate_time());
            row1.createCell(4).setCellValue(user.getLast_login_time());
            row1.createCell(5).setCellValue(user.getStatus());
            row1.createCell(6).setCellValue(user.getGoods_num());
            row1.createCell(7).setCellValue(user.getCredit_score());
            row1.createCell(8).setCellValue(user.getEmail());
            row1.createCell(9).setCellValue(user.getPassword());

            // 行数+1
            create++;
        }

        return workbook;
    }

    /**
     * 创建商品信息excel表格
     */
    public static Workbook exportGoodsExcel(List<Goods> goods) {
        // 1. 创建workbook对象
        Workbook workbook = new XSSFWorkbook();
        // 2. 创建sheet
        Sheet sheet = workbook.createSheet("商品信息列表");
        // 3. 创建表头
        // 创建行
        Row row = sheet.createRow(0);
        // 依次创建列
        row.createCell(0).setCellValue("发布者");
        row.createCell(1).setCellValue("商品名称");
        row.createCell(2).setCellValue("出售价格");
        row.createCell(3).setCellValue("原价");
        row.createCell(4).setCellValue("发布时间");
        row.createCell(5).setCellValue("商品状态");
        row.createCell(6).setCellValue("商品库存量");
        row.createCell(7).setCellValue("下架时间");
        row.createCell(8).setCellValue("描述");


        // 遍历数据创建对应的行
        int create = 1;
        for (Goods good : goods) {
            Row row1 = sheet.createRow(create);
            // 依次创建列
            row1.createCell(0).setCellValue(good.getUser().getUsername());
            row1.createCell(1).setCellValue(good.getName());
            row1.createCell(2).setCellValue(good.getPrice());
            row1.createCell(3).setCellValue(good.getReal_price());
            row1.createCell(4).setCellValue(good.getRelease_date());
            row1.createCell(5).setCellValue(good.getStatus());
            row1.createCell(6).setCellValue(good.getRepertory());
            row1.createCell(7).setCellValue(good.getRemove_date());
            row1.createCell(8).setCellValue(good.getDescrible());

            // 行数+1
            create++;
        }

        return workbook;
    }

    /**
     * 创建商品信息excel表格
     */
    public static Workbook exportGoodstypeExcel(List<Goodstype> goodstypes) {
        // 1. 创建workbook对象
        Workbook workbook = new XSSFWorkbook();
        // 2. 创建sheet
        Sheet sheet = workbook.createSheet("商品种类信息列表");
        // 3. 创建表头
        // 创建行
        Row row = sheet.createRow(0);
        // 依次创建列
        row.createCell(0).setCellValue("编号");
        row.createCell(1).setCellValue("种类名");


        // 遍历数据创建对应的行
        int create = 1;
        for (Goodstype goodstype : goodstypes) {
            Row row1 = sheet.createRow(create);
            // 依次创建列
            row1.createCell(0).setCellValue(goodstype.getId());
            row1.createCell(1).setCellValue(goodstype.getTypename());

            // 行数+1
            create++;
        }

        return workbook;
    }

    /**
     * 创建订单信息excel表格
     */
    public static Workbook exportOrdersExcel(List<Order> orders) {
        // 1. 创建workbook对象
        Workbook workbook = new XSSFWorkbook();
        // 2. 创建sheet
        Sheet sheet = workbook.createSheet("订单信息列表");
        // 3. 创建表头
        // 创建行
        Row row = sheet.createRow(0);
        // 依次创建列
        row.createCell(0).setCellValue("买家");
        row.createCell(1).setCellValue("订单编号");
        row.createCell(2).setCellValue("订单总价");
        row.createCell(3).setCellValue("订单状态");
        row.createCell(4).setCellValue("订单创建时间");
        row.createCell(5).setCellValue("备注");


        // 遍历数据创建对应的行
        int create = 1;
        for (Order order : orders) {
            Row row1 = sheet.createRow(create);
            // 依次创建列
            row1.createCell(0).setCellValue(order.getUser().getUsername());
            row1.createCell(1).setCellValue(order.getOrder_num());
            row1.createCell(2).setCellValue(order.getOrder_price());
            row1.createCell(3).setCellValue(order.getOrderstate().getState());
            row1.createCell(4).setCellValue(order.getOrder_date());
            row1.createCell(5).setCellValue(order.getOrder_message());

            // 行数+1
            create++;
        }

        return workbook;
    }
}
