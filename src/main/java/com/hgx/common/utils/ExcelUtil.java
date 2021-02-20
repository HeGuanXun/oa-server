package com.hgx.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    //发送响应流方法
    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取打了Desc注解的字典属性列表
     *
     * @return 字典属性列表
     */
    public static <T> String[] getFixedVoList(Class<T> c) {
        try {
            T cls = c.newInstance();
            Field[] fields = c.getDeclaredFields();
            List<String> fixedVoList = new ArrayList<>();
            for (Field field : fields) {
                ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
                if (apiModelProperty != null) {
                    fixedVoList.add(apiModelProperty.value());
                }
            }
            String[] field = new String[fixedVoList.size()];
            for (int i = 0; i < fixedVoList.size(); i++) {
                field[i] = fixedVoList.get(i);
            }
            return field;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param list
     * @param title
     * @param sheetName
     * @param fileName
     * @param response
     */
    @JsonBackReference
    public static <T> String export(List<T> list, Field[] fields, String[] title, String sheetName, String fileName, HttpServletResponse response) {
        String[][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> stringObjectMap = toJsonString(list.get(i));
            content[i] = new String[fields.length];
            for (int j = 0; j < fields.length; j++) {
                String name = fields[j].getName();
                if (!name.equals("id")) {
                    Object value;
                    if (fields[j].getType().getName().equals("java.util.Date")) {
                        value = stringObjectMap.get(name);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        value = sdf.format(value);
                    } else {
                        value = stringObjectMap.get(name);
                    }
                    content[i][j - 1] = String.valueOf(value);
                }
            }
        }
        if (title != null) {
            //创建HSSFWorkbook
            ExcelUtil.getHSSFWorkbook(sheetName, title, content, response, fileName);
        }
        return null;
    }

    public static HashMap<String, Object> toJsonString(Object t) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        Field[] fields = t.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                objectObjectHashMap.put(field.getName(), field.get(t));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return objectObjectHashMap;
    }

    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public static void getHSSFWorkbook(String sheetName, String[] title, String[][] values, HttpServletResponse response, String fileName) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        //响应到客户端
        try {
            ExcelUtil.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}