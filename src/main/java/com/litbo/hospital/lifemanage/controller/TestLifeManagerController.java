package com.litbo.hospital.lifemanage.controller;

import com.itextpdf.text.DocumentException;
import com.litbo.hospital.common.utils.poi.ExportPdfUtil;
import com.litbo.hospital.common.utils.poi.PdfData;
import com.litbo.hospital.lifemanage.bean.LifeManage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lifeManage")
public class TestLifeManagerController {
    @GetMapping("/pdf")
    public void test(HttpServletResponse response){
        BigDecimal price = new BigDecimal("186478.568486");
        LifeManage u1 = new LifeManage("1","张三",18,"2018-11-07",price);
        LifeManage u2 = new LifeManage("2","李四",20,"2018-11-06",price);
        LifeManage u3 = new LifeManage("3","王五",40,"",price);
        List<LifeManage> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        PdfData data = new PdfData();
        data.setRows(list);

        List<String> titles = new ArrayList<>();
        titles.add("ID");
        titles.add("姓名");
        titles.add("年龄");
        titles.add("日期");
        titles.add("价铬");
        data.setTitles(titles);

        String name = "这是一张测试的pdf";
        data.setName(name);

        try {
            ExportPdfUtil.exportExcel(response,"1.pdf",data);
        } catch (IOException | IllegalAccessException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
